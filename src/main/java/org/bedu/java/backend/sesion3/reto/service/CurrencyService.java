package org.bedu.java.backend.sesion3.reto.service;

import org.bedu.java.backend.sesion3.reto.exception.CurrencyNotFoundException;
import org.springframework.stereotype.Service;
import org.bedu.java.backend.sesion3.reto.model.Currency;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class CurrencyService {
    private final Map<String, Currency> currency;

    public CurrencyService() {
        currency = new HashMap<>();
        HashMap <String,Double> exchangeMXN = new HashMap<>();
        exchangeMXN.put("USD",0.057 );
        exchangeMXN.put("EUR",0.053 );
        HashMap <String,Double> exchangeUSD = new HashMap<>();
        exchangeUSD.put("MXN", 17.66 );
        exchangeUSD.put("EUR", 0.93);
        HashMap <String,Double> exchangeEUR = new HashMap<>();
        exchangeEUR.put("USD",1.07);
        exchangeEUR.put("MXN",18.95);

        currency.put("MXN", new Currency("MXN", exchangeMXN));
        currency.put("USD", new Currency("USD", exchangeUSD));
        currency.put("EUR", new Currency("USD", exchangeEUR));
    }

    public List<Currency> getAll() {
        return new LinkedList<>(currency.values());
    }

    public Set<String> getAllShortNames() {
        return currency.keySet();
    }

    public boolean exists(String shortName) {
        return currency.containsKey(shortName.toUpperCase());
    }

    public HashMap<String, Double> getCurrencyExchange(String shortName) {
        if (!exists(shortName)) {
            throw new CurrencyNotFoundException(shortName);
        }

        return currency.get(shortName.toUpperCase()).getExchange();
    }

    public Map<String, Double> getCurrencyExchangeQuantity(String shortName, Double quantity) {
        if (!exists(shortName)) {
            throw new CurrencyNotFoundException(shortName);
        }

        return currency.get(shortName.toUpperCase()).getExchange().entrySet().stream()
                .collect(Collectors.toMap(e -> e.getKey(), e -> e.getValue() * quantity));

    }




}
