package web.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;
import web.Dao.UserDAO;
import web.Model.User;

import java.util.List;

@Service
@EnableTransactionManagement
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDAO userDAO;

    @Override
    @Transactional
    public List<User> getAllUsers() {
        return userDAO.getAllUsers();
    }

    @Override
    @Transactional
    public void addUser(String userName, String email, int age) {
        userDAO.addUser(userName, email, age);
    }

    @Override
    @Transactional
    public User getUserById(int Id) {
        return userDAO.getUserById(Id);
    }

    @Override
    @Transactional
    public void deleteUserById(int Id) {
        userDAO.deleteUserById(Id);
    }

    @Override
    @Transactional
    public void updateUser(int Id, String userName, String email, int age) {
        userDAO.updateUser(Id, userName, email, age);
    }
}
