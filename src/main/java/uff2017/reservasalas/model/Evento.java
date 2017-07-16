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
import javax.persistence.FetchType;
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
    @ManyToMany(fetch = FetchType.EAGER)
    private List<TipoUsuario> tiposUsuarioPermitidos;
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Usuario> usuariosInscritos;

    public Evento() {

    }

    public Evento(int id, String nome, String desc, String horaini,
            String horafim, Date data, int partici, boolean aprovado, Espaco espaco,
            boolean ativo, List<TipoUsuario> tipouser, List<Usuario> users) {

        this.idEvento = id;
        this.nome = nome;
        this.descricao = desc;
        this.horaInicio = horaini;
        this.horaFim = horafim;
        this.data = data;
        this.maxParticipantes = partici;
        this.isAprovado = aprovado;
        this.espaco = espaco;
        this.ativo = ativo;
        this.tiposUsuarioPermitidos = tipouser;
        this.usuariosInscritos = users;

    }

    @Override
    public Evento clone() {
        return new Evento(idEvento, nome, descricao, horaInicio, horaFim, data,
                maxParticipantes, isAprovado, espaco, ativo, tiposUsuarioPermitidos,
                usuariosInscritos);
    }

    public void restore(Evento evento) {
        this.idEvento = evento.getIdEvento();
        this.nome = evento.getNome();
        this.descricao = evento.getDescricao();
        this.horaInicio = evento.getHoraInicio();
        this.horaFim = evento.getHoraFim();
        this.data = evento.getData();
        this.maxParticipantes = evento.getMaxParticipantes();
        this.isAprovado = evento.isAprovado;
        this.espaco = evento.getEspaco();
        this.ativo = evento.isAtivo();
        this.tiposUsuarioPermitidos = evento.getTiposUsuarioPermitidos();
        this.usuariosInscritos = evento.getUsuariosInscritos();
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

    public List<Usuario> getUsuariosInscritos() {
        return usuariosInscritos;
    }

    public void setUsuariosInscritos(List<Usuario> usuariosInscritos) {
        this.usuariosInscritos = usuariosInscritos;
    }

}
