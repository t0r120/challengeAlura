package com.alura.challenge.conversor.Menu.Menu;

import com.alura.challenge.conversor.Menu.SolicitudConversor.PrincipalParaCliente;
import com.alura.challenge.conversor.Menu.SolicitudConversor.Solicitudes;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.Scanner;

public class ConvertidorDeMonedas {
    private static final String API_KEY = "549624902b81bb923503bc26";
    private static final String API_URL = "https://v6.exchangerate-api.com/v6/" + API_KEY + "/latest/";

    public static void main(String[] args) {


        System.out.println("""
                BIENVVENIDO
                ***********************************
                    CONVERSOR DE MONEDAS JAVA
                    ************************
                    1- Introduce la moneda base.
                    2- Introduce la moneda interes a cambiar.
                    3- Introduce el importe.
                   -----------------------------
                ***********************************""");
        Scanner scanner1 =  new Scanner(System.in);
        System.out.println(" Pulsa \"1\" para continuar: ");
        int input2 = scanner1.nextInt();

        while(input2 == 1) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Introduce la moneda principal: ");
            String monedaUno = scanner.nextLine().toUpperCase();

            System.out.println("Introduce la moneda de interes: ");
            String monedaDos = scanner.nextLine().toUpperCase();

            System.out.println("Introduce la cantidad a cambiar: ");
            double cantidad = scanner.nextDouble();

            try {
                String json = PrincipalParaCliente.get(API_URL + monedaUno);
                Gson gson = new Gson();
                Solicitudes.ExchangeRateResponse rateRespuesta = gson.fromJson(json, Solicitudes.ExchangeRateResponse.class);

                Double rate = rateRespuesta.getRates().get(monedaDos);
                if (rate != null) {
                    double cantidadConvertida = cantidad * rate;
                    System.out.println("Cantidad:  " + cantidad + " " + monedaUno + "///" + " " + cantidadConvertida + " " + monedaDos);
                } else {
                    System.out.println("Moneda invalida");
                }

            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("""
                    ¿Desea continuar?
                    ****************
                    Pulse 1 para continuar.
                    Pulse 2 para salir.
                    
                    """);

            Scanner scanner2 =  new Scanner(System.in);
            int input3 = scanner2.nextInt();

            if(input3 != 1) {
                break;
            }
        }
    }
}


