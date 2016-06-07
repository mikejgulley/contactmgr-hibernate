package com.lumatikmedia.contactmgr;

import com.lumatikmedia.contactmgr.model.Contact;
import com.lumatikmedia.contactmgr.model.Contact.ContactBuilder;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;

/**
 * Created by mgulley on 6/7/2016.
 */
public class Application {
    // Hold a reusable reference to a SessionFactory (since we need only one)
    //private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        // Create a StandardServiceRegistry
        final ServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
        return new MetadataSources(registry).buildMetadata().buildSessionFactory();
    }

    public static void main(String[] args) {
        Contact contact = new ContactBuilder("Mike", "Gulley")
                .withEmail("me@meow.com")
                .withPhone(5556667777L)
                .build();
        System.out.println(contact);
    }
}
