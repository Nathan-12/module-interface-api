package org.nathan.moduleinterfaceapi.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.nathan.moduleinterfaceapi.client.FullCountryInfoClient;
import org.nathan.moduleinterfaceapi.model.ArrayOftCountryInfo;
import org.nathan.moduleinterfaceapi.model.TCountryInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.net.MalformedURLException;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1/full-country-info")
@Tag(name = "Informações dos países")
public class FullCountryInfoController {

    @Autowired
    private FullCountryInfoClient fullCountryInfoClient;

    @Operation(summary = "Buscar informações de um país pelo código ISO.",
            description = "Recebe um código ISO e retorna as informações de um país.",
    responses = {
            @ApiResponse(description = "Sucesso", responseCode = "200", content = @Content(schema = @Schema(implementation = TCountryInfo.class))),
            @ApiResponse(description = "Erro interno do servidor", responseCode = "500", content = @Content)
    })
    @GetMapping
    public TCountryInfo getCountryInfoByISO(@RequestParam("isoCode") String isoCode) throws MalformedURLException {
        return fullCountryInfoClient.getCountryInfoByISO(isoCode);
    }

    @GetMapping("/all")
    public ArrayOftCountryInfo getAllCountries() throws MalformedURLException {
        return fullCountryInfoClient.getAllCountries();
    }
}
