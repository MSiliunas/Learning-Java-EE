package Controllers;

import Entities.UserRoleEntity;
import Handlers.UserRoleCRUD;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.Stateful;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.transaction.TransactionSynchronizationRegistry;
import java.io.Serializable;
import java.util.List;

@Named
@Stateful
@RequestScoped
public class UserRoleController implements Serializable {

    @PersistenceContext()
    private EntityManager em;

    @Resource
    private TransactionSynchronizationRegistry tx;

    private UserRoleEntity userRoleEntity;

    @EJB
    private UserRoleCRUD userRoleCRUD;

    @PostConstruct
    public void init() {
        userRoleEntity = new UserRoleEntity();
    }

    public UserRoleEntity getUserRoleEntity() {
        return userRoleEntity;
    }

    public void setUserRoleEntity(UserRoleEntity userRoleEntity) {
        this.userRoleEntity = userRoleEntity;
    }

    public List<UserRoleEntity> getAllUserRoles() {
        return userRoleCRUD.getAllUserRoles();
    }

    public void createUserRole() {
        try {
            userRoleCRUD.persistRole(userRoleEntity);
            em.flush();
        } catch (PersistenceException ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Failed: Doctor with this name already exists. <br/>" + ex.getMessage()));
            em.clear();
            return;
        }
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("New Doctor has been saved SUCCESSFULY."));
        return;
    }

}
