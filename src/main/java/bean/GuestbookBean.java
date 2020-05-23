package bean;

import controller.Controller;
import model.Comment;
import model.User;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@ManagedBean
@RequestScoped
public class GuestbookBean implements Serializable {
    private static final long serialVersionUID = 1L;
    private List<Comment> comments;

    public GuestbookBean()
    {
        Controller con = new Controller();
        this.comments = con.getCommentDAO().findAll();
    }

    public List<Comment> getComments(){
        return this.comments;
    }
}
