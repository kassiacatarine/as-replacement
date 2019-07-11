package br.edu.utfpr.asreplacement.viewmodels;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * ReplacementModel
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReplacementModel {

    private Long id;
    private Long aulaId;
    private Long docenteId;
    private DocenteModel requerente;
    private AulaListModel aula;
    private boolean aprovado;
}