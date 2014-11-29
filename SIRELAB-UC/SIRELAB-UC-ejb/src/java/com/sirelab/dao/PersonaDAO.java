package com.sirelab.dao;

import com.sirelab.dao.interfacedao.PersonaDAOInterface;
import com.sirelab.entidades.Persona;
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
public class PersonaDAO implements PersonaDAOInterface {

    /**
     * Atributo EntityManager. Representa la comunicación con la base de datos
     */
    @PersistenceContext(unitName = "SIRELAB-UC-ejbPU")
    private EntityManager em;

    @Override
    public void crearPersona(Persona persona) {
        try {
            em.persist(persona);
        } catch (Exception e) {
            System.out.println("Error crearPersona PersonaDAO : " + e.toString());
        }
    }

    @Override
    public void editarPersona(Persona persona) {
        try {
            em.merge(persona);
        } catch (Exception e) {
            System.out.println("Error editarPersona PersonaDAO : " + e.toString());
        }
    }

    @Override
    public void eliminarPersona(Persona persona) {
        try {
            em.remove(em.merge(persona));
        } catch (Exception e) {
            System.out.println("Error eliminarPersona PersonaDAO : " + e.toString());
        }
    }

    @Override
    public List<Persona> consultarPersonas() {
        try {
            em.clear();
            Query query = em.createQuery("SELECT p FROM Persona p");
            //query.setHint("javax.persistence.cache.storeMode", "REFRESH");
            List<Persona> lista = query.getResultList();
            return lista;
        } catch (Exception e) {
            System.err.println("Error consultarPersonas PersonaDAO : " + e.toString());
            return null;
        }
    }

    @Override
    public Persona buscarPersonaPorID(BigInteger idRegistro) {
        try {
            em.clear();
            Query query = em.createQuery("SELECT p FROM Persona p WHERE p.idpersona=:idRegistro");
            //query.setHint("javax.persistence.cache.storeMode", "REFRESH");
            query.setParameter("idRegistro", idRegistro);
            Persona registro = (Persona) query.getSingleResult();
            return registro;
        } catch (Exception e) {
            System.err.println("Error buscarPersonaPorID PersonaDAO : " + e.toString());
            return null;
        }
    }
}
