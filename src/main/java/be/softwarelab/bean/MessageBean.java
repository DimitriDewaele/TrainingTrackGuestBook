package be.softwarelab.bean;

import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author Dimitri
 */
@ManagedBean(name = "messageBean")
@SessionScoped
public class MessageBean implements Serializable {

    private String user = "user";
    private String message = "message";
    
    /**
     * Creates a new instance of MessageBean
     */
    public MessageBean() {
    }

    /**
     * @return the user
     */
    public String getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(String user) {
        this.user = user;
    }

    /**
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * @param message the message to set
     */
    public void setMessage(String message) {
        this.message = message;
    }
    
}
