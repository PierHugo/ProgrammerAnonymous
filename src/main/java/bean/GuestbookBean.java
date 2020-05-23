package bean;

import controller.Controller;
import model.Comment;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.naming.ldap.Control;
import java.io.Serializable;
import java.util.List;

@ManagedBean(name = "guestbookBean")
@ViewScoped
public class GuestbookBean implements Serializable {
    private static final long serialVersionUID = 1L;
    private List<Comment> comments;

    public GuestbookBean(){
        Controller con = new Controller();
        this.comments = con.getCommentDAO().findAll();
    }

    public void addLike(String author){
        Controller con = new Controller();
        Comment tmpComment = con.getCommentDAO().findByUsername(author);
        tmpComment.setLikes(tmpComment.getLikes()+1);

        boolean isCreate = con.getCommentDAO().saveOrUpdate(tmpComment);

        if(!isCreate){
            // TODO: Message erreur
        }
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
}
