package com.al.anagrafica.repositories;

import com.al.anagrafica.model.Comune;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ComuneRepository extends JpaRepository<Comune, Integer> {

    List<Comune> findByIdProvincia(int provId);

}
