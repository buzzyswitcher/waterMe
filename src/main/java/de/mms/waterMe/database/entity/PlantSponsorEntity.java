package de.mms.waterMe.database.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@ToString(onlyExplicitlyIncluded = true)

@Entity
@Table(name = "plant_sponsor")

public class PlantSponsorEntity {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
//    @Column(name = "plant_id",insertable = false,updatable = false)
//    private Long plant_id;
//    @Column(name = "user_id",insertable = false,updatable = false)
//    private Long user_id;

    @ManyToOne
    @JoinColumn(name="plant_id", nullable=false)
   @JsonBackReference ("plant-plant_sponsor")
    private PlantEntity plantEntity;

    @ManyToOne
    @JoinColumn(name="user_id", nullable=false)
    @JsonBackReference ("users-plant_sponsor")
    private UserEntity userEntity;

    public PlantSponsorEntity(PlantEntity plantEntity, UserEntity userEntity ) {
        this.plantEntity = plantEntity;
        this.userEntity = userEntity;
    }
//
//    //getters
//    public Long getId() {
//        return id;
//    }
//    public Long getPlant_id() {
//        return plant_id;
//    }
//
//    public Long getUser_id() {
//        return user_id;
//    }
//
//    //setters
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public void setPlant_id(Long plant_id) {
//        this.plant_id = plant_id;
//    }
//
//    public void setUser_id(Long user_id) {
//        this.user_id = user_id;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        PlantSponsorEntity that = (PlantSponsorEntity) o;
//        return plant_id.equals(that.plant_id) && user_id.equals(that.user_id);
//    }
//    @Override
//    public int hashCode() {
//        return Objects.hash( plant_id, user_id);
//    }
//
//    @Override
//    public String toString() {
//        return "PlantSponsor{" +
//                "id=" + id +
//                ", plant_id=" + plant_id +
//                ", user_id=" + user_id +
//                '}';
//    }
//

}

