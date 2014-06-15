/**
 * @author rsaraiva
 */
package com.rsaraiva.labs.vraptor4.service;

import com.rsaraiva.labs.vraptor4.model.Event;
import java.time.LocalDate;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class EventService {
    
    @PersistenceContext
    private EntityManager em;

    public void persist(String description, LocalDate date) {
        em.persist(new Event(description, date));
    }
    
    public List<Event> findAll() {
        return em.createQuery("select e from Event e order by e.description").getResultList();
    }
}
