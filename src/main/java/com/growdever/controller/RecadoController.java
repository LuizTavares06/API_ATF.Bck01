package com.growdever.controller;


import com.growdever.entities.dto.RecadoDto;
import com.growdever.service.RecadoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


@RestController
@RequestMapping("/recado")
@CrossOrigin("*")
public class RecadoController {

    @Autowired
    private RecadoService service;

    @GetMapping("/all")
    public ResponseEntity<List<RecadoDto>> getAll(){
        List<RecadoDto> recadosDto = service.getAll();
        return ResponseEntity.ok().body(recadosDto);
    }

    @GetMapping()
    public ResponseEntity<RecadoDto> getById(
            @RequestParam(value = "id")  Integer id){
        RecadoDto recadoDtoReturn = service.getById(id);
        return ResponseEntity.ok().body(recadoDtoReturn);
    }

    @GetMapping()
    public ResponseEntity<RecadoDto> getFiltered(
            @RequestParam (value = "palavraChave") String palavraChave){
        RecadoDto recadoDtoReturn = service.filter(palavraChave);
        return ResponseEntity.ok().body(recadoDtoReturn);
    }


    @PostMapping
    public ResponseEntity<?> create(@RequestBody RecadoDto recadoDto){
        return service.create(recadoDto);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        service.delete(id);
        return ResponseEntity.ok().build();
    }


    @PutMapping("{id}")
    public ResponseEntity<RecadoDto> update(@PathVariable Integer id , @RequestBody RecadoDto recadoDto) {
        RecadoDto recadoDtoReturn = service.update(id, recadoDto);
        return ResponseEntity.ok().body(recadoDtoReturn);
    }
}
