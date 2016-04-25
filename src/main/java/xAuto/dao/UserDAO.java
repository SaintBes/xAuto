package xAuto.dao;



import xAuto.domain.User;

import java.util.List;

/**
 * Created by admssa on 29.08.2015.
 */

public interface UserDAO {


        User addUser(User user);
        void editUser(User user);
        void deleteUser(User user);
        User findUser(int userId);
        User findUserByName(String username);
        List<User> getAllUsers();
    
}
