package com.al.anagrafica.controller;

import com.al.anagrafica.model.Provincia;
import com.al.anagrafica.repositories.ProvinciaRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class ProvinciaController {

    private ProvinciaRepository repository;

    public ProvinciaController(ProvinciaRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/province")
    List<Provincia> all() {

        return repository.findAll();
    }

//    @PostMapping("/province")
//    void add(@RequestBody Provincia provincia) {
//        repository.save(provincia);
//    }
}
