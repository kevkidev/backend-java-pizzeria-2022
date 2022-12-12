package pizzeria.repository;

import java.util.List;
import org.springframework.stereotype.Repository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import pizzeria.domain.MotherEntity;

@Repository
class GenericDao<T> {

  @PersistenceContext
  private EntityManager entityManager;

  @Transactional
  public void create(final T object) {
    entityManager.persist(object);
  }

  @Transactional
  public List<T> readAll(Class<T> classResult) {
    final String JPQL_QUERY = "select t from " + classResult.getName() + " t";
    TypedQuery<T> query = entityManager.createQuery(JPQL_QUERY, classResult);
    return query.getResultList();
  }

  @Transactional
  public T read(final Long id, Class<T> classResult) {
    return entityManager.find(classResult, id);
  }

  @Transactional
  public List<T> readByName(final String name, Class<T> classResult) {

    final String REF_NAME = "name";
    final String JPQL_QUERY = "SELECT p FROM " + classResult.getName()
        + " p WHERE p.name LIKE CONCAT('%',:" + REF_NAME + ",'%')";
    TypedQuery<T> query = entityManager.createQuery(JPQL_QUERY, classResult);
    query.setParameter(REF_NAME, name);
    return query.getResultList();

  }

  @Transactional
  public <T extends MotherEntity> void update(final T object, Class<T> classResult) {
    T result = entityManager.find(classResult, object.getId());
    if (null != result) {
      result.update(object);
      entityManager.merge(result);
    }
  }

  @Transactional
  public void delete(final Long id, Class<T> classResult) {
    T object = entityManager.find(classResult, id);
    if (null != object) {
      entityManager.remove(object);
    }
  }
}
