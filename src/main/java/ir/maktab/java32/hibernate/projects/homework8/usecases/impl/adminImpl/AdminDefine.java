package ir.maktab.java32.hibernate.projects.homework8.usecases.impl.adminImpl;

import ir.maktab.java32.hibernate.projects.homework8.config.hibernate.repositories.HibernateUtil;
import ir.maktab.java32.hibernate.projects.homework8.entities.Role;
import ir.maktab.java32.hibernate.projects.homework8.entities.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class AdminDefine {
    public boolean isAdmin(User user){
     boolean isAdmin = false;
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Role role = session.load(Role.class,1L);
        List<User> admins = role.getUsers();
        for(User admin:admins){
            if(admin.getId()==user.getId()){
                isAdmin = true;
            }
        }

        session.getTransaction().commit();
        session.close();
     return isAdmin;
    }
}
