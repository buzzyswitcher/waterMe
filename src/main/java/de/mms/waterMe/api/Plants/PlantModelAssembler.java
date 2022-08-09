package de.mms.waterMe.api.Plants;

import de.mms.waterMe.api.Irrigations.IrrigationController;
import de.mms.waterMe.database.entity.IrrigationEntity;
import de.mms.waterMe.database.entity.PlantEntity;
import de.mms.waterMe.services.Plants.PlantService;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
@Component
public class PlantModelAssembler implements RepresentationModelAssembler<PlantEntity, EntityModel<PlantEntity>> {
    @Override
    public EntityModel<PlantEntity> toModel(PlantEntity plantEntity) {
        return EntityModel.of(
                plantEntity,
                WebMvcLinkBuilder.linkTo(methodOn(PlantController.class).onePlant(plantEntity.getId())).withSelfRel(),
                WebMvcLinkBuilder.linkTo(methodOn(PlantController.class).deletePlant(plantEntity.getId())).withSelfRel(),
                WebMvcLinkBuilder.linkTo(methodOn(PlantController.class).allPlants()).withSelfRel()
        );
    }
    public CollectionModel<EntityModel<PlantEntity>> allToModel(List<PlantEntity> plantEntities) {

        List<EntityModel<PlantEntity>> plantModels = new ArrayList<>();

        for (PlantEntity i : plantEntities) {
            plantModels.add(toModel(i));
        }

        return CollectionModel.of(
                plantModels,
                WebMvcLinkBuilder.linkTo(methodOn(PlantController.class).allPlants()).withSelfRel());
    }

    public EntityModel<?> deleteToModel() {
        return EntityModel.of(
                WebMvcLinkBuilder.linkTo(methodOn(PlantController.class).allPlants()).withRel("issues"));
    }


}











