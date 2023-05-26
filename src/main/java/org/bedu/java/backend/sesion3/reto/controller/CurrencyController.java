package org.bedu.java.backend.sesion3.reto.controller;

import org.bedu.java.backend.sesion3.reto.model.Currency;
import org.bedu.java.backend.sesion3.reto.service.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;
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

        // GET /currencies -> Obtener las monedas
        @GetMapping
        @ResponseStatus(HttpStatus.OK)
        public Set<String> getCurrencies() {
            return currency.getAllShortNames();
        }

    }
