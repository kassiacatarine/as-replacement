package br.edu.utfpr.asreplacement.entities;

import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Teacher
 */
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Teacher {
    private Long id;
    private String name;
    
}