package com.growdever.entities;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString

public class Recado {
    private Integer id;
    private String titulo;
    private String descricao;
    private Boolean statusRecado;
}