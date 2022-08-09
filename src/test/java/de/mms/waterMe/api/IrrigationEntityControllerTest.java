package de.mms.waterMe.api;

import de.mms.waterMe.api.Irrigations.IrrigationController;
import de.mms.waterMe.api.Irrigations.IrrigationModelAssembler;
import de.mms.waterMe.database.entity.IrrigationEntity;
import de.mms.waterMe.database.repository.IrrigationRepository;
import de.mms.waterMe.services.Irrigations.IrrigationNotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.http.ResponseEntity;


@SpringBootTest
@AutoConfigureTestDatabase
public class IrrigationEntityControllerTest {

    @Autowired
    IrrigationRepository repository;

    @Autowired
    IrrigationModelAssembler assembler;

    @BeforeEach
    void initDatabase() {

        IrrigationController irrigationController = new IrrigationController(repository, assembler);

        irrigationController.newIrrigation(initOne());
        irrigationController.newIrrigation(initOne());
        irrigationController.newIrrigation(initOne());
    }


    @Test
    void PostingTest() {

        IrrigationController irrigationController = new IrrigationController(repository, assembler);

        ResponseEntity<?> result = irrigationController.newIrrigation(initOne());

        Assertions.assertEquals(200, result.getStatusCodeValue());
    }

    @Test
    void GetOneTest() {

        IrrigationController irrigationController = new IrrigationController(repository, assembler);

        ResponseEntity<?> result = irrigationController.oneIrrigation((long) 1);

        Assertions.assertEquals(200, result.getStatusCodeValue());
    }

    @Test
    void UpdateTest() {

        IrrigationController irrigationController = new IrrigationController(repository, assembler);
        IrrigationEntity irrigationEntity = initOne();

        ResponseEntity<?> result = irrigationController.editIrrigation((long) 2 , irrigationEntity);

        Assertions.assertEquals(200, result.getStatusCodeValue());
    }

    @Test
    void DeleteTest() {

        IrrigationController irrigationController = new IrrigationController(repository, assembler);
        ResponseEntity<?> result = irrigationController.deleteIrrigation((long) 3);

        Assertions.assertEquals(200, result.getStatusCodeValue());
        Assertions.assertThrows(IrrigationNotFoundException.class, () -> {
            irrigationController.oneIrrigation((long) 3);
        });
    }

    @Test
    void GetAllTest() {

        IrrigationController irrigationController = new IrrigationController(repository, assembler);

        ResponseEntity<?> result = irrigationController.allIrrigations();
        Assertions.assertEquals(200, result.getStatusCodeValue());
    }


    IrrigationEntity initOne() {
        IrrigationEntity irrigationEntity = new IrrigationEntity(Long.valueOf((int) (100000*Math.random())), Long.valueOf((int) (100000*Math.random())), 3);

        return irrigationEntity;
    }
}
