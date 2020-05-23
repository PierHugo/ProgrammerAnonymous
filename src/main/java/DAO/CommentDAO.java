package DAO;

import DAOinterface.DAOInterface;
import controller.Controller;
import model.Comment;

import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

public class CommentDAO implements DAOInterface<Comment>
{
    public Comment findByUsername(String username)
    {
        Controller.beginTransaction();
        TypedQuery<Comment> query = Controller.getSession().createQuery("FROM Comment WHERE author = :username", Comment.class);
        query.setParameter("username", username);
        List<Comment> comments = query.getResultList();
        Controller.commitTransaction();
        if (comments.size() == 0)
            return null;
        else
            return comments.get(0);
    }

    public List<Comment> findTopComment()
    {
        Controller.beginTransaction();
        TypedQuery<Comment> query = Controller.getSession().createQuery("FROM Comment ORDER BY likes DESC", Comment.class);
        List<Comment> topcomment = query.getResultList();
        Controller.commitTransaction();


        if (topcomment.size() == 0)
            return null;
        else
            return topcomment;
    }

    public boolean delete(Comment entity)
    {
        try
        {
            Controller.beginTransaction();
            if (!Controller.getSession().contains(entity))
                Controller.getSession().merge(entity);
            Controller.getSession().delete(entity);
            Controller.commitTransaction();
            return true;
        } catch (Exception e)
        {
            return false;
        }
    }

    public boolean saveOrUpdate(Comment entity)
    {
        try
        {
            Controller.beginTransaction();
            Controller.getSession().saveOrUpdate(entity);
            Controller.commitTransaction();
            return true;
        } catch (Exception e)
        {
            return false;
        }
    }

    @SuppressWarnings("unchecked")
    public List<Comment> findAll()
    {
        Controller.beginTransaction();
        List<Comment> comments = (List<Comment>) Controller.getSession().createQuery("from Comment").list();
        Controller.commitTransaction();
        return comments;
    }
}