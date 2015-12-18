package be.softwarelab.dao;

import be.softwarelab.entity.Users;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 *
 * @author dimitridw
 */
@Stateless
public class UsersDao {

    // Injected database connection:
    @PersistenceContext private EntityManager em;
 
    // Stores a new guest: 
    public void persist(Users guest) {
        em.persist(guest);
    }
 
    // Retrieves all the guests:
    public List<Users> getAllUsers() {
        TypedQuery<Users> query = em.createQuery(
            "SELECT g FROM Users g ORDER BY g.id", Users.class);
        return query.getResultList();
    }
    
    // Retrieves all the guests:
    public Users getByName(String name) {
        
        TypedQuery<Users> query = em.createNamedQuery("Users.findByName",Users.class);
        query.setParameter("name", name);
        List<Users> results = query.getResultList();
        if (results != null && results.size() > 0) {
            return results.get(0);
        } else {
            return null;
        }
    }
    
    // Retrieves all the guests:
    public Integer getMaxId() {
        TypedQuery<Integer> query = em.createQuery(
            "SELECT MAX(g.id) FROM Users g", Integer.class);
        if (query.getResultList() != null && query.getResultList().size() > 0)
        {
            return query.getResultList().get(0);
        } else {
            return 1;
        }
    }

}
