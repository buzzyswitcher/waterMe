package de.mms.waterMe.api.Issues;

import de.mms.waterMe.database.entity.IssueEntity;
import de.mms.waterMe.database.repository.IssueRepository;
import de.mms.waterMe.services.Issues.IssueService;
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

@RestController
@RequestMapping("/api/issue")
public class IssueController {
    private final IssueService service;

    private final IssueModelAssembler assembler;

    public IssueController(IssueRepository repository, IssueModelAssembler assembler) {
        this.service = new IssueService(repository);
        this.assembler = assembler;
    }

    @PostMapping("/")
    public ResponseEntity<?> newIssue(@RequestBody IssueEntity issueEntity) {
        EntityModel<IssueEntity> entityModel = assembler.toModel(service.newIssue(issueEntity));
        entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri();

        return ResponseEntity.status(200).header("CREATED ISSUE","CREATED ISSUE").body(entityModel);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> editIssue(@PathVariable Long id, @RequestBody IssueEntity issueEntity) {
        EntityModel<IssueEntity> entityModel = assembler.toModel(service.editIssue(id, issueEntity));
        entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri();

        return ResponseEntity.status(200).header("UPDATED SUCCESSFULLY","UPDATED SUCCESSFULLY").body(entityModel);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> oneIssue(@PathVariable Long id) {
        EntityModel<IssueEntity> entityModel = assembler.toModel(service.oneIssue(id));
        entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri();

        return ResponseEntity.status(200).header("FETCHED SUCCESSFULLY","FETCHED SUCCESSFULLY").body(entityModel);
    }

    @GetMapping("/all")
    public ResponseEntity<?> allIssues() {
//        List<Issue> issues = service.allIssues();

        CollectionModel<EntityModel<IssueEntity>> responseBody = assembler.allToModel(service.allIssues());

        return ResponseEntity.status(200).header("FETCHED SUCCESSFULLY","FETCHED SUCCESSFULLY").body(responseBody);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteIssue(@PathVariable Long id) {
        service.deleteIssue(id);
        EntityModel<?> entityModel = assembler.deleteToModel();

        return ResponseEntity.status(200).header("DELETED SUCCESSFULLY","DELETED SUCCESSFULLY").body(entityModel);
    }
}
