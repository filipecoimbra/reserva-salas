/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uff2017.reservasalas;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import uff2017.reservasalas.dao.EspacoDAO;
import uff2017.reservasalas.model.Espaco;

/**
 *
 * @author fabri
 */
@Named
@RequestScoped
public class EditaEspacoBean {

    Espaco espaco = new Espaco();
    EspacoDAO espacoDAO = new EspacoDAO();

    public void onload() {
        //TODO: PEGAR O ID POR GET, SELECIONAR NO BANCO AS INFORMACOES PARA COLOCAR NOS CONTROLES.
    }

    public void editaEspaco() {

    }

    public void excluiEspaco() {

    }

}