package DAO;

import DAOinterface.DAOInterface;
import controller.Controller;
import model.Member;

import javax.persistence.TypedQuery;
import java.util.List;

public class MemberDAO implements DAOInterface<Member>
{
    public Member findByUsername(String username)
    {
        Controller.beginTransaction();
        TypedQuery<Member> query = Controller.getSession().createQuery("FROM Member WHERE username = :username", Member.class);
        query.setParameter("username", username);
        List<Member> members = query.getResultList();
        Controller.commitTransaction();
        if (members.size() == 0)
            return null;
        else
            return members.get(0);
    }

    public Member findByMembernameAndPassword(String username, String password)
    {
        Controller.beginTransaction();
        TypedQuery<Member> query = Controller.getSession().createQuery("FROM Member WHERE username = :username AND password = :password", Member.class);
        query.setParameter("username", username);
        query.setParameter("password", password);
        List<Member> members = query.getResultList();
        Controller.commitTransaction();
        if (members.size() == 0)
            return null;
        else
            return members.get(0);
    }

    public boolean delete(Member entity)
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

    public boolean saveOrUpdate(Member entity)
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
    public List<Member> findAll()
    {
        Controller.beginTransaction();
        List<Member> members = (List<Member>) Controller.getSession().createQuery("from Member").list();
        Controller.commitTransaction();
        return members;
    }
}