package de.mms.waterMe.api.Issues;

import de.mms.waterMe.database.entity.IssueEntity;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class IssueModelAssembler implements RepresentationModelAssembler<IssueEntity, EntityModel<IssueEntity>> {

    @Override
    public EntityModel<IssueEntity> toModel(IssueEntity issueEntity) {

        //TODO build in the possibility of editing

        return EntityModel.of(
                issueEntity,
                WebMvcLinkBuilder.linkTo(methodOn(IssueController.class).oneIssue(issueEntity.getId())).withSelfRel(),
                WebMvcLinkBuilder.linkTo(methodOn(IssueController.class).deleteIssue(issueEntity.getId())).withSelfRel(),
                WebMvcLinkBuilder.linkTo(methodOn(IssueController.class).allIssues()).withSelfRel()
        );
    }

    public CollectionModel<EntityModel<IssueEntity>> allToModel(List<IssueEntity> issueEntities) {

        List<EntityModel<IssueEntity>> issueModels = new ArrayList<>();

        for (IssueEntity i : issueEntities) {
            issueModels.add(toModel(i));
        }

        return CollectionModel.of(
                issueModels,
                WebMvcLinkBuilder.linkTo(methodOn(IssueController.class).allIssues()).withSelfRel());
    }

    public EntityModel<?> deleteToModel() {
        return EntityModel.of(
                WebMvcLinkBuilder.linkTo(methodOn(IssueController.class).allIssues()).withRel("issues"));
    }
}
