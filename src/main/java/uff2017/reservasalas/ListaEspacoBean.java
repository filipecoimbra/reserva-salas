/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uff2017.reservasalas;

import java.util.ArrayList;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import uff2017.reservasalas.model.Espaco;

/**
 *
 * @author fabri
 */
@Named
@RequestScoped
public class ListaEspacoBean {

    ArrayList<Espaco> listaEspacos = new ArrayList<Espaco>();
    
    public void onload() {
        listaEspaco();
    }

    public void listaEspaco() {
        
        Espaco teste1 = new Espaco();
        teste1.setIdEspaco(1); teste1.setCapacidade(2); teste1.setLocalidade("teste loco");
        Espaco teste2 = new Espaco();
        teste2.setIdEspaco(2); teste2.setCapacidade(9); teste2.setLocalidade("teste locgfdo");
        Espaco teste3 = new Espaco();
        teste3.setIdEspaco(15); teste3.setCapacidade(6); teste3.setLocalidade("teste locot");
        
        listaEspacos.add(teste1);
        listaEspacos.add(teste2);
        listaEspacos.add(teste3);
        
    }

    public ArrayList<Espaco> getListaEspacos() {
        return listaEspacos;
    }

    public void setListaEspacos(ArrayList<Espaco> listaEspacos) {
        this.listaEspacos = listaEspacos;
    }
    
    

}
