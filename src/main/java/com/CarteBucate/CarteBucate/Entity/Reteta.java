package com.CarteBucate.CarteBucate.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.*;

@Entity
@Data
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name="reteta")
public class Reteta {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String nume;
    private String categorie;
    private String descriere;
    private Integer timp;

    @ManyToMany(cascade = CascadeType.ALL)
    private List<Ingredient> ingredients = new ArrayList<>();

    @ManyToMany(mappedBy = "retete") // This is the inverse side of the relationship
    private List<CarteDeBucate> cartiDeBucate;

}

