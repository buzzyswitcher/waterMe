package de.mms.waterMe.services;

import de.mms.waterMe.database.entity.PlantSponsorEntity;
import de.mms.waterMe.services.PlantSponsors.PlantSponsorNotFoundException;
import de.mms.waterMe.services.PlantSponsors.PlantSponsorService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.hateoas.EntityModel;


import java.util.List;

@SpringBootTest
@AutoConfigureTestDatabase
public class PlantEntitySponsorServiceTest {
    @Autowired
    private PlantSponsorService service;

    @Test
    void newPlantSponsorTest() {

        PlantSponsorEntity plantSponsorEntity = initOne();
        PlantSponsorEntity comparisonPlantSponsorEntity = service.newPlantSponsor(plantSponsorEntity).getContent();

        Assertions.assertEquals(comparisonPlantSponsorEntity.getUser_id(), plantSponsorEntity.getUser_id());
        Assertions.assertEquals(comparisonPlantSponsorEntity.getPlant_id(), plantSponsorEntity.getPlant_id());


        service.deletePlantSponsor(comparisonPlantSponsorEntity.getId());
    }

    @Test
    void editPlantSponsorTest() {

        PlantSponsorEntity plantSponsorEntity = initOne();
        plantSponsorEntity.setId(service.newPlantSponsor(plantSponsorEntity).getContent().getId());


        service.editPlantSponsor(plantSponsorEntity.getId(), plantSponsorEntity);
        PlantSponsorEntity comparisonPlantSponsorEntity = service.onePlantSponsor(plantSponsorEntity.getId()).getContent();

        Assertions.assertEquals(comparisonPlantSponsorEntity.getUser_id(), plantSponsorEntity.getUser_id());
        Assertions.assertEquals(comparisonPlantSponsorEntity.getPlant_id(), plantSponsorEntity.getPlant_id());


        service.deletePlantSponsor(comparisonPlantSponsorEntity.getId());
    }

    @Test
    void onePlantSponsorTest(){

        PlantSponsorEntity plantSponsorEntity = initOne();
        plantSponsorEntity.setId(service.newPlantSponsor(plantSponsorEntity).getContent().getId());

        PlantSponsorEntity comparisonPlantSponsorEntity = service.onePlantSponsor(plantSponsorEntity.getId()).getContent();

        Assertions.assertEquals(comparisonPlantSponsorEntity.getUser_id(), plantSponsorEntity.getUser_id());
        Assertions.assertEquals(comparisonPlantSponsorEntity.getPlant_id(), plantSponsorEntity.getPlant_id());

        service.deletePlantSponsor(comparisonPlantSponsorEntity.getId());
    }

    @Test

    void allPlantSponsorsTest(){

        PlantSponsorEntity plantSponsorEntity1 = initOne();
        PlantSponsorEntity plantSponsorEntity2 = initOne();

        service.newPlantSponsor(plantSponsorEntity1);
        service.newPlantSponsor(plantSponsorEntity2);

        List<EntityModel<PlantSponsorEntity>> plantSponsors = service.allPlantSponsors();

        Assertions.assertEquals(plantSponsors.size(), 2);

        Assertions.assertEquals(plantSponsors.get(0).getContent().getUser_id(), plantSponsorEntity1.getUser_id());
        Assertions.assertEquals(plantSponsors.get(0).getContent().getPlant_id(), plantSponsorEntity1.getPlant_id());

        Assertions.assertEquals(plantSponsors.get(1).getContent().getUser_id(), plantSponsorEntity2.getUser_id());
        Assertions.assertEquals(plantSponsors.get(1).getContent().getPlant_id(), plantSponsorEntity2.getPlant_id());

        service.deletePlantSponsor(plantSponsors.get(0).getContent().getId());
        service.deletePlantSponsor(plantSponsors.get(1).getContent().getId());
    }

    @Test
    void deletePlantSponsorTest(){
        PlantSponsorEntity plantSponsorEntity1 = initOne();

        PlantSponsorEntity plantSponsorEntity = service.newPlantSponsor(plantSponsorEntity1).getContent();
        service.deletePlantSponsor(plantSponsorEntity.getId());
        Assertions.assertThrows(PlantSponsorNotFoundException.class, () -> {
            service.onePlantSponsor(plantSponsorEntity.getId());
        });
    }



    PlantSponsorEntity initOne() {
        PlantSponsorEntity plantSponsorEntity = new PlantSponsorEntity(3L, 4L);


        return plantSponsorEntity;
    }

}
