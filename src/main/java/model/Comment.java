package model;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "comment")
@ManagedBean(name = "commentBean")
@ViewScoped
public class Comment
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "comment")
    private String comment;

    @Column(name = "comment_date")
    private LocalDate commentDate;

    @Column(name = "comment_username")
    private String username;

    @Column(name = "comment_like")
    private int like;

    public long getId()
    {
        return id;
    }

    public void setId(long id)
    {
        this.id = id;
    }

    public String getComment()
    {
        return comment;
    }

    public void setComment(String comment)
    {
        this.comment = comment;
    }

    public LocalDate getCommentDate()
    {
        return commentDate;
    }

    public void setCommentDate(LocalDate commentDate)
    {
        this.commentDate = commentDate;
    }

    public String getUser()
    {
        return username;
    }

    public void setUser(String username)
    {
        this.username = username;
    }

    public int getLike(){ return like; }

    public void setLike(int like) { this.like = like; }
}
