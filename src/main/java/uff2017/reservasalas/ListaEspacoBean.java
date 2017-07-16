/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uff2017.reservasalas;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Map;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import uff2017.reservasalas.dao.EspacoDAO;
import uff2017.reservasalas.model.Espaco;

/**
 *
 * @author fabri
 */
@Named
@SessionScoped
public class ListaEspacoBean implements Serializable {

    private ArrayList<Espaco> listaEspacos = new ArrayList<Espaco>();
    private EspacoDAO espacoDAO = new EspacoDAO();
    private Espaco espaco = new Espaco();
    private Espaco espacoBeforeEdit = null;
    private boolean edit;
    
    public void onload() {
        listaEspaco();
    }

    public void listaEspaco() {        
        listaEspacos = espacoDAO.listaEspacos();        
    }  
    
    public void edit(Espaco item) {
        espacoBeforeEdit = item.clone();
        this.espaco = item;
        edit = true;
    }
    
    public void cancelEdit() {
        this.espaco.restore(espacoBeforeEdit);
        this.espaco = new Espaco();
        edit = false;
    }
    
    public void saveEdit() {
        // DAO save the edit
        espacoDAO.updateEspaco(espaco);
        this.espaco = new Espaco();
        edit = false;
    }
    
    public void delete(Espaco espaco) {
        espacoDAO.deletarEspaco(espaco);
        listaEspaco();
    }
    

    public Espaco getEspaco() {
        return espaco;
    }

    public void setEspaco(Espaco espaco) {
        this.espaco = espaco;
    }

    public Espaco getEspacoBeforeEdit() {
        return espacoBeforeEdit;
    }

    public void setEspacoBeforeEdit(Espaco espacoBeforeEdit) {
        this.espacoBeforeEdit = espacoBeforeEdit;
    }

    public boolean isEdit() {
        return edit;
    }

    public void setEdit(boolean edit) {
        this.edit = edit;
    }

    
    
    public ArrayList<Espaco> getListaEspacos() {
        return listaEspacos;
    }

    public void setListaEspacos(ArrayList<Espaco> listaEspacos) {
        this.listaEspacos = listaEspacos;
    }
    
    

}
