/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uff2017.reservasalas.model;

import java.util.ArrayList;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 * @author fabri
 */
@Entity
public class Espaco {

    @Id
    @GeneratedValue
    private int idEspaco;
    @Column(nullable = false)
    private int capacidade;
    @Column(nullable = false)
    private String localidade;
    @Column(nullable = false)
    private boolean ativo;

    //nao sei como faz coluna assim
//    private ArrayList<Recurso> recursos;
//
//    public ArrayList<Recurso> getRecursos() {
//        return recursos;
//    }
//
//    public void setRecursos(ArrayList<Recurso> recursos) {
//        this.recursos = recursos;
//    }
    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public Espaco() {

    }

    public int getIdEspaco() {
        return idEspaco;
    }

    public void setIdEspaco(int idEspaco) {
        this.idEspaco = idEspaco;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    public String getLocalidade() {
        return localidade;
    }

    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }

}
