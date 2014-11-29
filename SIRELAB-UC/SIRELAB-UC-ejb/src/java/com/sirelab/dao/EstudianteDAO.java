package com.sirelab.dao;

import com.sirelab.dao.interfacedao.EstudianteDAOInterface;
import com.sirelab.entidades.Estudiante;
import java.math.BigInteger;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author ANDRES PINEDA
 */
@Stateless
public class EstudianteDAO implements EstudianteDAOInterface {

    /**
     * Atributo EntityManager. Representa la comunicación con la base de datos
     */
    @PersistenceContext(unitName = "SIRELAB-UC-ejbPU")
    private EntityManager em;

    @Override
    public void crearEstudiante(Estudiante estudiante) {
        try {
            em.persist(estudiante);
        } catch (Exception e) {
            System.out.println("Error crearEstudiante EstudianteDAO : " + e.toString());
        }
    }

    @Override
    public void editarEstudiante(Estudiante estudiante) {
        try {
            em.merge(estudiante);
        } catch (Exception e) {
            System.out.println("Error editarEstudiante EstudianteDAO : " + e.toString());
        }
    }

    @Override
    public void eliminarEstudiante(Estudiante estudiante) {
        try {
            em.remove(em.merge(estudiante));
        } catch (Exception e) {
            System.out.println("Error eliminarEstudiante EstudianteDAO : " + e.toString());
        }
    }

    @Override
    public List<Estudiante> consultarEstudiantes() {
        try {
            em.clear();
            Query query = em.createQuery("SELECT p FROM Estudiante p");
            //query.setHint("javax.persistence.cache.storeMode", "REFRESH");
            List<Estudiante> lista = query.getResultList();
            return lista;
        } catch (Exception e) {
            System.err.println("Error consultarEstudiantes EstudianteDAO : " + e.toString());
            return null;
        }
    }

    @Override
    public Estudiante buscarEstudiantePorID(BigInteger idRegistro) {
        try {
            em.clear();
            Query query = em.createQuery("SELECT p FROM Estudiante p WHERE p.idestudiante=:idRegistro");
            //query.setHint("javax.persistence.cache.storeMode", "REFRESH");
            query.setParameter("idRegistro", idRegistro);
            Estudiante registro = (Estudiante) query.getSingleResult();
            return registro;
        } catch (Exception e) {
            System.err.println("Error buscarEstudiantePorID EstudianteDAO : " + e.toString());
            return null;
        }
    }
}
