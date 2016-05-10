package Handlers;

import Entities.UserEntity;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class UserCRUD extends CRUD {

    @PersistenceContext(unitName = "MyPersistenceUnit")
    private EntityManager em;

    @EJB
    UserRoleCRUD userRoleCRUD;

    public void persist(UserEntity user) {
        this.em.persist(user);
    }

    public void update(UserEntity user) {
        this.em.merge(user);
    }

    public void delete(UserEntity user) {
        UserEntity stored = em.find(UserEntity.class, user.getId());
        if (stored != null) {
            em.remove(stored);
        }
    }

    public List<UserEntity> getAllUsers() {
        return em.createQuery("select user from UserEntity user").getResultList();
    }

}
