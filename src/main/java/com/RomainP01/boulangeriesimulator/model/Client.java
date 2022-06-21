package com.RomainP01.boulangeriesimulator.model;

import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@Accessors(chain=true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "client")
public class Client implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    @Column( name = "nom")
    private String nom;
    @Column( name = "prenom")
    private String prenom;
    @Column( name = "telephone")
    private String telephone;
}