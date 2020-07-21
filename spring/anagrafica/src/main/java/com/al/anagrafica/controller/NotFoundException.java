package com.al.anagrafica.controller;

public class NotFoundException  extends  RuntimeException{

    NotFoundException(Long id) {
        super("Could not find item with id: " + id);
    }
}
