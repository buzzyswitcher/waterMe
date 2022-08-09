package de.mms.waterMe.api.Users;



import de.mms.waterMe.database.entity.UserEntity;
import de.mms.waterMe.services.Users.UserService;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@Component
public class UserModelAssembler implements RepresentationModelAssembler<UserEntity, EntityModel<UserEntity>> {
    @Override
    public EntityModel<UserEntity> toModel(UserEntity userEntity) {
        return EntityModel.of(userEntity,
                WebMvcLinkBuilder.linkTo(methodOn(UserController.class).oneUser(userEntity.getId())).withSelfRel(),
                linkTo(methodOn(UserController.class).allUsers()).withRel("users"));
    }

    public CollectionModel<EntityModel<UserEntity>> allToModel (List<UserEntity> userEntities) {

        List<EntityModel<UserEntity>> userModels = new ArrayList<>();

        for(UserEntity u : userEntities) {
            userModels.add(toModel(u));
        }

        return CollectionModel.of(
                userModels,
                WebMvcLinkBuilder.linkTo(methodOn(UserController.class).allUsers()).withSelfRel()
        );
    }

    public EntityModel<?> deletedToModel() {
        return EntityModel.of(
                WebMvcLinkBuilder.linkTo(methodOn(UserService.class).allUsers()).withRel("users"));

    }
}
