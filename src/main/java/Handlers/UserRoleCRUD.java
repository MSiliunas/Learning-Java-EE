package Handlers;

import Entities.UserRoleEntity;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class UserRoleCRUD extends CRUD {

    @PersistenceContext(unitName = "MyPersistenceUnit")
    private EntityManager em;

    public void persistRole(UserRoleEntity role) {
        this.em.persist(role);
    }

    public void updateRole(UserRoleEntity role) {
        this.em.merge(role);
    }

    public void deleteRole(UserRoleEntity role) {
        UserRoleEntity storedRole = em.find(UserRoleEntity.class, role.getId());
        if (storedRole != null) {
            em.remove(storedRole);
        }
    }

    public List<UserRoleEntity> getAllUserRoles() {
        return em.createQuery("select role from UserRoleEntity role").getResultList();
    }

}
