package dao;


import entity.Usuarios.Aluno;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

import java.util.List;

@Named
@RequestScoped
public class AlunoDAO {

    @PersistenceContext
    private EntityManager em;

    public void save(Aluno aluno) throws Exception {
        try{
            em.persist(aluno);
        } catch (Exception e) {
            throw new Exception("Erro ao salvar" + e.getMessage());
        }
    }

    public void update(Aluno aluno) throws Exception {
        try{
            em.merge(aluno);
        } catch (Exception e) {
            throw new Exception("Erro ao atualizar" + e.getMessage());
        }
    }

    public List<Aluno> findAll(){
        TypedQuery<Aluno> query = em.createQuery("SELECT a FROM Aluno a", Aluno.class);
        return query.getResultList();
    }

    public Aluno findById(int id){
        return em.find(Aluno.class, id);
    }

    public void remove(Aluno aluno) throws Exception {
        try{
            em.remove(aluno);
        } catch (Exception e) {
            throw new Exception("Erro ao remover" + e.getMessage());
        }
    }

}
