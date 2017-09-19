package poc.endpoints.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import poc.endpoints.dao.UserDaoRepository;
import poc.endpoints.dto.UserDto;
import poc.endpoints.exceptions.EmailExistsException;
import poc.endpoints.entity.UserEntity;

import java.util.Arrays;

/**
 * Created by shrikanth on 27/7/17.
 */
@Service
public class UserService implements IUserService {
    @Autowired
    private UserDaoRepository repository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Transactional
    @Override
    public UserEntity registerNewUserAccount(UserDto accountDto)
            throws EmailExistsException {

        if (emailExist(accountDto.getEmail())) {
            throw new EmailExistsException(
                    "There is an account with that email address:  "+ accountDto.getEmail());
        }
        UserEntity userEntity = new UserEntity();
        userEntity.setFirstName(accountDto.getFirstName());
        userEntity.setLastName(accountDto.getLastName());
        userEntity.setPassword(passwordEncoder.encode(accountDto.getPassword()));
        userEntity.setEmail(accountDto.getEmail());
        userEntity.setRoles(Arrays.asList("ROLE_USER"));
        return repository.save(userEntity);
    }
    private boolean emailExist(String email) {
        UserEntity userEntity = repository.findByEmail(email);
        if (userEntity != null) {
            return true;
        }
        return false;
    }
}