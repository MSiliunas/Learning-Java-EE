package Repositories;

import Entities.UserEntity;

import javax.ejb.Stateless;
import java.util.List;

@Stateless
public class UserRepository extends AbstractRepository<UserEntity> {

    @Override
    public UserEntity get(Integer id) {
        return null;
    }

    public List<UserEntity> getAll() {

        List list = em.createQuery("select u from UserEntity u").getResultList();

        if (list.size() <= 0) {
            list = null;
        }

        return list;

    }

    public UserEntity getByEmail(String email) {

        List<UserEntity> user = em.createQuery("SELECT u FROM UserEntity u WHERE email = :email")
                .setParameter("email", email)
                .getResultList();

        if (user.size() == 1) {
            return user.get(0);
        }

        return null;

    }

}
