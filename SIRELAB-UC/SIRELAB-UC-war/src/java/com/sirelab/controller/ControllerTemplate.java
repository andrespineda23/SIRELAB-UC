/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sirelab.controller;

import java.io.IOException;
import java.io.Serializable;
import java.text.DateFormat;
import java.util.Date;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.servlet.http.HttpSession;

/**
 *
 * @author ANDRES PINEDA
 */
@Named(value = "controllerTemplate")
@ViewScoped
public class ControllerTemplate implements Serializable {

    private Date fechaSistema;
    private final DateFormat formatoFecha = DateFormat.getDateInstance(DateFormat.FULL);
    private String mensajeFechaActual;

    public ControllerTemplate() {
        mensajeFechaActual = new String();
    }

    public void cerrarSession() throws IOException {
        FacesContext x = FacesContext.getCurrentInstance();
        HttpSession ses = (HttpSession) x.getExternalContext().getSession(false);
        ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
        ec.invalidateSession();
        ec.redirect(ec.getRequestContextPath() + "/login.xhtml");
    }

    public String obtenerFechaSistema() {
        fechaSistema = new Date();
        mensajeFechaActual = formatoFecha.format(fechaSistema);
        return mensajeFechaActual;
    }

    public Date getFechaSistema() {
        return fechaSistema;
    }

    public void setFechaSistema(Date fechaSistema) {
        this.fechaSistema = fechaSistema;
    }

    public String getMensajeFechaActual() {
        return mensajeFechaActual;
    }

    public void setMensajeFechaActual(String mensajeFechaActual) {
        this.mensajeFechaActual = mensajeFechaActual;
    }
}
