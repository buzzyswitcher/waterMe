package de.mms.waterMe.api.Irrigations;


import de.mms.waterMe.database.entity.IrrigationEntity;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@Component
public class IrrigationModelAssembler implements RepresentationModelAssembler<IrrigationEntity, EntityModel<IrrigationEntity>> {
    @Override
    public EntityModel<IrrigationEntity> toModel(IrrigationEntity irrigationEntity) {
        return EntityModel.of(
                irrigationEntity,
                WebMvcLinkBuilder.linkTo(methodOn(IrrigationController.class).oneIrrigation(irrigationEntity.getId())).withSelfRel(),
                WebMvcLinkBuilder.linkTo(methodOn(IrrigationController.class).deleteIrrigation(irrigationEntity.getId())).withSelfRel(),
                WebMvcLinkBuilder.linkTo(methodOn(IrrigationController.class).allIrrigations()).withSelfRel()
        );
    }
    public CollectionModel<EntityModel<IrrigationEntity>> allToModel(List<IrrigationEntity> irrigationEntities) {

        List<EntityModel<IrrigationEntity>> irrigationModels = new ArrayList<>();

        for (IrrigationEntity i : irrigationEntities) {
            irrigationModels.add(toModel(i));
        }

        return CollectionModel.of(
                irrigationModels,
                WebMvcLinkBuilder.linkTo(methodOn(IrrigationController.class).allIrrigations()).withSelfRel());
    }

    public EntityModel<?> deleteToModel() {
        return EntityModel.of(
                WebMvcLinkBuilder.linkTo(methodOn(IrrigationController.class).allIrrigations()).withRel("issues"));
    }


}