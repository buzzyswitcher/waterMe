package de.mms.waterMe.api.PlantSponsors;

import de.mms.waterMe.database.entity.PlantSponsorEntity;
import de.mms.waterMe.database.repository.PlantSponsorRepository;
import de.mms.waterMe.services.PlantSponsors.PlantSponsorService;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;


@RestController
@RequestMapping("/api/sponsors")

public class PlantSponsorController {
    private final PlantSponsorService service;

    private final PlantSponsorModelAssembler assembler;

    public PlantSponsorController (PlantSponsorRepository repository, PlantSponsorModelAssembler assembler) {
        this.service = new PlantSponsorService(repository);
        this.assembler = assembler;
    }

    @PostMapping("/")
    //POST /api/sponsors/
    public ResponseEntity<?> newPlantSponsor(@RequestBody PlantSponsorEntity plantSponsorEntity) {
        EntityModel<PlantSponsorEntity> entityModel =  assembler.toModel(service.newPlantSponsor(plantSponsorEntity));
        entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri();

        return ResponseEntity.status(200).header("CREATED PLANT", "CREATED PLANT").body(entityModel);
    }

    @PutMapping("/{id}")
    //PUT /api/sponsors/{id}
    public ResponseEntity<?> editPlantSponsor(@PathVariable Long id, @RequestBody PlantSponsorEntity plantSponsorEntity) {

        EntityModel<PlantSponsorEntity> entityModel = assembler.toModel(service.editPlantSponsor(id, plantSponsorEntity));
        entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri();

        return ResponseEntity.status(200).header("UPDATED PLANT", "UPDATED PLANT").body(entityModel);
    }

    @GetMapping("/{id}")
    //GET /api/sponsors/{id}
    public ResponseEntity<?> onePlantSponsor(@PathVariable Long id) {
        EntityModel<PlantSponsorEntity> entityModel = assembler.toModel(service.onePlantSponsor(id));
        entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri();

        return ResponseEntity.status(200).header("FETCHED SUCCESSFULLY","FETCHED SUCCESSFULLY").body(entityModel);
    }

    @GetMapping("/all")
    //GET /api/sponsors/all
    public ResponseEntity<?> allPlantSponsors() {
        CollectionModel<EntityModel<PlantSponsorEntity>> responseBody = assembler.allToModel(service.allPlantSponsors());

        return ResponseEntity.status(200).header("FETCHED SUCCESSFULLY","FETCHED SUCCESSFULLY").body(responseBody);
    }

    @DeleteMapping("/{id}")
    //DELETE /api/sponsors/{id}
    public ResponseEntity<?> deletePlantSponsor(@PathVariable Long id){
        service.deletePlantSponsor(id);
        EntityModel<?> entityModel = assembler.deleteToModel();

        return ResponseEntity.status(200).header("DELETED SUCCESSFULLY","DELETED SUCCESSFULLY").body(entityModel);
    }

}
