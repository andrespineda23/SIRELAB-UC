/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sirelab.dao.interfacedao;

import com.sirelab.entidades.Estudiante;
import java.math.BigInteger;
import java.util.List;

/**
 *
 * @author ANDRES PINEDA
 */
public interface EstudianteDAOInterface {

    public void crearEstudiante(Estudiante estudiante);

    public void editarEstudiante(Estudiante estudiante);

    public void eliminarEstudiante(Estudiante estudiante);

    public List<Estudiante> consultarEstudiantes();

    public Estudiante buscarEstudiantePorID(BigInteger idRegistro);

}
