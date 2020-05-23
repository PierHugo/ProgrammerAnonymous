package bean;

import controller.Controller;
import model.User;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@ManagedBean(name = "welcomeBean")
@ViewScoped
public class WelcomeBean implements Serializable {
    private static final long serialVersionUID = 1L;
    private final List<User> users;

    public WelcomeBean()
    {
        Controller con = new Controller();
        this.users = con.getUserDAO().findAll();
    }

    public List<User> getUsers(){
        return this.users;
    }

}
