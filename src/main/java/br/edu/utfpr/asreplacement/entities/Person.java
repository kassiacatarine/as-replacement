package br.edu.utfpr.asreplacement.entities;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Person
 */
@Data
@NoArgsConstructor
@MappedSuperclass
public abstract class Person {
    @Id
    @GeneratedValue
    protected Long id;
    protected String nome;
    protected String email;
}