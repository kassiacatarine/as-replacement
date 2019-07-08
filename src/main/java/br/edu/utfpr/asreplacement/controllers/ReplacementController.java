package br.edu.utfpr.asreplacement.controllers;

import com.google.gson.Gson;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import br.edu.utfpr.asreplacement.viewmodels.ReplacementModel;

/**
 * ReplacementController
 */
@Controller
public class ReplacementController {

    @GetMapping ("/replacement")
    public String inicial(Model data) {

        // data.addAttribute("paises", paises);

        return "replacement-view";
    }

    @PostMapping ("/replacement/new")
    public String criar(ReplacementModel pais) throws UnirestException {

            Unirest.post("http://localhost:8081/replacement")
                .header("Content-type", "application/json")
                .header("accept", "application/json")
                .body(new Gson().toJson(pais, ReplacementModel.class))
                .asJson();

        return "redirect:/replacement";
    }

    
}