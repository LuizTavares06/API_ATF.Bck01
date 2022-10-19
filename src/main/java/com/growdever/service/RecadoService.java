package com.growdever.service;

import com.growdever.controller.Resposta;
import com.growdever.entities.Recado;
import com.growdever.entities.dto.RecadoDto;
import com.growdever.exeception.ExecaoDePaginaNaoEncontrada;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service

public class RecadoService {

    private List<Recado> recados = new ArrayList<>();



    @Autowired
    private Resposta rp;
    private Integer id = 0;

    public List<RecadoDto> getAll(){
        List<RecadoDto> recadosDto =new ArrayList<>();
        for (Recado recado : recados) {
        RecadoDto recadoDto = new RecadoDto(recado.getId(), recado.getTitulo(), recado.getDescricao(), recado.getStatusRecado());
        recadosDto.add(recadoDto);
        }
        return recadosDto;
        }

//      public RecadoDto filter(String palavraChave) {
//        RecadoDto recadoEncontrado = new RecadoDto();
//
//
//
//        recados.stream()
//                .filter(e -> e.getTitulo().equals(palavraChave))
//                ;
//        return recadoEncontrado;
//      }

    public RecadoDto filter(String palavraChave) {
        RecadoDto recadoEncontrado = new RecadoDto();
        for (Recado recado : recados) {
            if (recado.getTitulo().equals(palavraChave)) {
                recadoEncontrado.setId(recado.getId());
                recadoEncontrado.setTitulo(recado.getTitulo());
                recadoEncontrado.setDescricao(recado.getDescricao());
            }

        }
        if(Objects.isNull(recadoEncontrado.getId()) || Objects.isNull(recadoEncontrado.getTitulo()) || Objects.isNull(recadoEncontrado.getDescricao())){
            throw new ExecaoDePaginaNaoEncontrada("Registro não encontrado");
        } else {
            return recadoEncontrado;
        }
    }

    public RecadoDto getById(Integer id) {
        RecadoDto recadoEncontrado = new RecadoDto();
        for (Recado recado : recados) {
            if (recado.getId().equals(id)) {
                recadoEncontrado.setId(recado.getId());
                recadoEncontrado.setTitulo(recado.getTitulo());
                recadoEncontrado.setDescricao(recado.getDescricao());
            }

            }
        if(Objects.isNull(recadoEncontrado.getId()) || Objects.isNull(recadoEncontrado.getTitulo()) || Objects.isNull(recadoEncontrado.getDescricao())){
            throw new ExecaoDePaginaNaoEncontrada("Registro não encontrado");
        } else {
            return recadoEncontrado;
        }
        }


    public ResponseEntity<?> create(RecadoDto recadoDto){
        if(recadoDto.getTitulo().equals("") || recadoDto.getTitulo().equals(null)){
            rp.setMensagem("Titulo é obrigatório!");
            return new ResponseEntity<Resposta>(rp, HttpStatus.BAD_REQUEST);
        }else if (recadoDto.getDescricao().equals("") || recadoDto.getDescricao().equals(null)){
            rp.setMensagem("Descrição é obrigatório!");
            return new ResponseEntity<Resposta>(rp, HttpStatus.BAD_REQUEST);
        }else{
            ++id;
            recadoDto.setId(id);
            recadoDto.setStatusRecado(false);
            Recado recado = new Recado(recadoDto.getId(), recadoDto.getTitulo(), recadoDto.getDescricao(), recadoDto.getStatusRecado());
            recados.add(recado);
            return new ResponseEntity<Recado>(recado, HttpStatus.CREATED);
        }

    }

    public void delete(Integer id){
        recados.removeIf(recado -> recado.getId().equals(id));
    }



    public RecadoDto update(Integer id, RecadoDto recadoDto){
        for(Recado recado : recados){
            if(recado.getId().equals(id)){
                recado.setTitulo(recadoDto.getTitulo());
                recado.setDescricao(recadoDto.getDescricao());
                recado.setStatusRecado(recadoDto.getStatusRecado());
            }
        }
        return recadoDto;
    }

}


