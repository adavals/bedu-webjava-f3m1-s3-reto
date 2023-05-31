package org.bedu.java.backend.sesion3.reto.model;

import java.util.HashMap;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
public class Currency {
    @NotBlank
    @Size(min = 3)
    private String shortName;

    private HashMap<String,Double> exchange;

    public Currency(String shortName, HashMap<String,Double> exchange) {
        this.shortName = shortName;
        this.exchange = exchange;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public HashMap<String,Double> getExchange() {
        return exchange;
    }

    public void setExchange(HashMap<String, Double> exchange) {
        this.exchange = exchange;
    }
}
