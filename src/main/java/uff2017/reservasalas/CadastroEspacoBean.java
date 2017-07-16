/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uff2017.reservasalas;

import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import uff2017.reservasalas.dao.EspacoDAO;
import uff2017.reservasalas.model.Espaco;

/**
 *
 * @author fabri
 */
@Named
@RequestScoped
public class CadastroEspacoBean {

    private EspacoDAO espacoDAO = new EspacoDAO();
    private Espaco espaco = new Espaco();
    
    public EspacoDAO getEspacoDAO() {
        return espacoDAO;
    }

    public void setEspacoDAO(EspacoDAO espacoDAO) {
        this.espacoDAO = espacoDAO;
    }

    public Espaco getEspaco() {
        return espaco;
    }

    public void setEspaco(Espaco espaco) {
        this.espaco = espaco;
    }

    public void cadastraEspaco() throws Exception {        
        espacoDAO.cadastrarEspaco(espaco);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Cadastrado com sucesso."));
    }

}
