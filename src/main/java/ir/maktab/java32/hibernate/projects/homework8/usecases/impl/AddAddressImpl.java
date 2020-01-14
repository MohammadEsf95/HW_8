package ir.maktab.java32.hibernate.projects.homework8.usecases.impl;

import ir.maktab.java32.hibernate.projects.homework8.config.hibernate.repositories.HibernateUtil;
import ir.maktab.java32.hibernate.projects.homework8.entities.Address;
import ir.maktab.java32.hibernate.projects.homework8.usecases.usecase.AddAddress;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.Scanner;

public class AddAddressImpl implements AddAddress {
    @Override
    public void add() {
        Scanner scanner = new Scanner(System.in);
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();


        System.out.println("country: ");
        String country = scanner.nextLine();
        System.out.println("city: ");
        String city =scanner.nextLine();
        System.out.println("street: ");
        String street = scanner.nextLine();
        System.out.println("number: ");
        Long number = Long.parseLong(scanner.nextLine());
        Address address = new Address(country,city,street,number);

        session.save(address);
        session.getTransaction().commit();
        session.close();
    }
}
