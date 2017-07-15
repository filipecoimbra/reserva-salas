/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uff2017.reservasalas;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import uff2017.reservasalas.dao.UsuarioDAO;
import uff2017.reservasalas.model.Usuario;

/**
 *
 * @author fabri
 */
@Named
@RequestScoped
public class EditaUsuarioBean {
    
    Usuario usuario = new Usuario();
    UsuarioDAO usuarioDAO = new UsuarioDAO();
    
    public void onload() {
        //TODO: PEGAR O ID POR GET, SELECIONAR NO BANCO AS INFORMACOES PARA COLOCAR NOS CONTROLES.
    }
    
    public void editaUsuario(){
    
    }
    
    public void excluiUsuario(){
    
    }
    
}
