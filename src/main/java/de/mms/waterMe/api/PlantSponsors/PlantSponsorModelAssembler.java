package de.mms.waterMe.api.PlantSponsors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;


import de.mms.waterMe.database.entity.PlantSponsorEntity;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PlantSponsorModelAssembler implements RepresentationModelAssembler<PlantSponsorEntity, EntityModel<PlantSponsorEntity>> {
    @Override
    public EntityModel<PlantSponsorEntity> toModel(PlantSponsorEntity plantSponsorEntity) {

        return EntityModel.of(
                plantSponsorEntity,
                linkTo(methodOn(PlantSponsorController.class).onePlantSponsor(plantSponsorEntity.getId())).withSelfRel(),
                linkTo(methodOn(PlantSponsorController.class).deletePlantSponsor(plantSponsorEntity.getId())).withSelfRel(),
                linkTo(methodOn(PlantSponsorController.class).allPlantSponsors()).withSelfRel()
        );
    }

    public CollectionModel<EntityModel<PlantSponsorEntity>> allToModel(List<PlantSponsorEntity> plantSponsorEntities) {

        List<EntityModel<PlantSponsorEntity>> plantSponsorModels = new ArrayList<>();

        for (PlantSponsorEntity i : plantSponsorEntities) {
            plantSponsorModels.add(toModel(i));
        }

        return CollectionModel.of(
                plantSponsorModels,
                linkTo(methodOn(PlantSponsorController.class).allPlantSponsors()).withSelfRel());
    }

    public EntityModel<?> deleteToModel() {
        return EntityModel.of(
                linkTo(methodOn(PlantSponsorController.class).allPlantSponsors()).withRel("issues"));
    }
}

