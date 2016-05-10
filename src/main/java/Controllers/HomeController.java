package Controllers;


import Handlers.RoleHandlerBean;

import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.Stateful;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.TransactionSynchronizationRegistry;
import java.io.Serializable;

@RequestScoped
@Named
@Stateful
public class HomeController implements Serializable {

    @EJB
    RoleHandlerBean roleHandlerBean;

    @Resource
    private TransactionSynchronizationRegistry tx;

    @PersistenceContext
    EntityManager em;

    private void createRole(String roleName) {
        em.isOpen();
        roleHandlerBean.createNewRole(roleName);
        em.flush();
    }

    public String helloWorld() {
        return "Hello! " + roleHandlerBean.testMe();
    }

}
