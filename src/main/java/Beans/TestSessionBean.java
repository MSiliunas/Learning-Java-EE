package Beans;

import javax.ejb.Stateful;
import javax.faces.bean.RequestScoped;

@RequestScoped
@Stateful(name = "TestSessionEJB")
public class TestSessionBean {
    public String helloWorld() {
        return "Hello World!";
    }
}
