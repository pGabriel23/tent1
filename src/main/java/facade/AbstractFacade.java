/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package facade;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author paulo
 */
public abstract class AbstractFacade<T> {

    private Class<T> entityClass;

    protected abstract EntityManager getEntityManager();

    public AbstractFacade(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    public void salvar(T entity) {
        getEntityManager().merge(entity);
    }

    public void remover(T entity) {
        getEntityManager().remove(getEntityManager().merge(entity));
    }

    public T buscar(Object id) {
        return getEntityManager().find(entityClass, id);
    }

    public List<T> buscaPorNome(String nome) {
        Query q = getEntityManager().createQuery("SELECT u FROM " + entityClass.getSimpleName() + " u WHERE u.nome = :nome");
        q.setParameter("nome", nome);
        return q.getResultList();
    }

    public List<T> listaTodos() {
        Query q = getEntityManager().createNamedQuery(entityClass.getSimpleName() + ".findAll");
        return q.getResultList();
    }

    public List<T> clientesDevedores() {
        Query q = getEntityManager().createNamedQuery(entityClass.getSimpleName() + ".findBySegundaParcelaNull");
        return q.getResultList();
    }
}
