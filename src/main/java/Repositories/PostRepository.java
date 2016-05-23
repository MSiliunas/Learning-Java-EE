package Repositories;

import Entities.PostEntity;

import java.util.List;

public class PostRepository extends AbstractRepository<PostEntity> {

    @Override
    public PostEntity get(Integer id) {

        return null;

    }

    public List<PostEntity> getAll() {

        List list = em.createQuery("SELECT p FROM PostEntity p").getResultList();

        return list;

    }

}
