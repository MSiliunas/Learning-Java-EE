package Services;

import Entities.UserEntity;
import Entities.UserRoleEntity;
import Repositories.UserRepository;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Stateless
@TransactionAttribute(value = TransactionAttributeType.REQUIRES_NEW)
public class UserService implements Serializable {

    @Inject
    UserRepository userRepository;

    @Inject
    UserRoleService userRoleService;

    public UserEntity getByEmail(String email) {

        return userRepository.getByEmail(email);

    }

    public UserEntity create(UserEntity user) {

        return userRepository.create(user);

    }

    public UserEntity create(String email, String roles) {

        if (roles == null || roles.equals("")) {
            return null;
        }

        List<UserRoleEntity> list = new ArrayList<>();

        for (String role : roles.split(" ")) {
            list.add(new UserRoleEntity(role));
        }

        list = userRoleService.createFromList(list);

        UserEntity userEntity = new UserEntity();
        userEntity.setEmail(email);
        userEntity.setRoles(list);

        userEntity = this.create(userEntity);

        return userEntity;

    }

    public List<UserEntity> getAllUsers() {

        return userRepository.getAll();

    }

}
