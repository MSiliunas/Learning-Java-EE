package Repositories;

import Entities.UserRoleEntity;

import javax.ejb.Stateless;
import java.util.List;

@Stateless
public class UserRoleRepository extends AbstractRepository<UserRoleEntity> {

    @Override
    public UserRoleEntity get(Integer id) {
        UserRoleEntity roleEntity = (UserRoleEntity) em.createQuery("SELECT r FROM UserRoleEntity r where id = :id")
                .setParameter("id", id)
                .getSingleResult();

        return roleEntity;
    }

    public List<UserRoleEntity> getAll() {
        List list = em.createQuery("select r from UserRoleEntity r").getResultList();

        if (list.size() <= 0) {
            list = null;
        }

        return list;
    }

}
