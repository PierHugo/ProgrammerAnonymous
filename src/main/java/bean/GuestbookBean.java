package bean;

import controller.Controller;
import model.Comment;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.io.Serializable;
import java.util.List;

@ManagedBean(name = "guestbookBean")
@ViewScoped
public class GuestbookBean implements Serializable
{
    private static final long serialVersionUID = 1L;
    private List<Comment> comments;
    private List<Comment> topcom;

    public GuestbookBean()
    {
        Controller con = new Controller();
        this.comments = con.getCommentDAO().findAll();
        this.topcom = con.getCommentDAO().findTopComment();
    }

    public void addLike(String author)
    {
        Controller con = new Controller();
        Comment tmpComment = con.getCommentDAO().findByUsername(author);
        tmpComment.setLikes(tmpComment.getLikes() + 1);

        boolean isCreate = con.getCommentDAO().saveOrUpdate(tmpComment);
        this.comments = con.getCommentDAO().findAll();

        if (!isCreate)
        {
            FacesMessage confirm = new FacesMessage("Veuillez rentré toutes les informations !");
            FacesContext.getCurrentInstance().addMessage(null, confirm);
        }
    }

    public List<Comment> getComments()
    {
        return comments;
    }

    public void setComments(List<Comment> comments)
    {
        this.comments = comments;
    }

    public List<Comment> getTopcom()
    {
        return topcom;
    }

    public void setTopcom(List<Comment> topcom)
    {
        this.topcom = topcom;
    }
}
