package de.mms.waterMe.services.Issues;

import de.mms.waterMe.database.entity.IssueEntity;
import de.mms.waterMe.database.repository.IssueRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IssueService {
    private final IssueRepository repository;

    public IssueService(IssueRepository repository) {
        this.repository = repository;
    }

    public IssueEntity newIssue(IssueEntity issueEntity) {
        return repository.save(issueEntity);
    }

    public IssueEntity editIssue(Long id, IssueEntity issueEntity) {
        IssueEntity updatedIssueEntity = repository.findById(id)
                .map( targetIssue -> {
                    issueEntity.setId(targetIssue.getId());
                    return repository.save(issueEntity);
                })
                .orElseThrow(() -> new IssueNotFoundException(id));

        return updatedIssueEntity;
    }

    public IssueEntity oneIssue(Long id) {
        IssueEntity issueEntity = repository.findById(id)
                .orElseThrow(() -> new IssueNotFoundException(id));

        return issueEntity;
    }

    public List<IssueEntity> allIssues() {
        List<IssueEntity> issueEntities = repository.findAll();

        return issueEntities;
    }

    public IssueEntity deleteIssue(Long id) {
        IssueEntity deletedIssueEntity = repository.findById(id)
                .map(issue -> {
                    repository.delete(issue);
                    return issue;
                })
                .orElseThrow(() -> new IssueNotFoundException(id));

        return deletedIssueEntity;
    }
}
