package Handlers;

import Entities.UserRoleEntity;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.SynchronizationType;
import javax.transaction.Transactional;

@Stateless
public class RoleHandlerBean {

    @PersistenceContext
    EntityManager em;

    public String testMe() {
        return "Im working!";
    }

    public void createNewRole(String roleName) {
        UserRoleEntity newRole = new UserRoleEntity();
        newRole.setRoleName(roleName);
        em.persist(newRole);
    }

}
