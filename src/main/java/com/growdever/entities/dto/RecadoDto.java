package com.growdever.entities.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString

public class RecadoDto {
        private Integer id;
        private String titulo;
        private String descricao;
        private Boolean statusRecado;
}
