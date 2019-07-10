package br.edu.utfpr.asreplacement.controllers;

import java.util.Date;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.edu.utfpr.asreplacement.viewmodels.AulaListModel;
import br.edu.utfpr.asreplacement.viewmodels.AulaModel;
import br.edu.utfpr.asreplacement.viewmodels.TurmaModel;

/**
 * LessonController
 */
@Controller
public class LessonController {

    @GetMapping("/lesson")
    public String inicial(Model data) throws JsonSyntaxException, UnirestException {

        AulaListModel arrayAulas[] = new Gson().fromJson(
                Unirest.get("http://localhost:8081/servico/aulas").asJson().getBody().toString(),
                AulaListModel[].class);

        data.addAttribute("aulas", arrayAulas);

        TurmaModel arrayTurmas[] = new Gson().fromJson(
                Unirest.get("http://localhost:8081/servico/turmas").asJson().getBody().toString(), TurmaModel[].class);

        data.addAttribute("turmas", arrayTurmas);

        return "lesson-view";
    }

    @PostMapping("/lesson/new")
    public String criar(AulaModel aula) throws UnirestException {
        System.out.println(new Gson().toJson(aula, AulaModel.class));

        HttpResponse<JsonNode> response = Unirest.post("http://localhost:8081/servico/aulas")
            .header("Accept", "application/json")
            .header("Content-Type", "application/json")
            .body(new Gson().toJson(aula, AulaModel.class))
            .asJson();

        System.out.println(response.getStatusText());

        return "";
    }

    @GetMapping("/lesson/delete")
    public String excluir(@RequestParam String id) throws UnirestException {
        Unirest.delete("http://localhost:8081/servico/aulas/{id}").routeParam("id", id.replace(".", "")).asJson();

        return "redirect:/lesson";
    }

    // @GetMapping("/pais/prepara-alterar")
    // public String preparaAlterar(@RequestParam int id, Model data) throws JsonSyntaxException, UnirestException {

    //     AulaModel aulaExistente = new Gson().fromJson(Unirest.get("http://localhost:8081/servico/aulas/{id}")
    //             .routeParam("id", String.valueOf(id)).asJson().getBody().toString(), AulaModel.class);

    //     data.addAttribute("paisAtual", aulaExistente);

    //     AulaModel arrayAulas[] = new Gson().fromJson(
    //             Unirest.get("http://localhost:8081/servico/aulas").asJson().getBody().toString(), AulaModel[].class);

    //     data.addAttribute("aulas", arrayAulas);

    //     return "pais-view-alterar";
    // }

    // @PostMapping("/lesson/alterar")
    // public String alterar(AulaModel aulaAlterado) throws UnirestException {

    //     Unirest.put("http://localhost:8081/servico/aulas/{id}").routeParam("id", String.valueOf(aulaAlterado.getId()))
    //             .header("Content-type", "application/json").header("accept", "application/json")
    //             .body(new Gson().toJson(aulaAlterado, AulaModel.class)).asJson();

    //     return "redirect:/lesson";
    // }
}