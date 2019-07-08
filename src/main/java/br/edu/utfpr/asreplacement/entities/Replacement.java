package br.edu.utfpr.asreplacement.entities;

import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Replacement
 */
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Replacement {
    private Long id;
    private Lesson lesson;
    private Teacher teacher;
}