package hiber.dao;

import hiber.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {
   private SessionFactory sessionFactory;

   @Autowired
   public void UserDao(SessionFactory sessionFactory) {this.sessionFactory = sessionFactory; }

   @Override
   public void add(User user) {
       sessionFactory.getCurrentSession().save(user);
   }

   @Override
   public List<User> listUsers() {
      TypedQuery<User> query=sessionFactory.getCurrentSession().createQuery("select u from User u", User.class);
      return query.getResultList();
   }
   public List<User> listUsersByCar (String model, int series) {
      TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("select u from User u " +
              "Where u.car.model = :model and u.car.series = :series", User.class);
      query.setParameter("model", model);
      query.setParameter("series", series);
      return query.getResultList();
   }
}
