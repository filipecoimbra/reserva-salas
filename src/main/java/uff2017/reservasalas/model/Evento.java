/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uff2017.reservasalas.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author fabri
 */
@Entity
public class Evento implements Serializable {

    @Id
    @GeneratedValue
    @Column
    private int idEvento;
    @Column
    private String nome;
    //private int idTipoEvento;
    @Column
    private String descricao;
    @Column
    private String horaInicio;
    @Column
    private String horaFim;
    @Column
    private Date data;
    @Column
    private int maxParticipantes;
    @Column
    private boolean isAprovado;
    @ManyToOne
    private Espaco espaco;
    @Column
    boolean ativo;
    @ManyToMany
    private List<TipoUsuario> tiposUsuarioPermitidos;

    //private TipoEvento tipoEvento;
    public Evento() {
        
    }

    public List<TipoUsuario> getTiposUsuarioPermitidos() {
        return tiposUsuarioPermitidos;
    }

    public void setTiposUsuarioPermitidos(List<TipoUsuario> tiposUsuarioPermitidos) {
        this.tiposUsuarioPermitidos = tiposUsuarioPermitidos;
    }
        
    public Espaco getEspaco() {
        return espaco;
    }

    public void setEspaco(Espaco espaco) {
        this.espaco = espaco;
    }

    public int getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(int idEvento) {
        this.idEvento = idEvento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }

    public String getHoraFim() {
        return horaFim;
    }

    public void setHoraFim(String horaFim) {
        this.horaFim = horaFim;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public int getMaxParticipantes() {
        return maxParticipantes;
    }

    public void setMaxParticipantes(int maxParticipantes) {
        this.maxParticipantes = maxParticipantes;
    }

    public boolean isIsAprovado() {
        return isAprovado;
    }

    public void setIsAprovado(boolean isAprovado) {
        this.isAprovado = isAprovado;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

}
