package ir.maktab.java32.hibernate.projects.homework8.usecases.impl;

import ir.maktab.java32.hibernate.projects.homework8.config.hibernate.repositories.HibernateUtil;
import ir.maktab.java32.hibernate.projects.homework8.entities.Address;
import ir.maktab.java32.hibernate.projects.homework8.entities.Role;
import ir.maktab.java32.hibernate.projects.homework8.entities.User;
import ir.maktab.java32.hibernate.projects.homework8.usecases.usecase.SignUp;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SignUpImpl implements SignUp {
    @Override
    public void signUp() {
        Scanner scanner  = new Scanner(System.in);
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        System.out.println("Set your username: ");
        String userName = scanner.nextLine();

        System.out.println("Enter your national code: ");
        Long nationalCode = Long.parseLong(scanner.nextLine());


        System.out.println("Your default password is your national code");
        System.out.println("Enter your birthday: ");
        String birthday = scanner.nextLine();

        User user = new User(userName,nationalCode,birthday,nationalCode.toString());
        System.out.println(user.getUsername()+ " ,sign up is successfully completed! now login");

        Role role = session.find(Role.class,2L);
        List<Role> roles = new ArrayList<>();
        roles.add(role);
        user.setRoles(roles);

        session.save(user);
        session.getTransaction().commit();
        session.close();
    }
}
