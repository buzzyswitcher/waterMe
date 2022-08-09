//package de.mms.waterMe.services;
//
//
//import de.mms.waterMe.database.entity.User;
//import de.mms.waterMe.services.Users.UserNotFoundException;
//import de.mms.waterMe.services.Users.UserService;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import java.util.List;
//
//@SpringBootTest
//public class UserServiceTest {
//
//    @Autowired
//    private UserService service;
//
//    @Test
//    void newUserTest() {
//
//        User user = initOne();
//        User comparisonUser = service.newUser(user);
//
//       // Assertions.assertEquals(comparisonUser.getName(), user.getName());
//        //Assertions.assertEquals(comparisonUser.getEmail(), user.getEmail());
//        Assertions.assertEquals(comparisonUser.getId(), user.getId());
//        Assertions.assertEquals(comparisonUser.getImage(), user.getImage());
//       // Assertions.assertEquals(comparisonUser.getPassword(), user.getPassword());
//       // Assertions.assertEquals(comparisonUser.getRole(), user.getRole());
//
//        service.deleteUser(comparisonUser.getId());
//    }
//
//    @Test
//    void editIrrigationTest() {
//
//        User user = initOne();
//        user.setId(service.newUser(user).getId());
//
//       // user.setRole("normal");
//       // user.setName("pepe");
//
//        service.editUser(user.getId(), user);
//        User comparisonUser = service.oneUser(user.getId());
//
//      //  Assertions.assertEquals(comparisonUser.getName(), user.getName());
//       // Assertions.assertEquals(comparisonUser.getEmail(), user.getEmail());
//        Assertions.assertEquals(comparisonUser.getId(), user.getId());
//        Assertions.assertEquals(comparisonUser.getImage(), user.getImage());
//      //  Assertions.assertEquals(comparisonUser.getPassword(), user.getPassword());
//       // Assertions.assertEquals(comparisonUser.getRole(), user.getRole());
//
//        service.deleteUser(comparisonUser.getId());
//    }
//
//    @Test
//    void oneIrrigationTest(){
//
//        User user = initOne();
//        user.setId(service.newUser(user).getId());
//
//        User comparisonUser = service.oneUser(user.getId());
//
//     //   Assertions.assertEquals(comparisonUser.getName(), user.getName());
//     //   Assertions.assertEquals(comparisonUser.getEmail(), user.getEmail());
//        Assertions.assertEquals(comparisonUser.getId(), user.getId());
//        Assertions.assertEquals(comparisonUser.getImage(), user.getImage());
//     //   Assertions.assertEquals(comparisonUser.getPassword(), user.getPassword());
//      //  Assertions.assertEquals(comparisonUser.getRole(), user.getRole());
//
//
//        service.deleteUser(comparisonUser.getId());
//    }
//
//    @Test
//    @AutoConfigureTestDatabase
//    void allUsersTest(){
//
//        User user1 = initOne();
//        User user2 = initTwo();
//
//        service.newUser(user1);
//        service.newUser(user2);
//
//        List<User> users = service.allUsers();
//
//        Assertions.assertEquals(users.size(), 2);
//
//       // Assertions.assertEquals(users.get(0).getName(), user1.getName());
//        Assertions.assertEquals(users.get(0).getId(),user1.getId());
//       // Assertions.assertEquals(users.get(0).getEmail(), user1.getEmail());
//      //  Assertions.assertEquals(users.get(0).getRole(), user1.getRole());
//        Assertions.assertEquals(users.get(0).getImage(), user1.getImage());
//      //  Assertions.assertEquals(users.get(0).getPassword(), user1.getPassword());
//
//      //  Assertions.assertEquals(users.get(1).getName(), user2.getName());
//        Assertions.assertEquals(users.get(1).getId(),user2.getId());
//      //  Assertions.assertEquals(users.get(1).getEmail(), user2.getEmail());
//       // Assertions.assertEquals(users.get(1).getRole(), user2.getRole());
//        Assertions.assertEquals(users.get(1).getImage(), user2.getImage());
//      //  Assertions.assertEquals(users.get(1).getPassword(), user2.getPassword());
//
//        service.deleteUser(users.get(0).getId());
//        service.deleteUser(users.get(1).getId());
//    }
//
//    @Test
//    void deleteIrrigationTest(){
//        User user1 = initOne();
//
//        User user = service.newUser(user1);
//        service.deleteUser(user.getId());
//        Assertions.assertThrows(UserNotFoundException.class, () -> {
//            service.oneUser(user.getId());
//        });
//    }
//
//
//
//
////    User initOne() {
////        User user = new User(1L,null,"1234","Admin");
////
////        return user;
////    }
////
////    User initTwo() {
////        User user = new User(1L,null,"12345","Admin");
////
////        return user;
////    }
//
//}
//
//
