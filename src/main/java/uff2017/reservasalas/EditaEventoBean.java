/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uff2017.reservasalas;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import uff2017.reservasalas.dao.EventoDAO;
import uff2017.reservasalas.model.Evento;

/**
 *
 * @author fabri
 */
@Named
@RequestScoped
public class EditaEventoBean {
    
    Evento evento = new Evento();
    EventoDAO eventoDAO = new EventoDAO();
    
    public void onload() {
        //TODO: PEGAR O ID POR GET, SELECIONAR NO BANCO AS INFORMACOES PARA COLOCAR NOS CONTROLES.
    }
    
    public void editaEvento(){
    
    }
    
    public void excluiEvento(){
    
    }
    
}
