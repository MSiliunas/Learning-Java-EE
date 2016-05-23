package Controllers;

import Entities.UserEntity;
import Services.UserService;

import javax.ejb.Stateful;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;
import java.util.List;

@Named
@Stateful
@RequestScoped
public class UserController implements Serializable {

    private String newUserEmail;

    private String newUserRoles;

    @PersistenceContext
    EntityManager em;

    @Inject
    UserService userService;

    public String createAndPersistUser() {

        em.isOpen();
        userService.create(newUserEmail, newUserRoles);

        return "userCreated";

    }

    public String getNewUserRoles() {
        return newUserRoles;
    }

    public void setNewUserRoles(String newUserRoles) {
        this.newUserRoles = newUserRoles;
    }

    public String getNewUserEmail() {
        return newUserEmail;
    }

    public void setNewUserEmail(String newUserEmail) {
        this.newUserEmail = newUserEmail;
    }

    public List<UserEntity> getAllUsers() {
        return userService.getAllUsers();
    }

}
