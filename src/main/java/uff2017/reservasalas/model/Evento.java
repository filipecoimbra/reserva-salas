/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uff2017.reservasalas.model;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author fabri
 */
public class Evento {

    private int idEvento;
    private String nome;
    private int idTipoEvento;
    private String descricao;
    private String horaInicio;
    private String horaFim;
    private Date data;
    private int maxParticipantes;
    private boolean isAprovado;
    private Espaco espaco;
    private ArrayList<TipoUsuario> tiposUsuarioPermitidos;
    private TipoEvento tipoEvento;

    public Evento() {

    }

    public TipoEvento getTipoEvento() {
        return tipoEvento;
    }

    public void setTipoEvento(TipoEvento tipoEvento) {
        this.tipoEvento = tipoEvento;
    }

    public ArrayList<TipoUsuario> getTiposUsuarioPermitidos() {
        return tiposUsuarioPermitidos;
    }

    public void setTiposUsuarioPermitidos(ArrayList<TipoUsuario> tiposUsuarioPermitidos) {
        this.tiposUsuarioPermitidos = tiposUsuarioPermitidos;
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

    public int getIdTipoEvento() {
        return idTipoEvento;
    }

    public void setIdTipoEvento(int idTipoEvento) {
        this.idTipoEvento = idTipoEvento;
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

    public int getIdEspaco() {
        return espaco.getIdEspaco();
    }

    public void setIdEspaco(int idEspaco) {
        this.espaco.setIdEspaco(idEspaco);
    }

}
