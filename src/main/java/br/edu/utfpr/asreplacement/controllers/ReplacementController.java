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
import org.springframework.web.bind.annotation.RequestParam;

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
                Unirest.get("http://localhost:8081/servico/docentes").asJson().getBody().toString(),
                DocenteModel[].class);

        ReplacementModel arraySubstituicoes[] = new Gson().fromJson(
                Unirest.get("http://localhost:8081/servico/plano").asJson().getBody().toString(),
                ReplacementModel[].class);

        data.addAttribute("aulas", arrayAulas);
        data.addAttribute("docentes", arrayDocentes);
        data.addAttribute("planos", arraySubstituicoes);

        return "replacement-view";
    }

    @PostMapping ("/replacement/new")
    public String criar(ReplacementModel plano, @RequestParam String aulaId, @RequestParam String requerenteId) throws UnirestException {

        AulaModel aula = new AulaModel();
        Long aId = Long.parseLong(aulaId.replace(",", ""));
        System.out.println(aId);
        aula.setId(aId);

        DocenteModel requerente = new DocenteModel();
        Long rId = Long.parseLong(requerenteId.replace(",", ""));
        System.out.println(rId);
        requerente.setId(rId);

        plano.setAula(aula);
        plano.setRequerente(requerente);

        Unirest.post("http://localhost:8081/servico/plano")
            .header("Content-type", "application/json")
            .header("accept", "application/json")
            .body(new Gson().toJson(plano, ReplacementModel.class))
            .asJson();
        return "";
        //return "redirect:/replacement";
    }


    @PostMapping ("/replacement/aprove")
    public String criar(@RequestParam String id) throws UnirestException {

            Unirest.put("http://localhost:8081/servico/plano/aprovar/{id}")
                .routeParam("id", id.replace(".", ""))
                .asJson();

        return "redirect:/replacement";
    }

    @GetMapping("/replacement/delete")
    public String excluir(@RequestParam String id) throws UnirestException {
        Unirest.delete("http://localhost:8081/servico/plano/{id}").routeParam("id", id.replace(".", "")).asJson();

        return "redirect:/replacement";
    }
}