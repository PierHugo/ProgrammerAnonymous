package model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "comment")
public class Comment
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "comment")
    private String comment;

    @Column(name = "comment_date")
    private LocalDate commentDate;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_username")
    private User user;

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

    public User getUser()
    {
        return user;
    }

    public void setUser(User user)
    {
        this.user = user;
    }
}
