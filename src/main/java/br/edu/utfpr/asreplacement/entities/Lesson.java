package br.edu.utfpr.asreplacement.entities;

import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Lesson
 */
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Lesson {
    private Long id;
    
}