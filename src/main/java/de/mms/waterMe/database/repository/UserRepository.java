package de.mms.waterMe.database.repository;



import de.mms.waterMe.database.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

}

