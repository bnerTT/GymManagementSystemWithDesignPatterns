package dao;

import entity.Usuarios.Aluno;
import entity.Usuarios.Instrutor;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

import java.util.List;

@Named
@RequestScoped
public class InstrutorDAO {
    @PersistenceContext()
    private EntityManager em;

    public void save(Instrutor instrutor) throws Exception {
        try {
            em.persist(instrutor);
        } catch (Exception e) {
            throw new Exception("Erro ao salvar instrutor: " + e.getMessage());
        }
    }

    public void update(Instrutor instrutor) throws Exception {
        try{
            em.merge(instrutor);
        } catch (Exception e) {
            throw new Exception("Erro ao atualizar" + e.getMessage());
        }
    }

    public void remove(Instrutor instrutor) throws Exception {
        try{
            em.remove(instrutor);
        } catch (Exception e) {
            throw new Exception("Erro ao remover" + e.getMessage());
        }
    }

    public List<Instrutor> findAll() {
        TypedQuery<Instrutor> query = em.createQuery("SELECT i FROM Instrutor i", Instrutor.class);
        return query.getResultList();
    }

    public Instrutor findById(Integer id) {
        return em.find(Instrutor.class, id);
    }
}
