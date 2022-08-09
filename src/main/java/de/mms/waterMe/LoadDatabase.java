//package de.mms.waterMe;
//
//import de.mms.waterMe.database.entity.IrrigationEntity;
//import de.mms.waterMe.database.entity.PlantEntity;
//import de.mms.waterMe.database.entity.UserEntity;
//import de.mms.waterMe.database.repository.IrrigationRepository;
//import de.mms.waterMe.database.repository.PlantRepository;
//import de.mms.waterMe.database.entity.PlantSponsorEntity;
//import de.mms.waterMe.database.repository.PlantSponsorRepository;
//import de.mms.waterMe.database.repository.UserRepository;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.boot.CommandLineRunner;
//
//import java.time.LocalDate;
//import java.util.Collections;
//
//
//public class LoadDatabase {
//
//    private final static Logger LOG = LoggerFactory.getLogger(LoadDatabase.class);
//
//
//    public CommandLineRunner initPlants(PlantRepository plantRepository) {
//        return args -> {
//            PlantEntity plantEntity = new PlantEntity("starIcon", LocalDate.of(2021, 12, 31), "room 4a", 3, "Rosa", "www.rosa.de");
//            plantRepository.save(plantEntity);
//            plantRepository.save(new PlantEntity("starIcon", LocalDate.of(2019, 12, 31), "room 4a", 1, "Rosa", "www.rosa.de"));
//            plantRepository.save(new PlantEntity("flowerIcon", LocalDate.of(2020, 12, 31), "room 4b", 2, "Cactus", "www.cactus.de"));
//            plantRepository.save(new PlantEntity("umbrellaIcon", LocalDate.of(2021, 12, 31), "room 4c", 2, "Palm", "www.palm.de"));
//            plantRepository.save(new PlantEntity("seeIcon", LocalDate.of(2022, 2, 31), "room 4d", 5, "Camomile", "www.camomile.de"));
//
//            plantRepository.findAll().forEach(order -> LOG.info("Preloaded " + order));
//        };
//    }
//
//
//    public CommandLineRunner initUsers(UserRepository userRepository) {
//        return args -> {
//            UserEntity userEntity = new UserEntity(1L,null,Collections.emptySet(),Collections.emptySet());
//            userRepository.save(userEntity);
//            userRepository.save(new UserEntity(2L,"lola1".getBytes(), Collections.emptySet(),Collections.emptySet()));
//            userRepository.save(new UserEntity(3L,"lola2".getBytes(), Collections.emptySet(),Collections.emptySet()));
//            userRepository.save(new UserEntity(4L,"lola3".getBytes(), Collections.emptySet(),Collections.emptySet()));
//            userRepository.save(new UserEntity(5L,"lola4".getBytes(), Collections.emptySet(),Collections.emptySet()));
//
//            userRepository.findAll().forEach(order -> LOG.info("Preloaded "+ order));
//        };
//    }
//
//    public CommandLineRunner initPlantSponsors(PlantSponsorRepository plantSponsorRepository) {
//
//
//        return args -> {
//            PlantSponsorEntity plantSponsorEntity = new PlantSponsorEntity(null, null);
//            plantSponsorRepository.save(plantSponsorEntity);
//            plantSponsorRepository.save(new PlantSponsorEntity(null, null));
//
//            plantSponsorRepository.findAll().forEach(order -> LOG.info("Preloaded "+ order));
//        };
//    }
//
//    public CommandLineRunner initIrrigations(IrrigationRepository irrigationRepository) {
//
//
//        return args -> {
//            IrrigationEntity irrigationEntity = new IrrigationEntity(2, LocalDate.of(2021, 12, 31), null, null);
//            irrigationRepository.save(irrigationEntity);
//            irrigationRepository.save(new IrrigationEntity(2, LocalDate.of(2020, 12, 31), null, null));
//            irrigationRepository.save(new IrrigationEntity(2, LocalDate.of(2021, 12, 31), null, null));
//            irrigationRepository.save(new IrrigationEntity(2, LocalDate.of(2022, 12, 31), null, null));
//            irrigationRepository.save(new IrrigationEntity(2, LocalDate.of(2019, 12, 31), null, null));
//
//            irrigationRepository.findAll().forEach(order -> LOG.info("Preloaded "+ order));
//        };
//    }
//}
