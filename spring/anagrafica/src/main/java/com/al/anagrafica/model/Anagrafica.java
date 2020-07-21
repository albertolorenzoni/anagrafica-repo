package com.al.anagrafica.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Anagrafica {
    @Id
    @GeneratedValue(generator="Seq")
    @SequenceGenerator(name="Seq",sequenceName="ANAGRAFICA_SEQ", allocationSize=1)
    private long idAnagrafica;
    private String nome;
    private String cognome;
    private String indirizzo;
    private int numCivico;
    private int idComune;
    private int idProvincia;
    private String comune;
    private String provincia;

    public Anagrafica() {
    }

    public Anagrafica(String nome, String cognome, String indirizzo, int numCivico, int idComune, int idProvincia) {
        this.nome = nome;
        this.cognome = cognome;
        this.indirizzo = indirizzo;
        this.numCivico = numCivico;
        this.idComune = idComune;
        this.idProvincia = idProvincia;
    }

    public long getIdAnagrafica() {
        return idAnagrafica;
    }

    public void setIdAnagrafica(long idAnagrafica) {
        this.idAnagrafica = idAnagrafica;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getIndirizzo() {
        return indirizzo;
    }

    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }

    public int getNumCivico() {
        return numCivico;
    }

    public void setNumCivico(int numCivico) {
        this.numCivico = numCivico;
    }

    public int getIdComune() {
        return idComune;
    }

    public void setIdComune(int idComune) {
        this.idComune = idComune;
    }

    public int getIdProvincia() {
        return idProvincia;
    }

    public void setIdProvincia(int idProvincia) {
        this.idProvincia = idProvincia;
    }

    public String getComune() {
        return comune;
    }

    public void setComune(String comune) {
        this.comune = comune;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }
}