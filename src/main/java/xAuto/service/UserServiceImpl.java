package xAuto.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import xAuto.dao.UserDAO;
import xAuto.domain.User;
import xAuto.domain.UserStatus;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    @Override
    public User registerNewUserAccount(String email, String password) {
        if (!emailExist(email)) {
            User user = new User();
            user.setUsername(email);
            user.setPassword(password);
            user.setStatus(UserStatus.ACTIVE);
            return userDAO.addUser(user);
        }
        return null;
    }

    @Override
    public void updateUser(User user) {
        userDAO.editUser(user);
    }

    private boolean emailExist(String email) {

        if (userDAO.findUserByName(email) != null) {
            return true;
        }
        return false;
    }
}
