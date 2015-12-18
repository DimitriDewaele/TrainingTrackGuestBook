package be.softwarelab.dao;

import be.softwarelab.entity.Messages;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author dimitridw
 */
@Stateless
public class MessagesDao {
    // Injected database connection:
    @PersistenceContext private EntityManager em;
 
    // Stores a new guest: 
    public void persist(Messages guest) {
        em.persist(guest);
    }
 
    // Retrieves all the guests:
    public List<Messages> getAllMessages() {
        TypedQuery<Messages> query = em.createQuery(
            "SELECT g FROM Messages g ORDER BY g.id", Messages.class);
        return query.getResultList();
    }
    
    // Retrieves all the guests:
    public Integer getMaxId() {
        TypedQuery<Integer> query = em.createQuery(
            "SELECT MAX(g.id) FROM Messages g", Integer.class);
        if (query.getResultList() != null && query.getResultList().size() > 0)
        {
            return query.getResultList().get(0);
        } else {
            return 1;
        }
    }
}
