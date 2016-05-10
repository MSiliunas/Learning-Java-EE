package Controllers;

import Entities.UserEntity;
import Entities.UserRoleEntity;
import Handlers.UserCRUD;

import javax.ejb.EJB;
import javax.ejb.Stateful;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by msiliunas on 10/05/16.
 */

@Named
@Stateful
@SessionScoped
public class UserController implements Serializable {

    @PersistenceContext
    EntityManager em;

    @EJB
    UserCRUD userCRUD;

    private String newUserEmail;

    private String newUserRoles;

    public String createAndPersistUser() {
        UserEntity userEntity = new UserEntity();
        userEntity.setEmail(newUserEmail);

        handleRoleList();

        em.isOpen();
        userCRUD.persist(userEntity);
        em.flush();

        return "userCreated";
    }

    private List<UserRoleEntity> handleRoleList() {
        if (newUserRoles == null || newUserRoles.equals("")) {
            return null;
        }

        List<UserRoleEntity> list = new ArrayList<>();

        for (String role : newUserRoles.split(" ")) {
            
        }

        return list;
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
        return userCRUD.getAllUsers();
    }

}
