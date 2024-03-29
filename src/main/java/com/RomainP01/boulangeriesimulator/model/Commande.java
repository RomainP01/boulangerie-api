package com.RomainP01.boulangeriesimulator.model;

import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Collection;
import java.util.Date;

@Getter
@Setter
@Accessors(chain=true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "commande")
public class Commande implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    @JoinColumn(name = "client_fk")
    private Client client;
    @ManyToMany
    private Collection<Produit> produits;
    @Column( name = "date")
    private LocalDate date;
    @Column(name = "heure")
    private LocalTime heure;


}
