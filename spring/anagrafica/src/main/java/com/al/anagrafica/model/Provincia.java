package com.al.anagrafica.model;

import javax.persistence.*;

@Entity
public class Provincia {

    @Id
//    @GeneratedValue(generator="ProvSeq")
//    @SequenceGenerator(name="ProvSeq",sequenceName="PROVINCIA_SEQ", allocationSize=1)
    private int idProvincia;

    private String nome;
    private String sigla;
    private String regione;

    public Provincia() {
    }


    public int getIdProvincia() {
        return idProvincia;
    }

    public void setIdProvincia(int idProvincia) {
        this.idProvincia = idProvincia;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public String getRegione() {
        return regione;
    }

    public void setRegione(String regione) {
        this.regione = regione;
    }

    @Override
    public String toString() {
        return "Provincia{" +
                "id=" + idProvincia +
                ", nome='" + nome + '\'' +
                ", sigla='" + sigla + '\'' +
                ", regione='" + regione + '\'' +
                '}';
    }
}
