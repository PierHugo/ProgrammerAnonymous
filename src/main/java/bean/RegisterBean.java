package bean;

import controller.Controller;
import model.User;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import java.io.Serializable;

@ManagedBean(name = "registerBean")
@RequestScoped
public class RegisterBean implements Serializable
{
    private static final long serialVersionUID = 1L;
    private User user;

    public RegisterBean()
    {
        user = new User();
    }

    public void createUser()
    {
        Controller con = new Controller();


        boolean isCreate = con.getUserDAO().saveOrUpdate(user);
        FacesMessage confirm = new FacesMessage("Inscription valide !");
        FacesContext.getCurrentInstance().addMessage(null, confirm);

    }

    public User getUser()
    {
        return user;
    }
}
