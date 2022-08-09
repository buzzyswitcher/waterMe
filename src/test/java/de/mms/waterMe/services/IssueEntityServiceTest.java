package de.mms.waterMe.services;

import de.mms.waterMe.database.entity.IssueEntity;
import de.mms.waterMe.services.Issues.IssueNotFoundException;
import de.mms.waterMe.services.Issues.IssueService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootTest
public class IssueEntityServiceTest {

    @Autowired
    private IssueService service;

    @Test
    void newIssueTest() {
        IssueEntity originalIssueEntity = initOne();
        IssueEntity databaseIssueEntity = service.newIssue(originalIssueEntity);

        Assertions.assertTrue(originalIssueEntity.equals(databaseIssueEntity));

        service.deleteIssue(databaseIssueEntity.getId());
    }

    @Test
    void editIssueTest() {
        IssueEntity originalIssueEntity = initOne();
        IssueEntity databaseIssueEntity = service.newIssue(originalIssueEntity);
        originalIssueEntity = initOne();
        IssueEntity editedIssueEntity = service.editIssue(databaseIssueEntity.getId(), originalIssueEntity);

        Assertions.assertTrue(originalIssueEntity.equals(editedIssueEntity));

        service.deleteIssue(databaseIssueEntity.getId());
    }

    @Test
    void oneIssueTest() {
        IssueEntity originalIssueEntity = initOne();
        IssueEntity databaseIssueEntity = service.newIssue(originalIssueEntity);

        Assertions.assertTrue(originalIssueEntity.equals(service.oneIssue(databaseIssueEntity.getId())));

        service.deleteIssue(databaseIssueEntity.getId());
    }

    @Test
    void allIssuesTest() {
        List<IssueEntity> issueEntities = new ArrayList<>();

        issueEntities.add(initOne());
        issueEntities.add(initOne());

        for (IssueEntity i : issueEntities) {
            IssueEntity databaseIssueEntity = service.newIssue(i);

            Assertions.assertTrue(i.equals(service.oneIssue(databaseIssueEntity.getId())));

            service.deleteIssue(databaseIssueEntity.getId());
        }
    }

    @Test
    void deleteIssueTest() {
        IssueEntity originalIssueEntity = initOne();
        IssueEntity databaseIssueEntity = service.newIssue(originalIssueEntity);

        service.deleteIssue(databaseIssueEntity.getId());

        Assertions.assertThrows(IssueNotFoundException.class, () -> {
            service.oneIssue(databaseIssueEntity.getId());
        });
    }

    IssueEntity initOne() {
        IssueEntity issueEntity = new IssueEntity(Long.valueOf((int) (100000*Math.random())), "asdcasdhge", "test".getBytes(), new Date());

        return issueEntity;
    }

}
