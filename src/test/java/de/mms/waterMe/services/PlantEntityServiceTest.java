package de.mms.waterMe.services;

import de.mms.waterMe.services.Plants.PlantNotFoundException;
import de.mms.waterMe.database.entity.PlantEntity;
import de.mms.waterMe.services.Plants.PlantService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.hateoas.EntityModel;

import java.time.LocalDate;
import java.util.List;

@SpringBootTest
@AutoConfigureTestDatabase
public class PlantEntityServiceTest {

    @Autowired
    private PlantService service;

    @Test
    void newPlantTest() {

        PlantEntity plantEntity = initOne();
        PlantEntity comparisonPlantEntity = service.newPlant(plantEntity).getContent();

        Assertions.assertEquals(comparisonPlantEntity.getIcon(), plantEntity.getIcon());
        Assertions.assertEquals(comparisonPlantEntity.getSoilChanged(), plantEntity.getSoilChanged());
        Assertions.assertEquals(comparisonPlantEntity.getRoom(), plantEntity.getRoom());
        Assertions.assertEquals(comparisonPlantEntity.getFloor(), plantEntity.getFloor());
        Assertions.assertEquals(comparisonPlantEntity.getName(), plantEntity.getName());
        Assertions.assertEquals(comparisonPlantEntity.getWikiLink(), plantEntity.getWikiLink());

        service.deletePlant(comparisonPlantEntity.getId());
    }

    @Test
    void editPlantTest() {

        PlantEntity plantEntity = initOne();
        plantEntity.setId(service.newPlant(plantEntity).getContent().getId());


        service.editPlant(plantEntity.getId(), plantEntity);
        PlantEntity comparisonPlantEntity = service.onePlant(plantEntity.getId()).getContent();

        Assertions.assertEquals(comparisonPlantEntity.getIcon(), plantEntity.getIcon());
        Assertions.assertEquals(comparisonPlantEntity.getSoilChanged().compareTo(comparisonPlantEntity.getSoilChanged()),0);
        Assertions.assertEquals(comparisonPlantEntity.getRoom(), plantEntity.getRoom());
        Assertions.assertEquals(comparisonPlantEntity.getFloor(), plantEntity.getFloor());
        Assertions.assertEquals(comparisonPlantEntity.getName(), plantEntity.getName());
        Assertions.assertEquals(comparisonPlantEntity.getWikiLink(), plantEntity.getWikiLink());

        service.deletePlant(comparisonPlantEntity.getId());
    }

    @Test
    void onePlantTest(){

        PlantEntity plantEntity = initOne();
        plantEntity.setId(service.newPlant(plantEntity).getContent().getId());

        PlantEntity comparisonPlantEntity = service.onePlant(plantEntity.getId()).getContent();

        Assertions.assertEquals(comparisonPlantEntity.getIcon(), plantEntity.getIcon());
        Assertions.assertEquals(comparisonPlantEntity.getSoilChanged().compareTo(comparisonPlantEntity.getSoilChanged()),0);
        Assertions.assertEquals(comparisonPlantEntity.getRoom(), plantEntity.getRoom());
        Assertions.assertEquals(comparisonPlantEntity.getFloor(), plantEntity.getFloor());
        Assertions.assertEquals(comparisonPlantEntity.getName(), plantEntity.getName());
        Assertions.assertEquals(comparisonPlantEntity.getWikiLink(), plantEntity.getWikiLink());

        service.deletePlant(comparisonPlantEntity.getId());
    }

    @Test

    void allPlantsTest(){

        PlantEntity plantEntity1 = initOne();
        PlantEntity plantEntity2 = initOne();

        service.newPlant(plantEntity1);
        service.newPlant(plantEntity2);

        List<EntityModel<PlantEntity>> plants = service.allPlants();

        Assertions.assertEquals(plants.size(), 2);

        Assertions.assertEquals(plants.get(0).getContent().getIcon(), plantEntity1.getIcon());
        Assertions.assertEquals(plants.get(0).getContent().getSoilChanged().compareTo(plantEntity1.getSoilChanged()),0);
        Assertions.assertEquals(plants.get(0).getContent().getRoom(), plantEntity1.getRoom());
        Assertions.assertEquals(plants.get(0).getContent().getFloor(), plantEntity1.getFloor());
        Assertions.assertEquals(plants.get(0).getContent().getName(), plantEntity1.getName());
        Assertions.assertEquals(plants.get(0).getContent().getWikiLink(), plantEntity1.getWikiLink());

        Assertions.assertEquals(plants.get(1).getContent().getIcon(), plantEntity2.getIcon());
        Assertions.assertEquals(plants.get(1).getContent().getSoilChanged().compareTo(plantEntity2.getSoilChanged()),0);
        Assertions.assertEquals(plants.get(1).getContent().getRoom(), plantEntity2.getRoom());
        Assertions.assertEquals(plants.get(1).getContent().getFloor(), plantEntity2.getFloor());
        Assertions.assertEquals(plants.get(1).getContent().getName(), plantEntity2.getName());
        Assertions.assertEquals(plants.get(1).getContent().getWikiLink(), plantEntity2.getWikiLink());

        service.deletePlant(plants.get(0).getContent().getId());
        service.deletePlant(plants.get(1).getContent().getId());
    }

    @Test
    void deletePlantTest(){
        PlantEntity plantEntity1 = initOne();

        PlantEntity plantEntity = service.newPlant(plantEntity1).getContent();
        service.deletePlant(plantEntity.getId());
        Assertions.assertThrows(PlantNotFoundException.class, () -> {
            service.onePlant(plantEntity.getId());
        });
    }




    PlantEntity initOne() {
        PlantEntity plantEntity = new PlantEntity("starIcon", LocalDate.of(2021,12,31), "room 4a",3, "Rosa", "www.rosa.de");


        return plantEntity;
    }

}

