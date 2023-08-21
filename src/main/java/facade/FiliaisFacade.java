/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package facade;

import entidades.Filiais;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author paulo
 */
@Stateless
public class FiliaisFacade extends AbstractFacade<Filiais> {

    @PersistenceContext(unitName = "com.mycompany_tent1_war_1PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public FiliaisFacade() {
        super(Filiais.class);
    }
}
