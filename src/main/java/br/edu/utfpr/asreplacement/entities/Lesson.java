package br.edu.utfpr.asreplacement.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

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
    @Id
    @GeneratedValue
    private Long id;
    @Temporal(TemporalType.DATE)
    private Date date;
    private String name;
}