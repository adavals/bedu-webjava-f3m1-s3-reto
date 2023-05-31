package org.bedu.java.backend.sesion3.reto.controller;

import org.bedu.java.backend.sesion3.reto.service.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@RestController
@RequestMapping("currencies")
@Validated
public class CurrencyController {
        private CurrencyService currency;

        @Autowired
        public CurrencyController(CurrencyService currency) {
            this.currency = currency;
        }

        // GET /currencies -> Get all currencies
        @GetMapping
        @ResponseStatus(HttpStatus.OK)
        public Set<String> getCurrencies() {
            return currency.getAllShortNames();
        }

        // GET /currencies/MXN -> Get currency exchanges
        @GetMapping("{shortName}")
        public HashMap<String, Double> getCurrencyExchangeByShortName(@PathVariable("shortName")  String shortName) {
            return currency.getCurrencyExchange(shortName);
        }

        // GET /currencies/MXN/exchanges/20 -> Currency exchanges of a quantity
        @GetMapping("{shortName}/exchanges/{quantity}")
        public Map<String, Double> getCurrencyExchangeQuantityByShortName(@PathVariable("shortName")  String shortName, @PathVariable("quantity")  Double quantity) {
            return currency.getCurrencyExchangeQuantity(shortName, quantity);
        }


    }
