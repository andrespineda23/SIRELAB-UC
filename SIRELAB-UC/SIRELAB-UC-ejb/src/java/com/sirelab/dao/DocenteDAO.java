package com.sirelab.dao;

import com.sirelab.dao.interfacedao.DocenteDAOInterface;
import com.sirelab.entidades.Docente;
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
public class DocenteDAO implements DocenteDAOInterface {

    /**
     * Atributo EntityManager. Representa la comunicación con la base de datos
     */
    @PersistenceContext(unitName = "SIRELAB-UC-ejbPU")
    private EntityManager em;

    @Override
    public void crearDocente(Docente docente) {
        try {
            em.persist(docente);
        } catch (Exception e) {
            System.out.println("Error crearDocente DocenteDAO : " + e.toString());
        }
    }

    @Override
    public void editarDocente(Docente docente) {
        try {
            em.merge(docente);
        } catch (Exception e) {
            System.out.println("Error editarDocente DocenteDAO : " + e.toString());
        }
    }

    @Override
    public void eliminarDocente(Docente docente) {
        try {
            em.remove(em.merge(docente));
        } catch (Exception e) {
            System.out.println("Error eliminarDocente DocenteDAO : " + e.toString());
        }
    }

    @Override
    public List<Docente> consultarDocentes() {
        try {
            em.clear();
            Query query = em.createQuery("SELECT p FROM Docente p");
            query.setHint("javax.persistence.cache.storeMode", "REFRESH");
            List<Docente> lista = query.getResultList();
            return lista;
        } catch (Exception e) {
            System.out.println("Error consultarDocentes DocenteDAO : " + e.toString());
            return null;
        }
    }

    @Override
    public Docente buscarDocentePorID(BigInteger idRegistro) {
        try {
            em.clear();
            Query query = em.createQuery("SELECT p FROM Docente p WHERE p.iddocente=:idRegistro");
            query.setHint("javax.persistence.cache.storeMode", "REFRESH");
            query.setParameter("idRegistro", idRegistro);
            Docente registro = (Docente) query.getSingleResult();
            return registro;
        } catch (Exception e) {
            System.out.println("Error buscarDocentePorID DocenteDAO : " + e.toString());
            return null;
        }
    }

    @Override
    public Docente buscarDocentePorIDPersona(BigInteger idPersona) {
        try {
            em.clear();
            Query query = em.createQuery("SELECT p FROM Docente p WHERE p.persona.idpersona=:idPersona");
            query.setHint("javax.persistence.cache.storeMode", "REFRESH");
            query.setParameter("idPersona", idPersona);
            Docente registro = (Docente) query.getSingleResult();
            return registro;
        } catch (Exception e) {
            System.out.println("Error buscarDocentePorIDPersona DocenteDAO : " + e.toString());
            return null;
        }
    }
}
