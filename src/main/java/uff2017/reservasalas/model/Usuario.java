/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uff2017.reservasalas.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author fabri
 */
@Entity
public class Usuario implements Serializable{

    @Id
    @GeneratedValue
    private int idUsuario;
    @Column
    private String nome;
    @Column
    private String login;
    @Column
    private String senha;
    @ManyToOne
    private PerfilUsuario perfilUsuario;
    @ManyToOne
    private TipoUsuario tipoUsuario;
    @Column
    private boolean ativo;

    public Usuario() {

    }

    public Usuario(int id, String nome, String login, String senha, PerfilUsuario perf, TipoUsuario tipo) {
        this.idUsuario = id;
        this.nome = nome;
        this.login = login;
        this.senha = senha;
        this.perfilUsuario = perf;
        this.tipoUsuario = tipo;
    }

    @Override
    public Usuario clone() {
        return new Usuario(idUsuario, nome, login, senha, perfilUsuario, tipoUsuario);
    }

    public void restore(Usuario usuario) {
        this.idUsuario = usuario.getIdUsuario();
        this.nome = usuario.getNome();
        this.login = usuario.getLogin();
        this.senha = usuario.getSenha();
        this.perfilUsuario = usuario.getPerfilUsuario();
        this.tipoUsuario = usuario.getTipoUsuario();
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public PerfilUsuario getPerfilUsuario() {
        return perfilUsuario;
    }

    public void setPerfilUsuario(PerfilUsuario perfilUsuario) {
        this.perfilUsuario = perfilUsuario;
    }

    public TipoUsuario getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(TipoUsuario tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }



}
