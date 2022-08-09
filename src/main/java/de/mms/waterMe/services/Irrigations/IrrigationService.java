package de.mms.waterMe.services.Irrigations;

import de.mms.waterMe.api.Irrigations.IrrigationModelAssembler;
import de.mms.waterMe.database.entity.IrrigationEntity;
import de.mms.waterMe.database.repository.IrrigationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class IrrigationService {

    private final IrrigationRepository repository;

    public IrrigationService(IrrigationRepository repository) {
        this.repository = repository;
    }

    public IrrigationEntity newIrrigation(IrrigationEntity irrigationEntity) {
        return repository.save(irrigationEntity);
    }


    public IrrigationEntity editIrrigation(Long id, IrrigationEntity irrigationEntity) {
        IrrigationEntity updatedIrrigationEntity = repository.findById(id)
                .map( targetIrrigation -> {
                    irrigationEntity.setId(targetIrrigation.getId());
                    return repository.save(irrigationEntity);
                })
                .orElseThrow(() -> new IrrigationNotFoundException(id));

        return updatedIrrigationEntity;
    }

    public IrrigationEntity oneIrrigation(Long id) {
        IrrigationEntity irrigationEntity = repository.findById(id)
                .orElseThrow(() -> new IrrigationNotFoundException(id));

        System.out.println(irrigationEntity.toString());

        return irrigationEntity;
    }

    public List<IrrigationEntity> allIrrigations(){
        List<IrrigationEntity> irrigationEntities = repository.findAll();

        return irrigationEntities;
    }

    public IrrigationEntity deleteIrrigation(Long id) {
        IrrigationEntity deletedIrrigationEntity = repository.findById(id).map(
                target ->  {
                    repository.delete(target);
                    return target;
                }
        ).orElseThrow(() -> new IrrigationNotFoundException(id));

        return deletedIrrigationEntity;
    }

}

