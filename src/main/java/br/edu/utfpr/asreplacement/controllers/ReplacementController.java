package br.edu.utfpr.asreplacement.controllers;

import br.edu.utfpr.asreplacement.viewmodels.AulaListModel;
import br.edu.utfpr.asreplacement.viewmodels.AulaModel;
import br.edu.utfpr.asreplacement.viewmodels.DocenteModel;
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
    public String inicial(Model data) throws UnirestException {

        AulaListModel arrayAulas[] = new Gson().fromJson(
                Unirest.get("http://localhost:8081/servico/aulas").asJson().getBody().toString(),
                AulaListModel[].class);

        DocenteModel arrayDocentes[] = new Gson().fromJson(
                Unirest.get("http://localhost:8081/servico/aulas").asJson().getBody().toString(),                
                //Unirest.get("http://localhost:8081/servico/docentes").asJson().getBody().toString(),
                DocenteModel[].class);

        ReplacementModel arraySubstituicoes[] = new Gson().fromJson(
                Unirest.get("http://localhost:8081/servico/aulas").asJson().getBody().toString(),                
                //Unirest.get("http://localhost:8081/servico/substituicoes").asJson().getBody().toString(),
                ReplacementModel[].class);

        data.addAttribute("aulas", arrayAulas);
        data.addAttribute("docentes", arrayDocentes);
        data.addAttribute("substituicoes", arraySubstituicoes);

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