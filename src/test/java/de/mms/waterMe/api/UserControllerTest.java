//package de.mms.waterMe.api;
//
//import de.mms.waterMe.api.Users.UserController;
//import de.mms.waterMe.api.Users.UserModelAssembler;
//import de.mms.waterMe.database.entity.IrrigationEntity;
//import de.mms.waterMe.database.entity.PlantEntity;
//import de.mms.waterMe.database.entity.User;
//import de.mms.waterMe.database.repository.UserRepository;
//import de.mms.waterMe.services.Users.UserNotFoundException;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.http.ResponseEntity;
//
//import java.util.Set;
//
//
//@SpringBootTest
//@AutoConfigureMockMvc
//public class UserControllerTest {
//
//    @Autowired
//    UserRepository repository;
//
//    @Autowired
//    UserModelAssembler assembler;
//
//
//    @BeforeEach
//    void initDatabase() {
//        UserController userController = new UserController(repository, assembler);
//
//        userController.newUser(initOne());
//        userController.newUser(initOne());
//        userController.newUser(initOne());
//    }
//
//    @Test
//    void PostingTest() {
//        UserController userController = new UserController(repository, assembler);
//        ResponseEntity<?> result = userController.newUser(initOne());
//
//        Assertions.assertEquals(200, result.getStatusCodeValue());
//    }
//
//    @Test
//    void GetOneTest() {
//        UserController userController = new UserController(repository, assembler);
//        ResponseEntity<?> result = userController.oneUser((long) 1);
//
//        Assertions.assertEquals(200, result.getStatusCodeValue());
//
//    }
//
//    @Test
//    void UpdateTest() {
//        UserController userController = new UserController(repository, assembler);
//        User user = initOne();
//        ResponseEntity<?> result = userController.editUser((long) 2, user);
//
//        Assertions.assertEquals(200, result.getStatusCodeValue());
//    }
//
//    @Test
//    void DeleteTest() {
//        UserController userController = new UserController(repository, assembler);
//        ResponseEntity<?> result = userController.deleteUser((long) 3);
//
//        Assertions.assertEquals(200, result.getStatusCodeValue());
//        Assertions.assertThrows(UserNotFoundException.class, () -> {
//            userController.oneUser((long) 3);
//        });
//    }
//
//    @Test
//    void GetAllTest() {
//        UserController userController = new UserController(repository, assembler);
//        ResponseEntity<?> result = userController.allUsers();
//
//        Assertions.assertEquals(200, result.getStatusCodeValue());
//    }
//
////    User initOne() {
////        User user = new User("lola@gmail.com","lola" + (int) (100000*Math.random()),"1234","Admin");
////
////        return user;
////    }
//
////    User initOne() {
////        User user = new User(5L,null,1,1);
////
////        return user;
////    }
//}
