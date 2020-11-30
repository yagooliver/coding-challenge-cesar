package com.cesar.demo.application.amendment.controller;

import com.cesar.demo.application.amendment.Amendment;
import com.cesar.demo.application.amendment.AmendmentRepository;
import okhttp3.Headers;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

@RestController
@RequestMapping("/api/")
@EnableOAuth2Client
public class AmendmentController {
    @Autowired
    private AmendmentRepository _repository;
    private final OkHttpClient httpClient = new OkHttpClient();

    @GetMapping("/amendment")
    @PreAuthorize("hasHole('USER')")
    public String Get(){
        Iterable<Amendment> list = _repository.findAll();
        if(((ArrayList)list).size() > 0) {
            Request request = new Request.Builder()
                    .url("http://www.portaltransparencia.gov.br/api-de-dados/emendas?ano=2020&pagina=1")
                    .addHeader("Accept", "application/json")  // add request headers
                    .addHeader("chave-api-dados", "55f4ffb9b18eef9aff06a2ec76ecacf5")
                    .build();

            try (Response response = httpClient.newCall(request).execute()) {

                if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);

                // Get response headers
                Headers responseHeaders = response.headers();
                for (int i = 0; i < responseHeaders.size(); i++) {
                    System.out.println(responseHeaders.name(i) + ": " + responseHeaders.value(i));
                }

                // Get response body
                System.out.println(response.body().string());
                return (response.body().string());
            }catch (Exception e){

            }
        }
        return "";
    }
}
