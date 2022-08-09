package de.mms.waterMe.api.Users;

import de.mms.waterMe.database.entity.UserEntity;
import de.mms.waterMe.database.repository.UserRepository;

import de.mms.waterMe.services.Users.UserService;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private UserService service;

    private UserModelAssembler assembler;


    public UserController (UserRepository repository, UserModelAssembler assembler) {
        this.service= new UserService(repository);
        this.assembler = assembler;
    }

    @PostMapping("/")
    public ResponseEntity<?> newUser(@RequestBody UserEntity userEntity) {
        EntityModel<UserEntity> entityModel = assembler.toModel(service.newUser(userEntity));

        return ResponseEntity.status(200).header("CREATED USER").body(entityModel);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> editUser(@PathVariable Long id, @RequestBody UserEntity userEntity) {
        userEntity.setId(id);
        EntityModel<UserEntity> entityModel = assembler.toModel(service.editUser(id, userEntity));

        return ResponseEntity.status(200).header("UPDATED USER").body(entityModel);
    }


    @GetMapping("/{id}")
    public ResponseEntity<?> oneUser(@PathVariable Long id) {
        EntityModel<UserEntity> entityModel = assembler.toModel(service.oneUser(id));

        return ResponseEntity.status(200).header("FETCHED USER SUCCESSFULLY").body(entityModel);
    }

    @GetMapping("/all")
    public ResponseEntity<?> allUsers() {
        List<UserEntity> userEntities = service.allUsers();
        CollectionModel<EntityModel<UserEntity>> responseBody = assembler.allToModel(userEntities);

        return ResponseEntity.status(200).header("FETCHED SUCCESSFULLY").body(responseBody);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Long id){
        service.deleteUser(id);
        EntityModel<?> entityModel = assembler.deletedToModel();

        return ResponseEntity.status(200).header("DELETED SUCESSFULLY").body(entityModel);
    }

}