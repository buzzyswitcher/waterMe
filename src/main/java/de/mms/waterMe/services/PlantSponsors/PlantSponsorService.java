package de.mms.waterMe.services.PlantSponsors;

import de.mms.waterMe.database.entity.PlantSponsorEntity;
import de.mms.waterMe.database.repository.PlantSponsorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
//@ResponseBody
//@ResponseStatus

public class PlantSponsorService {
    private final PlantSponsorRepository repository;

    public PlantSponsorService(PlantSponsorRepository repository) {
        this.repository = repository;
    }

    public PlantSponsorEntity newPlantSponsor(PlantSponsorEntity plantSponsorEntity) {
        return repository.save(plantSponsorEntity);
    }

    public PlantSponsorEntity editPlantSponsor(Long id, PlantSponsorEntity plantSponsorEntity) {
        PlantSponsorEntity updatedPlantSponsorEntity = repository.findById(id)
                .map( targetPlantSponsor -> {
                    plantSponsorEntity.setId(targetPlantSponsor.getId());
                    return repository.save(plantSponsorEntity);
                })
                .orElseThrow(() -> new PlantSponsorNotFoundException(id));

        return updatedPlantSponsorEntity;
    }

    public PlantSponsorEntity onePlantSponsor(Long id) {
        PlantSponsorEntity plantSponsorEntity = repository.findById(id)
                .orElseThrow(() -> new PlantSponsorNotFoundException(id));

        return plantSponsorEntity;
    }

    public List<PlantSponsorEntity> allPlantSponsors(){
        List<PlantSponsorEntity> plantSponsorEntities = repository.findAll();


        return plantSponsorEntities;
    }

    public PlantSponsorEntity deletePlantSponsor(Long id) {
        PlantSponsorEntity deletedPlantSponsorEntity = repository.findById(id)
                .map(plantSponsor -> {
                    repository.delete(plantSponsor);
                    return plantSponsor;
                })
                .orElseThrow(() -> new PlantSponsorNotFoundException(id));

        return deletedPlantSponsorEntity;
    }


}
