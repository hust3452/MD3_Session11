package ra.demo.Repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ra.demo.Model.entity.User;

@Repository
public class UserRepository {
    @Autowired
    private SessionFactory sessionFactory;

    public User login(String userName, String password) {
        try(Session session = sessionFactory.openSession()){
            return session.createQuery("from User u WHERE u.userName =:userName and u.password=:password",User.class)
                    .setParameter("userName",userName)
                    .setParameter("password",password)
                    .getSingleResult();
        }catch (Exception e){
            return null;
        }
    }

    public User register(User user) {
        try{
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            User newUser = (User) session.merge(user);
            session.getTransaction().commit();
            return newUser;
        }catch (Exception e){
            return null;
        }
    }

    public User findByUsername(String userName) {
        try(Session session = sessionFactory.openSession()){
            return session.createQuery("select u from User u WHERE u.userName=:userName",User.class)
                    .setParameter("userName",userName).getSingleResult();
        }catch (Exception e){
            return null;
        }
    }

}
