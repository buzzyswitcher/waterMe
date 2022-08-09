package de.mms.waterMe.api.Irrigations;

import de.mms.waterMe.database.entity.IrrigationEntity;
import de.mms.waterMe.database.repository.IrrigationRepository;
import de.mms.waterMe.services.Irrigations.IrrigationService;
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
@RequestMapping("/api/irrigation")
public class IrrigationController {


    private final IrrigationService service;

    private final IrrigationModelAssembler assembler;
    public IrrigationController (IrrigationRepository repository, IrrigationModelAssembler assembler) {
        this.service = new IrrigationService(repository);
        this.assembler = assembler;
    }

    @PostMapping("/")
    //POST /api/irrigation/
    public ResponseEntity<?> newIrrigation(@RequestBody IrrigationEntity irrigationEntity) {
        EntityModel<IrrigationEntity> entityModel = assembler.toModel(service.newIrrigation(irrigationEntity));
        entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri();

        return ResponseEntity.status(200).header("CREATED IRRIGATION", "CREATED IRRIGATION").body(entityModel);
    }

    @PutMapping("/{id}")
    //PUT /api/irrigation/{id}
    public ResponseEntity<?> editIrrigation(@PathVariable Long id, @RequestBody IrrigationEntity irrigationEntity) {
        EntityModel<IrrigationEntity> entityModel = assembler.toModel(service.editIrrigation(id, irrigationEntity));
        entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri();

        return ResponseEntity.status(200).header("UPDATED IRRIGATION", "UPDATED IRRIGATION").body(entityModel);
    }

    @GetMapping("/{id}")
    //GET /api/irrigation/{id}
    public ResponseEntity<?> oneIrrigation(@PathVariable Long id) {
        EntityModel<IrrigationEntity>entityModel = assembler.toModel(service.oneIrrigation(id));
        entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri();

        return ResponseEntity.status(200).header("FETCHED IRRIGATION SUCCESSFULLY", "FETCHED IRRIGATION SUCCESSFULLY").body(entityModel);
    }

    @GetMapping("/all")
    //GET /api/irrigation/all
    public ResponseEntity<?> allIrrigations() {
        // List<EntityModel<IrrigationEntity>> irrigations = service.allIrrigations();
        CollectionModel<EntityModel<IrrigationEntity>> responseBody = assembler.allToModel(service.allIrrigations());

        return ResponseEntity.status(200).header("FETCHED SUCCESSFULLY", "FETCHED SUCCESSFULLY").body(responseBody);
    }

    @DeleteMapping("/{id}")
    //DELETE /api/irrigation/{id}
    public ResponseEntity<?> deleteIrrigation(@PathVariable Long id){
        service.deleteIrrigation(id);
        EntityModel<?> entityModel = assembler.deleteToModel();

        return ResponseEntity.status(200).header("DELETED SUCESSFULLY", "DELETED SUCESSFULLY").body(entityModel);
    }
}

