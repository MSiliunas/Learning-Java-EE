package Controllers;


import javax.ejb.Stateful;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;

@Named
@Stateful
@RequestScoped
public class HomeController implements Serializable {

    public String helloWorld() {
        return "Hello! ";
    }

}
