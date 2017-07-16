/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uff2017.reservasalas;

import java.util.Date;

/**
 *
 * @author filip
 */
public final class Util {

    public static boolean validaHora(String horario) {

        try {

            int hora = Integer.parseInt(horario.substring(0, 2));
            if (hora > 24 || hora < 0) {
                return false;
            }

            int minutos = Integer.parseInt(horario.substring(3, 5));
            if (minutos > 60 || minutos < 0) {
                return false;
            }

            if (!(horario.substring(2, 3).equals(":"))) {
                return false;
            }

            return true;
        } catch (Exception e) {
            return false;
        }

    }

    public static boolean hora1MaiorQue2(String horario1, String horario2) {
        int hora1 = Integer.parseInt(horario1.substring(0, 2));
        int hora2 = Integer.parseInt(horario2.substring(0, 2));
        if (hora1 > hora2 == true) {
            return true;
        } else {
            if (hora1 == hora2) {
                int minuto1 = Integer.parseInt(horario1.substring(3, 5));
                int minuto2 = Integer.parseInt(horario2.substring(3, 5));
                if (minuto1 > minuto2) {
                    return true;
                }
            }
            return false;
        }
    }

}
