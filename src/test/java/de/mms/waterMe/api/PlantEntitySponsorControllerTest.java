//package de.mms.waterMe.api;
//
//import de.mms.waterMe.api.PlantSponsors.PlantSponsorController;
//import de.mms.waterMe.api.PlantSponsors.PlantSponsorModelAssembler;
//import de.mms.waterMe.database.entity.PlantSponsorEntity;
//import de.mms.waterMe.database.repository.PlantSponsorRepository;
//import de.mms.waterMe.services.PlantSponsors.PlantSponsorNotFoundException;
//
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import org.springframework.http.ResponseEntity;
//
//
//@SpringBootTest
//public class PlantEntitySponsorControllerTest {
//    @Autowired
//    PlantSponsorRepository repository;
//
//    @Autowired
//    PlantSponsorModelAssembler assembler;
//
//    @BeforeEach
//    void initDatabase() {
//
//        PlantSponsorController plantSponsorController = new PlantSponsorController(repository, assembler);
//
//        plantSponsorController.newPlantSponsor(initOne());
//        plantSponsorController.newPlantSponsor(initOne());
//        plantSponsorController.newPlantSponsor(initOne());
//    }
//
//
//    @Test
//    void PostingTest() {
//
//        PlantSponsorController plantSponsorController = new PlantSponsorController(repository, assembler);
//
//        ResponseEntity<?> result = plantSponsorController.newPlantSponsor(initOne());
//
//        Assertions.assertEquals(200, result.getStatusCodeValue());
//    }
//
//    @Test
//    void GetOneTest() {
//
//        PlantSponsorController plantSponsorController = new PlantSponsorController(repository, assembler);
//
//        ResponseEntity<?> result = plantSponsorController.onePlantSponsor((long) 1);
//
//        Assertions.assertEquals(200, result.getStatusCodeValue());
//    }
//
//    @Test
//    void UpdateTest() {
//
//        PlantSponsorController plantSponsorController = new PlantSponsorController(repository, assembler);
//        PlantSponsorEntity plantSponsorEntity = initOne();
//
//        ResponseEntity<?> result = plantSponsorController.editPlantSponsor((long) 2 , plantSponsorEntity);
//
//        Assertions.assertEquals(200, result.getStatusCodeValue());
//    }
//
//    @Test
//    void DeleteTest() {
//
//        PlantSponsorController plantSponsorController = new PlantSponsorController(repository, assembler);
//        ResponseEntity<?> result = plantSponsorController.deletePlantSponsor((long) 3);
//
//        Assertions.assertEquals(200, result.getStatusCodeValue());
//        Assertions.assertThrows(PlantSponsorNotFoundException.class, () -> {
//            plantSponsorController.onePlantSponsor((long) 3);
//        });
//    }
//
//    @Test
//    void GetAllTest() {
//
//        PlantSponsorController plantSponsorController = new PlantSponsorController(repository, assembler);
//
//        ResponseEntity<?> result = plantSponsorController.allPlantSponsors();
//        Assertions.assertEquals(200, result.getStatusCodeValue());
//    }
//
//
//    PlantSponsorEntity initOne() {
//        PlantSponsorEntity plantSponsorEntity = new PlantSponsorEntity(3L,4L);
//
//
//        return plantSponsorEntity;
//    }
//
//}
