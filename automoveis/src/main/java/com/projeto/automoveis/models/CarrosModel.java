package com.projeto.automoveis.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "carros")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CarrosModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String modelo;

    private String ano;

    private String fip;

    private String cor;
}
