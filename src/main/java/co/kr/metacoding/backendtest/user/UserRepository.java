package co.kr.metacoding.backendtest.user;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class UserRepository {
    private final EntityManager entityManager;

    public void insert(User user) {
        entityManager.persist(user);
    }

    public User findById(Integer id) {
        return entityManager.find(User.class, id);
    }
}
