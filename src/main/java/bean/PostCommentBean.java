package bean;

import model.Comment;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import java.io.Serializable;
import java.time.LocalDate;

@ManagedBean(name = "postcommentBean")
@RequestScoped
public class PostCommentBean implements Serializable {
    private static final long serialVersionUID = 1L;
    private Comment comment;

    public PostCommentBean(){
        comment = new Comment();
    }

    public void addComment(){
        //Controller con = new Controller();
        LocalDate date = LocalDate.now();

        System.out.println(date);
        System.out.println("test comment: " + comment.getUser() + comment.getComment());

        FacesMessage confirmPost = new FacesMessage("Comment published !");
        FacesContext.getCurrentInstance().addMessage(null, confirmPost);
    }

    public Comment getComment() {
        return comment;
    }
}
