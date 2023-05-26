package org.bedu.java.backend.sesion3.reto.service;

import org.springframework.stereotype.Service;
import org.bedu.java.backend.sesion3.reto.model.Currency;

import java.util.*;

@Service
public class CurrencyService {
    private Map<String, Currency> currency;

    public CurrencyService() {
        currency = new HashMap<String, Currency>();

        currency.put("MXN", new Currency("MXN", 1.0));
        currency.put("USD", new Currency("USD", 18.0));
        currency.put("EUR", new Currency("USD", 20.0));
    }

    public List<Currency> getAll() {
        return new LinkedList<Currency>(currency.values());
    }

    public Set<String> getAllShortNames() {
        return currency.keySet();
    }


}
