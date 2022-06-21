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
@Table(name = "produit")
public class Produit implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    @Column( name = "label")
    private String label;
    @Column( name = "prix")
    private Float prix;
}
