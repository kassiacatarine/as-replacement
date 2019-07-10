package br.edu.utfpr.asreplacement.controllers;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.edu.utfpr.asreplacement.viewmodels.AulaModel;

/**
 * LessonController
 */
@Controller
public class LessonController {

    @GetMapping("/lesson")
    public String inicial(Model data) throws JsonSyntaxException, UnirestException {

        AulaModel arrayAulas[] = new Gson()
                .fromJson(Unirest.get("http://localhost:8081/lesson").asJson().getBody().toString(), AulaModel[].class);

        data.addAttribute("aulas", arrayAulas);

        return "lesson-view";
    }

    @PostMapping("/lesson/new")
    public String criar(AulaModel pais) throws UnirestException {

        Unirest.post("http://localhost:8081/lesson").header("Content-type", "application/json")
                .header("accept", "application/json").body(new Gson().toJson(pais, AulaModel.class)).asJson();

        return "redirect:/lesson";
    }

    @GetMapping("/pais/excluir")
    public String excluir(@RequestParam int id) throws UnirestException {

        Unirest.delete("http://localhost:8081/servico/pais/{id}").routeParam("id", String.valueOf(id)).asJson();

        return "redirect:/pais";
    }

    @GetMapping("/pais/prepara-alterar")
    public String preparaAlterar(@RequestParam int id, Model data) throws JsonSyntaxException, UnirestException {

        AulaModel aulaExistente = new Gson().fromJson(Unirest.get("http://localhost:8081/lesson/{id}")
                .routeParam("id", String.valueOf(id)).asJson().getBody().toString(), AulaModel.class);

        data.addAttribute("paisAtual", aulaExistente);

        AulaModel arrayAulas[] = new Gson()
                .fromJson(Unirest.get("http://localhost:8081/lesson").asJson().getBody().toString(), AulaModel[].class);

        data.addAttribute("aulas", arrayAulas);

        return "pais-view-alterar";
    }

    @PostMapping("/lesson/alterar")
    public String alterar(AulaModel aulaAlterado) throws UnirestException {

        Unirest.put("http://localhost:8081/lesson/{id}").routeParam("id", String.valueOf(aulaAlterado.getId()))
                .header("Content-type", "application/json").header("accept", "application/json")
                .body(new Gson().toJson(aulaAlterado, AulaModel.class)).asJson();

        return "redirect:/lesson";
    }
}