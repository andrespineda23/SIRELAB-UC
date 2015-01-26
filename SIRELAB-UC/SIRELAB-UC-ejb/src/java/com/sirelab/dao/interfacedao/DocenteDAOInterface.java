package com.sirelab.dao.interfacedao;

import com.sirelab.entidades.Docente;
import java.math.BigInteger;
import java.util.List;

/**
 *
 * @author ANDRES PINEDA
 */
public interface DocenteDAOInterface {

    public void crearDocente(Docente docente);

    public void editarDocente(Docente docente);

    public void eliminarDocente(Docente docente);

    public List<Docente> consultarDocentes();

    public Docente buscarDocentePorID(BigInteger idRegistro);
    
    public Docente buscarDocentePorIDPersona(BigInteger idPersona);

}
