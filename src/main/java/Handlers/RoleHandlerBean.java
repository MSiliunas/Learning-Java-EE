package Handlers;

import javax.ejb.Stateless;
import javax.inject.Named;

@Stateless
@Named
public class RoleHandlerBean {

    public String testMe() {
        return "Im working!";
    }

}
