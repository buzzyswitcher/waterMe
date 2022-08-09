package de.mms.waterMe.api;

import de.mms.waterMe.api.Plants.PlantController;
import de.mms.waterMe.api.Plants.PlantModelAssembler;
import de.mms.waterMe.database.entity.PlantEntity;
import de.mms.waterMe.database.repository.PlantRepository;
import de.mms.waterMe.services.Plants.PlantNotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.http.ResponseEntity;

import java.time.LocalDate;


@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class PlantEntityControllerTest {

    @Autowired
    PlantRepository repository;

    @Autowired
    PlantModelAssembler assembler;

    @BeforeEach
    @AutoConfigureTestDatabase
    void initDatabase() {

        PlantController plantController = new PlantController(repository, assembler);

        plantController.newPlant(initOne());
        plantController.newPlant(initOne());
        plantController.newPlant(initOne());
    }


    @Test
    @Order(1)
    void PostingTest() {

        PlantController plantController = new PlantController(repository, assembler);

        ResponseEntity<?> result = plantController.newPlant(initOne());

        Assertions.assertEquals(200, result.getStatusCodeValue());
    }

    @Test
    @Order(2)
    void GetOneTest() {

        PlantController plantController = new PlantController(repository, assembler);

        ResponseEntity<?> result = plantController.onePlant((long) 1);

        Assertions.assertEquals(200, result.getStatusCodeValue());
    }

    @Test
    @Order(3)
    void UpdateTest() {

        PlantController plantController = new PlantController(repository, assembler);
        PlantEntity plantEntity = initOne();

        ResponseEntity<?> result = plantController.editPlant((long) 2 , plantEntity);

        Assertions.assertEquals(200, result.getStatusCodeValue());
    }

    @Test
    @Order(4)
    void DeleteTest() {

        PlantController plantController = new PlantController(repository, assembler);
        ResponseEntity<?> result = plantController.deletePlant((long) 3);

        Assertions.assertEquals(200, result.getStatusCodeValue());
        Assertions.assertThrows(PlantNotFoundException.class, () -> {
            plantController.onePlant((long) 3);
        });
    }

    @Test
    @Order(5)
    void GetAllTest() {

        PlantController plantController = new PlantController(repository, assembler);

        ResponseEntity<?> result = plantController.allPlants();
        System.out.println(result.toString());
        Assertions.assertEquals(200, result.getStatusCodeValue());
    }


    PlantEntity initOne() {
        PlantEntity plantEntity = new PlantEntity("starIcon", LocalDate.of(2021,12,31), "room 4a",3, "Rosa", "www.rosa.de");


        return plantEntity;
    }
}
