package de.mms.waterMe.api.Plants;

import de.mms.waterMe.api.Irrigations.IrrigationModelAssembler;
import de.mms.waterMe.database.entity.IrrigationEntity;
import de.mms.waterMe.database.entity.PlantEntity;
import de.mms.waterMe.database.repository.PlantRepository;
import de.mms.waterMe.services.Plants.PlantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;


@RestController
@RequestMapping("/api/plants")
//with @RequestMappin the controller handles all http requests
public class PlantController {

    private final PlantService service;

    private final PlantModelAssembler assembler;

    public PlantController (PlantRepository repository, PlantModelAssembler assembler) {
        this.service = new PlantService(repository);
        this.assembler = assembler;
    }

    @PostMapping("/")
    //POST /api/plant/
    public ResponseEntity<?> newPlant(@RequestBody PlantEntity plantEntity) {
        EntityModel<PlantEntity> entityModel = assembler.toModel(service.newPlant(plantEntity));
        entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri();

        return ResponseEntity.status(200).header("CREATED PLANT", "CREATED PLANT").body(entityModel);
    }

    @PutMapping("/{id}")
    //PUT /api/plant/{id}
    public ResponseEntity<?> editPlant(@PathVariable Long id, @RequestBody PlantEntity plantEntity) {
        plantEntity.setId(id);
        EntityModel<PlantEntity> entityModel = assembler.toModel(service.editPlant(id, plantEntity));
        entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri();

        return ResponseEntity.status(200).header("UPDATED PLANT", "UPDATED PLANT").body(entityModel);
    }

    @GetMapping("/{id}")
    //GET /api/plant/{id}
    public ResponseEntity<?> onePlant(@PathVariable Long id) {
        EntityModel<PlantEntity>entityModel = assembler.toModel(service.onePlant(id));
        entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri();

        return ResponseEntity.status(200).header("FETCHED PLANT SUCCESSFULLY", "FETCHED PLANT SUCCESSFULLY").body(entityModel);
    }

    @GetMapping("/all")
    //GET /api/plant/all
    public ResponseEntity<?> allPlants() {
        //List<EntityModel<PlantEntity>> plants = service.allPlants();
        CollectionModel<EntityModel<PlantEntity>> responseBody = assembler.allToModel(service.allPlants());

        return ResponseEntity.status(200).header("FETCHED SUCCESSFULLY", "FETCHED SUCCESSFULLY").body(responseBody);
    }

    @DeleteMapping("/{id}")
    //DELETE /api/plant/{id}
    public ResponseEntity<?> deletePlant(@PathVariable Long id){
        service.deletePlant(id);
        EntityModel<?> entityModel = assembler.deleteToModel();

        return ResponseEntity.status(200).header("DELETED SUCESSFULLY", "DELETED SUCESSFULLY").body(entityModel);
    }
}




