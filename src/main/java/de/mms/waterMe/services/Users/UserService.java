package de.mms.waterMe.services.Users;


import de.mms.waterMe.database.entity.UserEntity;
import de.mms.waterMe.database.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;
import java.util.stream.Collectors;


@Service
@ResponseBody
@ResponseStatus


public class UserService {

    private UserRepository repository;

    public UserService( UserRepository repository) {
        this.repository =repository;
    }

    public UserEntity newUser(UserEntity userEntity) {
        return repository.save(userEntity);
    }

    public UserEntity editUser(Long id, UserEntity userEntity) {
        UserEntity updatedUserEntity = repository.findById(id)
                .map( targetUser -> {
                    userEntity.setId(targetUser.getId());
                    return repository.save(userEntity);
                })
                .orElseThrow(() -> new UserNotFoundException(id));

        return updatedUserEntity;
    }

    public UserEntity oneUser(Long id) {
        UserEntity userEntity = repository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));

        return userEntity;
    }


    public List<UserEntity> allUsers(){
        List<UserEntity> userEntities = repository.findAll()
                .stream()
                .collect(Collectors.toList());

        return userEntities;
    }

    public UserEntity deleteUser(Long id) {
        UserEntity userEntity = repository.findById(id).map(
                target ->  {
                    repository.delete(target);
                    return target;
                }
        ).orElseThrow(() -> new UserNotFoundException(id));

        return userEntity;
    }

}
