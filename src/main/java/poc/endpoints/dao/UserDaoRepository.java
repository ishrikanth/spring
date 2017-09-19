package poc.endpoints.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import poc.endpoints.entity.UserEntity;

import java.util.UUID;

/**
 * Created by shrikanth on 27/7/17.
 */
@Repository
public interface UserDaoRepository extends CrudRepository<UserEntity,Integer> {
    public UserEntity findByEmail(String email);

}
