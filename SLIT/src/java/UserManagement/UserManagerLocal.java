package userManagement;

import Objects.User;
import javax.ejb.Local;

@Local
public interface UserManagerLocal {
    User getUser(String id);
    boolean createUser(User u);
    boolean updateUser(User u);
}