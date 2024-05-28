package com.alura.challenge.conversor.Menu.SolicitudConversor;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class PrincipalParaCliente{

    private static final HttpClient client = HttpClient.newHttpClient();

    public static String get(String url) throws IOException, InterruptedException{
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        if (response.statusCode() != 200) {
            throw new IOException("Codigo inesperado " + response.statusCode());
        }

        return response.body();
    }
}
