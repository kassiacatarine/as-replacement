package br.edu.utfpr.asreplacement.viewmodels;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DocenteModel {
    private Long id;
    private String nome;
    private String documentoDocente;
}
