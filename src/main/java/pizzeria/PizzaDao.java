package pizzeria;

import java.util.List;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

public class PizzaDao {


  public static void create(final Pizza newPizza) {
    EntityManager em = DatabaseManager.getInstance().getEntityManager();
    try {
      EntityTransaction et = em.getTransaction();
      et.begin();
      em.persist(newPizza);
      et.commit();
    } finally {
      em.close();
    }
  }

  public static List<Pizza> readAll() {
    EntityManager em = DatabaseManager.getInstance().getEntityManager();
    try {
      TypedQuery<Pizza> query = em.createQuery("select p from Pizza p", Pizza.class);
      return query.getResultList();
    } finally {
      em.close();
    }
  }


  public static Pizza read(final String id) {
    EntityManager em = DatabaseManager.getInstance().getEntityManager();
    try {
      return em.find(Pizza.class, id);
    } finally {
      em.close();
    }
  }

  public static void update(final Pizza newPizza) {
    EntityManager em = DatabaseManager.getInstance().getEntityManager();
    try {
      EntityTransaction et = em.getTransaction();
      et.begin();
      Pizza result = em.find(Pizza.class, newPizza.getId());
      if(null != result) {
        em.merge(newPizza);
        et.commit();
      }
    } finally {
      em.close();
    }
  }

  public static void delete(final String id) {
    EntityManager em = DatabaseManager.getInstance().getEntityManager();
    try {
      EntityTransaction et = em.getTransaction();
      et.begin();
      Pizza pizza = em.find(Pizza.class, id);
      if (null != pizza) {
        em.remove(pizza);
      }
      et.commit();

    } finally {
      em.close();
    }
  }
}
