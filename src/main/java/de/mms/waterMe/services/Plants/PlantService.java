package de.mms.waterMe.services.Plants;
import de.mms.waterMe.database.entity.PlantEntity;
import de.mms.waterMe.database.repository.PlantRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

@Service
@ResponseBody
@ResponseStatus
public class PlantService {

    private final PlantRepository repository;


    public PlantService(PlantRepository repository) {
        this.repository = repository;

    }

    public PlantEntity newPlant(PlantEntity plantEntity) {
        return repository.save(plantEntity);
    }

    public PlantEntity editPlant(Long id, PlantEntity plantEntity) {
        PlantEntity updatedPlantEntity = repository.findById(id)
                .map( targetPlant -> {
                    plantEntity.setId(targetPlant.getId());
                    return repository.save(plantEntity);
                })
                .orElseThrow(() -> new PlantNotFoundException(id));

        return updatedPlantEntity;
    }

    public PlantEntity onePlant(Long id) {
        PlantEntity plantEntity = repository.findById(id)
                .orElseThrow(() -> new PlantNotFoundException(id));

        return plantEntity;
    }

    public List<PlantEntity> allPlants(){
        List<PlantEntity> plantEntities = repository.findAll();

        return plantEntities;
    }

    public PlantEntity deletePlant(Long id) {
        PlantEntity deletedPlantEntity = repository.findById(id).map(
                target ->  {
                    repository.delete(target);
                    return target;
                }
        ).orElseThrow(() -> new PlantNotFoundException(id));

        return deletedPlantEntity;
    }

}


