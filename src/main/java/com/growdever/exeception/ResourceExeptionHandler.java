package com.growdever.exeception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.Instant;

@ControllerAdvice //captura execçoes


public class ResourceExeptionHandler {

    @ExceptionHandler (ExecaoDePaginaNaoEncontrada.class)
    public ResponseEntity<StandartError> entidadeNaoEncontrada(
            ExecaoDePaginaNaoEncontrada objeto,
            HttpServletRequest request
    ){
        StandartError err = new StandartError();
        err.setTimeStamp(Instant.now()); //pega o horario atual
        err.setStatus(HttpStatus.NOT_FOUND.value());
        err.setError("A requisiçõa não deu certo pois oobejto esta vazio/null");
        err.setMessage(objeto.getMessage());
        err.setPath(request.getRequestURI()); // pega o caminho

        //retorna todas as informações juntas
       return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
    }
}
