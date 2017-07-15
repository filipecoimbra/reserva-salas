/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uff2017.reservasalas;

import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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

    
    
    public Espaco getEspaco() {
        return espaco;
    }

    public void setEspaco(Espaco espaco) {
        this.espaco = espaco;
    }

    public void cadastraEspaco(){
    
    }
    
}
