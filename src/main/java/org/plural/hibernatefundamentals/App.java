package org.plural.hibernatefundamentals;

import org.plural.hibernatefundamentals.airport.Airport;
import org.plural.hibernatefundamentals.airport.Passenger;
import org.plural.hibernatefundamentals.airport.Ticket;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernatefundamentals.m02.ex01");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Airport airport = new Airport(2, "Jorge Wilsterman 2");

        Passenger jhon = new Passenger(3, "Jhon Smith");
        jhon.setAirport(airport);

        Passenger mike = new Passenger(4, "Mike Smith");
        mike.setAirport(airport);

        airport.addPassengers(jhon);
        airport.addPassengers(mike);

        Ticket ticket1 = new Ticket(5, "1223");
        ticket1.setPassenger(jhon);
        Ticket ticket2 = new Ticket(6, "1224");
        ticket2.setPassenger(jhon);

        jhon.addTicket(ticket1);
        jhon.addTicket(ticket2);

        Ticket ticket3 = new Ticket(7, "1225");
        ticket3.setPassenger(mike);
        mike.addTicket(ticket3);

        em.persist(airport);
        em.persist(jhon);
        em.persist(mike);
        em.persist(ticket1);
        em.persist(ticket2);
        em.persist(ticket3);

        em.getTransaction().commit();
        emf.close();

    }
}
