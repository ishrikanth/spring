package poc.endpoints.service;

import poc.endpoints.dto.UserDto;
import poc.endpoints.exceptions.EmailExistsException;
import poc.endpoints.entity.UserEntity;

/**
 * Created by shrikanth on 27/7/17.
 */
public interface IUserService {
    UserEntity registerNewUserAccount(UserDto accountDto)
            throws EmailExistsException;
}

