/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sirelab.utilidades;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author ANDRES PINEDA
 */
public final class Utilidades {

    private static final String PATTERN_EMAIL = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    /**
     * Metodo que valida si un objeto se encuentra vacio
     *
     * @param obj Objeto a validar
     * @return true-Diferente de nulo / false-Es nulo
     */
    public static Boolean validarNulo(Object obj) {
        if (null != obj) {
            return true;
        }
        return false;
    }

    /**
     * Metodo que valida un correo electronico ingresado
     *
     * @param correo Correo electronico
     * @return true-Correo correcto / false-Correo incorrecto
     */
    public static boolean validarCorreoElectronico(String correo) {
        Pattern pattern = Pattern.compile(PATTERN_EMAIL);
        Matcher matcher = pattern.matcher(correo);
        return matcher.matches();
    }

    /**
     * Metodo que valida que un caracter string este conformado unicamente por
     * caracteres
     *
     * @param str String a validar
     * @return true-Palabra correcta / false-Palabra incorrecta
     */
    public static boolean validarCaracterString(String str) {
        boolean respuesta = false;
        if ((str).matches("([a-z]|[A-Z]|\\s)+")) {
            respuesta = true;
        }
        return respuesta;
    }

    /**
     * Metodo que valida si un numero es numero y no posee algun caracter
     * diferente
     *
     * @param numero Numero a validar
     * @return true-Es numero / false-No es numero
     */
    public static boolean isNumber(String numero) {
        try {
            Integer validacion = Integer.parseInt(numero);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

}
