package de.mms.waterMe.database.repository;

import de.mms.waterMe.database.entity.IrrigationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IrrigationRepository extends JpaRepository<IrrigationEntity, Long> {

}