package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "comment")
public class Comment
{
    @Id
    @Column(name = "author")
    private String author;

    @Column(name = "comment")
    private String comment;

    @Column(name = "comment_date")
    private LocalDate commentDate;

    @Column(name = "likes")
    private int likes;

    public String getAuthor()
    {
        return author;
    }

    public void setAuthor(String author)
    {
        this.author = author;
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

    public int getLikes()
    {
        return likes;
    }

    public void setLikes(int likes)
    {
        this.likes = likes;
    }
}
