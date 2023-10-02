/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package facade;

import entidades.Filiais;
import entidades.Fornecedor;
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

    public List<T> instalacoesFinalizadas() {
        Query q = getEntityManager().createNamedQuery(entityClass.getSimpleName() + ".findByNoNull");
        return q.getResultList();
    }

    public List<T> vendaFuncionario(String vnd) {
        Query q = getEntityManager().createNamedQuery(entityClass.getSimpleName() + ".findByVendedor");
        q.setParameter("vendedor", vnd);
        return q.getResultList();
    }

    public List<T> findByFiliais(Filiais id) {
        Query q = getEntityManager().createNamedQuery(entityClass.getSimpleName() + ".findByFiliais");
        q.setParameter("filiais", id);
        return q.getResultList();
    }

    public List<T> findByFornecedor(Fornecedor For) {
        Query q = getEntityManager().createNamedQuery(entityClass.getSimpleName() + ".findByFornecedor");
        q.setParameter("fornecedor", For);
        return q.getResultList();
    }

    public List<T> findByTamanho(int qnt) {
        Query q = getEntityManager().createNamedQuery(entityClass.getSimpleName() + ".findByModulo1");
        q.setParameter("modulo1", qnt);
        return q.getResultList();
    }
}
