package com.alura.challenge.conversor.Menu.SolicitudConversor;

import com.alura.challenge.conversor.Menu.Menu.ConvertidorDeMonedas;
import com.google.gson.annotations.SerializedName;
import java.util.Map;


public class Solicitudes extends ConvertidorDeMonedas {


    public static class ExchangeRateResponse {
        @SerializedName("base_code")
        private String base;
        @SerializedName("conversion_rates")
        private Map<String, Double> rates;

        public String getBase() {
            return base;
        }

        public Map<String, Double> getRates() {
            return rates;
        }
    }

}


