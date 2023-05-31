package org.bedu.java.backend.sesion3.reto.exception;

public class CurrencyNotFoundException extends  RuntimeException{

    private String shortName;

    public CurrencyNotFoundException(String shortName) {
        this.shortName = shortName;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }



}
