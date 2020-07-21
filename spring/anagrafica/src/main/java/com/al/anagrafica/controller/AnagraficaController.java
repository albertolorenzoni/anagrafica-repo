package com.al.anagrafica.controller;

import com.al.anagrafica.model.Anagrafica;
import com.al.anagrafica.repositories.AnagraficaRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class AnagraficaController {
    private AnagraficaRepository repository;

    public AnagraficaController(AnagraficaRepository repository) {
        this.repository = repository;
    }


    @GetMapping("/anagrafica")
    List<Anagrafica> listAll() {
        return repository.findAll();
    }

    @GetMapping("/anagrafica/{id}")
    Anagrafica one(@PathVariable long id) {
        return repository.findById(id)
                .orElseThrow(() -> new NotFoundException(id));
    }

    @PostMapping("/anagrafica")
    void save(@RequestBody Anagrafica nuovaAnagrafica) {
        repository.save(nuovaAnagrafica);
    }

    @PutMapping("/anagrafica/{id}")
    Anagrafica update(@RequestBody Anagrafica nuovaAnagrafica, @PathVariable long id) {
        return repository.findById(id)
                .map(anagrafica -> {
                    anagrafica.setNome(nuovaAnagrafica.getNome());
                    anagrafica.setCognome(nuovaAnagrafica.getCognome());
                    anagrafica.setIdProvincia(nuovaAnagrafica.getIdProvincia());
                    anagrafica.setIdComune(nuovaAnagrafica.getIdComune());
                    anagrafica.setIndirizzo(nuovaAnagrafica.getIndirizzo());
                    anagrafica.setNumCivico(nuovaAnagrafica.getNumCivico());
                    return repository.save(anagrafica);
                })
                .orElseGet( () -> {
                    nuovaAnagrafica.setIdAnagrafica(id);
                    return repository.save(nuovaAnagrafica);
                });
    }

    @DeleteMapping("/anagrafica/{id}")
    void delete(@PathVariable long id) {
        repository.delete(repository.findById(id)
                .orElseThrow(() -> new NotFoundException(id)));
    }
}
