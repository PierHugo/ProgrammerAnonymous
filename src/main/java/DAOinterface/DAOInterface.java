package DAOinterface;

import java.util.List;

public interface DAOInterface<T>
{
    T findByUsername(String username);

    boolean delete(T entity);

    boolean saveOrUpdate(T entity);

    List<T> findAll();
}
