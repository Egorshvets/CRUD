package web.Dao;

import org.springframework.stereotype.Repository;
import web.Model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {

    @PersistenceContext
    private EntityManager entityManager;



    public List<User> getAllUsers() {
        List<User> users = entityManager.createQuery("from User", User.class).getResultList();
        return users;
    }


    public void addUser(String userName, String email, int age) {
        entityManager.persist(new User(userName, email, age));
    }

    @Override
    public User getUserById(int Id) {
        return (User) entityManager.createQuery("from User where id=" + Id).getResultList().get(0);
    }

    @Override
    public void deleteUserById(int Id) {
        System.out.println(Id);
        List<User> user = entityManager.createQuery("from User where id=" + Id).getResultList();
        entityManager.remove(user.get(0));
    }

    @Override
    public void updateUser(int Id, String userName, String email, int age) {
        User user = (User) entityManager.createQuery("from User where id=" + Id).getResultList().get(0);
        user.setUserName(userName);
        user.setAge(age);
        user.setEmail(email);
        entityManager.merge(user);
    }
}
