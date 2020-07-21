package com.al.anagrafica.controller;

import com.al.anagrafica.model.Comune;
import com.al.anagrafica.repositories.ComuneRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class ComuneController {

    private ComuneRepository repository;

    public ComuneController(ComuneRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/comuni")
    List<Comune> all() {

        return repository.findAll();
    }

//    @GetMapping("/comuni/{id}")
//    Comune findById(@PathVariable int id) {
//
//        return repository.findById(id)
//                .orElseThrow(() -> new NotFoundException(id));
//    }
//
//    @PostMapping("/comuni")
//    void add(@RequestBody Comune comune) {
//        repository.save(comune);
//    }

    @GetMapping("/comuni/{idProv}")
    List<Comune> findByProv(@PathVariable int idProv) {

        return repository.findByIdProvincia(idProv);
    }

}
