package com.CarteBucate.CarteBucate.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Entity
@Data
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name="carte")
public class CarteDeBucate {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String numeAutor;
    private String titluCarte;
    private String descriereCarte;
    private Float pret;

    @ManyToMany
    @JoinTable(
            name = "carte_reteta", // Join table to link CarteDeBucate and Reteta
            joinColumns = @JoinColumn(name = "carte_id"),
            inverseJoinColumns = @JoinColumn(name = "reteta_id")
    )
    private List<Reteta> retete;

}
