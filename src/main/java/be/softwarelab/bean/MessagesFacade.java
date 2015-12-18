package be.softwarelab.bean;

import be.softwarelab.entity.Messages;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Dimitri
 */
@Stateless
public class MessagesFacade extends AbstractFacade<Messages> {

    @PersistenceContext(unitName = "be.softwarelab_TrainingTrackGuestBook_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MessagesFacade() {
        super(Messages.class);
    }
    
}
