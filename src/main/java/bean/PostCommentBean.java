package bean;

import controller.Controller;
import model.Comment;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

@ManagedBean(name = "postcommentBean")
@RequestScoped
public class PostCommentBean implements Serializable
{
    private static final long serialVersionUID = 1L;
    private Comment comment;

    public PostCommentBean()
    {
        this.comment = new Comment();
    }

    public void addComment()
    {
        Date today = new Date();
        SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy/MM/dd HH:mm");
        String postedDate = DATE_FORMAT.format(today);
        comment.setCommentDate(postedDate);

        Controller con = new Controller();
        boolean isCreate = con.getCommentDAO().saveOrUpdate(this.comment);

        if (!isCreate)
        {
            // TODO: Error message
        }
    }

    public Comment getComment()
    {
        return comment;
    }

    public void setComment(Comment comment)
    {
        this.comment = comment;
    }
}
