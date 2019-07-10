package br.edu.utfpr.asreplacement.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

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
    @Id
    @GeneratedValue
    private Long id;
    @OneToOne
    private Lesson lesson;
    @ManyToOne
    private Teacher teacher;
}