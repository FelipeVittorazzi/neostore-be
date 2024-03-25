package com.neostore.domain.service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpClient.Version;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.JsonNode;
import lombok.Data;

public class CnpjReceitaAPIService {

    private static final HttpClient httpClient = HttpClient.newBuilder()
            .version(Version.HTTP_2)
            .build();

    public static CnpjResponse consultarCNPJ(String cnpj) throws IOException, InterruptedException {
        String url = "https://receitaws.com.br/v1/cnpj/" + cnpj;
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create(url))
                .header("Accept", "application/json")
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() == 200) {
            ObjectMapper mapper = new ObjectMapper();
            JsonNode node = mapper.readTree(response.body());
            CnpjResponse cnpjResponse = new CnpjResponse();
            if (node.has("nome")) {
                cnpjResponse.setNome(node.get("nome").asText());
            }
            if (node.has("email")) {
                cnpjResponse.setEmail(node.get("email").asText());
            }
            return cnpjResponse;
        } else {
            throw new RuntimeException("Falha na requisição: " + response.statusCode());
        }
    }

    @Data
    public static class CnpjResponse {
        private String nome;
        private String email;

    }
}
