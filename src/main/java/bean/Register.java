package bean;

import controller.Controller;
import model.User;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import java.io.Serializable;

@ManagedBean
@RequestScoped
public class Register implements Serializable
{
    private static final long serialVersionUID = 1L;
    private final User user;

    public Register()
    {
        user = new User();
    }

    public void createUser()
    {
        Controller con = new Controller();

        System.out.println(con.getUserDAO());
        boolean isCreate = con.getUserDAO().saveOrUpdate(user);

        if (isCreate)
        {
            System.out.println("Usertest: " + user.getUsername() + user.getFirstName() + user.getLastName() + user.getPassword() + user.getAge() + user.getCity());
            FacesMessage confirm = new FacesMessage("Inscription valide !");
            FacesContext.getCurrentInstance().addMessage(null, confirm);
        }
    }

    public User getUser()
    {
        return user;
    }
}
