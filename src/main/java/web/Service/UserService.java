package web.Service;

import web.Model.User;

import java.util.List;

public interface UserService {

    public List<User> getAllUsers();
    public void addUser(String userName, String email, int age);
    public User getUserById(int Id);
    public void deleteUserById(int Id);
    public void updateUser(int Id, String userName, String email, int age);
    public void updateUser(User user);
    public void addUser(User user);
}
