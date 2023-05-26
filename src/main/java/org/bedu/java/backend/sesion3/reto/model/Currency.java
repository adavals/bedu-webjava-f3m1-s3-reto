package org.bedu.java.backend.sesion3.reto.model;

public class Currency {
    private String shortName;

    private Double exchange;

    public Currency(String shortName, Double exchange) {
        this.shortName = shortName;
        this.exchange = exchange;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public Double getExchange() {
        return exchange;
    }

    public void setExchange(Double exchange) {
        this.exchange = exchange;
    }
}
