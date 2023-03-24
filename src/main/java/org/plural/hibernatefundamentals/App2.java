package org.plural.hibernatefundamentals;

//import org.plural.hibernatefundamentals.airport_two.Airport;
//import org.plural.hibernatefundamentals.airport_two.Passenger;
import org.plural.hibernatefundamentals.airport_two.Passengers;
//import org.plural.hibernatefundamentals.airport_two.Ticket;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Hello world!
 *
 */
public class App2
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernatefundamentals.m03.ex01");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Passengers jhon = new Passengers(3, "Jhon Smith", "3 Flower Street, Boston");


//        Passenger mike = new Passenger(4, "Mike Smith");

        em.persist(jhon);
//        em.persist(mike);

        em.getTransaction().commit();
        emf.close();

    }
}
