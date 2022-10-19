package com.growdever.exeception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class StandartError {
        private Instant timeStamp;
        private Integer status;
        private String error;
        private String message;
        private String path;

}
