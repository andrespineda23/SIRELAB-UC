/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sirelab.controller;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import org.primefaces.context.RequestContext;

/**
 *
 * @author ANDRES PINEDA
 */
@Named(value = "controllerLogin")
@SessionScoped
public class ControllerLogin implements Serializable {

    /**
     * Creates a new instance of ControllerLogin
     */
    public ControllerLogin() {
    }

    public void dispararDialogoLoginUsuario() {
        System.out.println("Entro");
        RequestContext context = RequestContext.getCurrentInstance();
        context.update("form:loginUsuario");
        context.execute("loginUsuario.show()");
    }

}
