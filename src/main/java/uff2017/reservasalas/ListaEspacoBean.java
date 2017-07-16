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
    private int editId;
    
    public void onload() {
        listaEspaco();
    }

    public int getEditId() {
        return editId;
    }

    public void setEditId(int editId) {
        this.editId = editId;
    }

    public String goToEditPage(){                                
        editId = Integer.parseInt(FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("id"));
        return "EditaEspaco";
    }
    
    public void listaEspaco() {
        
        listaEspacos = espacoDAO.listaEspacos();
        
    }

    public ArrayList<Espaco> getListaEspacos() {
        return listaEspacos;
    }

    public void setListaEspacos(ArrayList<Espaco> listaEspacos) {
        this.listaEspacos = listaEspacos;
    }
    
    

}
