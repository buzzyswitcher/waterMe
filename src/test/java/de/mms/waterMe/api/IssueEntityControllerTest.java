//package de.mms.waterMe.api;
//
//import de.mms.waterMe.api.Issues.IssueController;
//import de.mms.waterMe.api.Issues.IssueModelAssembler;
//import de.mms.waterMe.database.entity.IssueEntity;
//import de.mms.waterMe.database.repository.IssueRepository;
//import de.mms.waterMe.services.Issues.IssueNotFoundException;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.http.ResponseEntity;
//
//import java.util.Date;
//
//
//@SpringBootTest
//@AutoConfigureTestDatabase
//public class IssueEntityControllerTest {
//
//    @Autowired
//    IssueRepository repository;
//
//    @Autowired
//    IssueModelAssembler assembler;
//
//
//
//    @BeforeEach
//    void initDatabase() {
//        IssueController issueController = new IssueController(repository, assembler);
//
//        issueController.newIssue(initOne());
//        issueController.newIssue(initOne());
//        issueController.newIssue(initOne());
//    }
//
//    @Test
//    void PostingTest() {
//        IssueController issueController = new IssueController(repository, assembler);
//        ResponseEntity<?> result = issueController.newIssue(initOne());
//
//        Assertions.assertEquals(200, result.getStatusCodeValue());
//    }
//
//    @Test
//    void GetOneTest() {
//        IssueController issueController = new IssueController(repository, assembler);
//        ResponseEntity<?> result = issueController.oneIssue((long) 1);
//
//        Assertions.assertEquals(200, result.getStatusCodeValue());
//
//    }
//
//    @Test
//    void UpdateTest() {
//        IssueController issueController = new IssueController(repository, assembler);
//        IssueEntity issueEntity = initOne();
//        ResponseEntity<?> result = issueController.editIssue((long) 2, issueEntity);
//
//        Assertions.assertEquals(200, result.getStatusCodeValue());
//    }
//
//    @Test
//    void DeleteTest() {
//        IssueController issueController = new IssueController(repository, assembler);
//        ResponseEntity<?> result = issueController.deleteIssue((long) 3);
//
//        Assertions.assertEquals(200, result.getStatusCodeValue());
//        Assertions.assertThrows(IssueNotFoundException.class, () -> {
//            issueController.oneIssue((long) 3);
//        });
//    }
//
//    @Test
//    void GetAllTest() {
//        IssueController issueController = new IssueController(repository, assembler);
//        ResponseEntity<?> result = issueController.allIssues();
//
//        Assertions.assertEquals(200, result.getStatusCodeValue());
//    }
//
//    IssueEntity initOne() {
//        IssueEntity issueEntity = new IssueEntity(Long.valueOf((int) (100000*Math.random())), "asdcasdhge", "test".getBytes(), new Date());
//
//        return issueEntity;
//    }
//}
