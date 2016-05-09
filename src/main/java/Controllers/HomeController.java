package Controllers;


import javax.ejb.Stateful;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;

@RequestScoped
@ManagedBean
public class HomeController implements Serializable {

    private String testVar;

    public String getTestVar() {
        return testVar;
    }

    public void setTestVar(String testVar) {
        this.testVar = testVar;
    }

    public String helloWorld() {
        return "Hello! " ;
    }

}
