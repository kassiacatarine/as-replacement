package br.edu.utfpr.asreplacement.viewmodels;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * TurmaModel
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TurmaModel {
    private Long id;
    private String codigo;
    private String disciplinaNome;
}