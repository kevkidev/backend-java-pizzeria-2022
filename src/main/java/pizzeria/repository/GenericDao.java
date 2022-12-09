package pizzeria.repository;

import java.util.List;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import pizzeria.domain.MotherEntity;

class GenericDao<T> {

  public void create(final T object) {
    EntityManager em = DatabaseManager.getInstance().getEntityManager();
    try {
      EntityTransaction et = em.getTransaction();
      et.begin();
      em.persist(object);
      et.commit();
    } finally {
      em.close();
    }
  }

  public List<T> readAll(Class<T> classResult) {
    EntityManager em = DatabaseManager.getInstance().getEntityManager();
    try {
      final String JPQL_QUERY = "select t from " + classResult.getName() + " t";
      TypedQuery<T> query = em.createQuery(JPQL_QUERY, classResult);
      return query.getResultList();
    } finally {
      em.close();
    }
  }

  public T read(final Long id, Class<T> classResult) {
    EntityManager em = DatabaseManager.getInstance().getEntityManager();
    try {
      return em.find(classResult, id);
    } finally {
      em.close();
    }
  }

  public List<T> readByName(final String name, Class<T> classResult) {
    EntityManager em = DatabaseManager.getInstance().getEntityManager();
    try {
      final String REF_NAME = "name";
      final String JPQL_QUERY = "SELECT p FROM " + classResult.getName()
          + " p WHERE p.name LIKE CONCAT('%',:" + REF_NAME + ",'%')";
      TypedQuery<T> query = em.createQuery(JPQL_QUERY, classResult);
      query.setParameter(REF_NAME, name);
      return query.getResultList();
    } finally {
      em.close();
    }
  }

  public <T extends MotherEntity> void update(final T object, Class<T> classResult) {
    EntityManager em = DatabaseManager.getInstance().getEntityManager();
    try {
      EntityTransaction et = em.getTransaction();
      et.begin();
      T result = em.find(classResult, object.getId());
      if (null != result) {
        result.update(object);
        em.merge(result);
        et.commit();
      }
    } finally {
      em.close();
    }
  }

  public void delete(final Long id, Class<T> classResult) {
    EntityManager em = DatabaseManager.getInstance().getEntityManager();
    try {
      EntityTransaction et = em.getTransaction();
      et.begin();
      T object = em.find(classResult, id);
      if (null != object) {
        em.remove(object);
      }
      et.commit();

    } finally {
      em.close();
    }
  }
}
