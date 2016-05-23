package Services;

import Entities.UserRoleEntity;
import Repositories.UserRoleRepository;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

@Stateless
public class UserRoleService {

    @Inject
    UserRoleRepository userRoleRepo;

    public UserRoleEntity create(UserRoleEntity entity) {

        return userRoleRepo.create(entity);

    }

    public List<UserRoleEntity> createFromList(List<UserRoleEntity> list) {

        for (UserRoleEntity role : list) {
            role = userRoleRepo.create(role);
        }

        return list;

    }

    public List<UserRoleEntity> getAllUserRoles() {

        return userRoleRepo.getAll();

    }

}
