//package de.mms.waterMe.services;
//
//import de.mms.waterMe.services.Irrigations.IrrigationNotFoundException;
//import de.mms.waterMe.database.entity.IrrigationEntity;
//import de.mms.waterMe.services.Irrigations.IrrigationService;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.hateoas.EntityModel;
//
//import java.util.List;
//
//@SpringBootTest
//@AutoConfigureTestDatabase
//public class IrrigationEntityServiceTest {
//
//    @Autowired
//    private IrrigationService service;
//
//    @Test
//    void newIrrigationTest() {
//
//        IrrigationEntity irrigationEntity = initOne();
//        IrrigationEntity comparisonIrrigationEntity = service.newIrrigation(irrigationEntity).getContent();
//
//        Assertions.assertEquals(comparisonIrrigationEntity.getAmount(), irrigationEntity.getAmount());
//        Assertions.assertEquals(comparisonIrrigationEntity.getDate(), irrigationEntity.getDate());
//        Assertions.assertEquals(comparisonIrrigationEntity.getPlant_id(), irrigationEntity.getPlant_id());
//        Assertions.assertEquals(comparisonIrrigationEntity.getUser_id(), irrigationEntity.getUser_id());
//
//        service.deleteIrrigation(comparisonIrrigationEntity.getId());
//    }
//
//    @Test
//    void editIrrigationTest() {
//
//        IrrigationEntity irrigationEntity = initOne();
//        irrigationEntity.setId(service.newIrrigation(irrigationEntity).getContent().getId());
//
//        irrigationEntity.setUser_id((long) 5);
//        irrigationEntity.setPlant_id((long) 5);
//
//        service.editIrrigation(irrigationEntity.getId(), irrigationEntity);
//        IrrigationEntity comparisonIrrigationEntity = service.oneIrrigation(irrigationEntity.getId()).getContent();
//
//        Assertions.assertEquals(comparisonIrrigationEntity.getAmount(), irrigationEntity.getAmount());
//        Assertions.assertEquals(irrigationEntity.getDate().compareTo(comparisonIrrigationEntity.getDate()),0);
//        Assertions.assertEquals(comparisonIrrigationEntity.getPlant_id(), irrigationEntity.getPlant_id());
//        Assertions.assertEquals(comparisonIrrigationEntity.getUser_id(), irrigationEntity.getUser_id());
//
//        service.deleteIrrigation(comparisonIrrigationEntity.getId());
//    }
//
//    @Test
//    void oneIrrigationTest(){
//
//        IrrigationEntity irrigationEntity = initOne();
//        irrigationEntity.setId(service.newIrrigation(irrigationEntity).getContent().getId());
//
//        IrrigationEntity comparisonIrrigationEntity = service.oneIrrigation(irrigationEntity.getId()).getContent();
//
//        Assertions.assertEquals(comparisonIrrigationEntity.getAmount(), irrigationEntity.getAmount());
//        Assertions.assertEquals(irrigationEntity.getDate().compareTo(comparisonIrrigationEntity.getDate()),0);
//        Assertions.assertEquals(comparisonIrrigationEntity.getPlant_id(), irrigationEntity.getPlant_id());
//        Assertions.assertEquals(comparisonIrrigationEntity.getUser_id(), irrigationEntity.getUser_id());
//
//        service.deleteIrrigation(comparisonIrrigationEntity.getId());
//    }
//
//    @Test
//    void allIrrigationsTest(){
//
//        IrrigationEntity irrigationEntity1 = initOne();
//        IrrigationEntity irrigationEntity2 = initOne();
//
//        service.newIrrigation(irrigationEntity1);
//        service.newIrrigation(irrigationEntity2);
//
//        List<EntityModel<IrrigationEntity>> irrigations = service.allIrrigations();
//
//        Assertions.assertEquals(irrigations.get(0).getContent().getAmount(), irrigationEntity1.getAmount());
//        Assertions.assertEquals(irrigations.get(0).getContent().getDate().compareTo(irrigationEntity1.getDate()),0);
//        Assertions.assertEquals(irrigations.get(0).getContent().getPlant_id(), irrigationEntity1.getPlant_id());
//        Assertions.assertEquals(irrigations.get(0).getContent().getUser_id(), irrigationEntity1.getUser_id());
//
//        Assertions.assertEquals(irrigations.get(1).getContent().getAmount(), irrigationEntity2.getAmount());
//        Assertions.assertEquals(irrigations.get(1).getContent().getDate().compareTo(irrigationEntity2.getDate()),0);
//        Assertions.assertEquals(irrigations.get(1).getContent().getPlant_id(), irrigationEntity2.getPlant_id());
//        Assertions.assertEquals(irrigations.get(1).getContent().getUser_id(), irrigationEntity2.getUser_id());
//
//        service.deleteIrrigation(irrigations.get(0).getContent().getId());
//        service.deleteIrrigation(irrigations.get(1).getContent().getId());
//    }
//
//    @Test
//    void deleteIrrigationTest(){
//        IrrigationEntity irrigationEntity1 = initOne();
//
//        IrrigationEntity irrigationEntity = service.newIrrigation(irrigationEntity1).getContent();
//        service.deleteIrrigation(irrigationEntity.getId());
//        Assertions.assertThrows(IrrigationNotFoundException.class, () -> {
//            service.oneIrrigation(irrigationEntity.getId());
//        });
//    }
//
//
//
//
//    IrrigationEntity initOne() {
//        IrrigationEntity irrigationEntity = new IrrigationEntity(Long.valueOf((int) (100000*Math.random())), Long.valueOf((int) (100000*Math.random())), 3);
//
//        return irrigationEntity;
//    }
//
//}
