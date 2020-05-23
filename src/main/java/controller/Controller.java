package controller;

import DAO.CommentDAO;
import DAO.MemberDAO;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Controller
{
    private static Controller controller = null;
    private static SessionFactory sessionFactory;
    private static Session session;
    private static Transaction transaction;

    private final MemberDAO memberDAO;
    private final CommentDAO commentDAO;

    private Controller()
    {
        Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
        sessionFactory = configuration.buildSessionFactory();
        session = sessionFactory.openSession();
        transaction = null;

        memberDAO = new MemberDAO();
        commentDAO = new CommentDAO();
    }

    public static void beginTransaction()
    {
        if (transaction == null || !transaction.isActive())
            transaction = session.beginTransaction();
    }

    public static Controller getController()
    {
        if (controller == null)
            controller = new Controller();
        return controller;
    }

    public static void commitTransaction()
    {
        transaction.commit();
    }

    public static SessionFactory getSessionFactory()
    {
        return sessionFactory;
    }

    public static Session getSession()
    {
        return session;
    }

    public static Transaction getTransaction()
    {
        return transaction;
    }

    public MemberDAO getMemberDAO()
    {
        return memberDAO;
    }

    public CommentDAO getCommentDAO()
    {
        return commentDAO;
    }

}

