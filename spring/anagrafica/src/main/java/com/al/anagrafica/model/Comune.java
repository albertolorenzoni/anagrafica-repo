package com.al.anagrafica.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Comune {

    @Id
//    @GeneratedValue(generator="ComSeq")
//    @SequenceGenerator(name="ComSeq",sequenceName="COMUNE_SEQ", allocationSize=1)
    private int idComune;
    private String nome;
    private int idProvincia;

    public Comune() {
    }

    public int getIdComune() {
        return idComune;
    }

    public void setIdComune(int idComune) {
        this.idComune = idComune;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdProvincia() {
        return idProvincia;
    }

    public void setIdProvincia(int idProvincia) {
        this.idProvincia = idProvincia;
    }

    @Override
    public String toString() {
        return "Comune{" +
                "idComune=" + idComune +
                ", nome='" + nome + '\'' +
                ", idProvincia=" + idProvincia +
                '}';
    }
}
