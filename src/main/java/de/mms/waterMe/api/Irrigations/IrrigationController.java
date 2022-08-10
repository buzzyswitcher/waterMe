package de.mms.waterMe.api.Irrigations;

import de.mms.waterMe.database.entity.IrrigationEntity;
import de.mms.waterMe.services.Irrigations.IrrigationService;
import org.apache.catalina.mapper.Mapper;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/api/irrigation")
public class IrrigationController {
    private final IrrigationService service;
    private final IrrigationModelAssembler assembler;
    private Mapper mapper;

    public IrrigationController (IrrigationService service, IrrigationModelAssembler assembler) {
        this.service = service;
        this.assembler = assembler;
    }

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    //POST /api/irrigation/
    public IrrigationDto newIrrigation(@RequestBody IrrigationDto  irrigationDto) {
        IrrigationEntity irrigation = service.newIrrigation(irrigationDto);
        EntityModel<IrrigationEntity> entityModel = assembler.toModel(irrigation);
        entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri();

        return irrigationDto;
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

