package de.mms.waterMe.database.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@ToString(onlyExplicitlyIncluded = true)

@Entity
@Table(name = "irrigation")
public class IrrigationEntity {
    @Id
    //@ToString.Include
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    //@ToString.Include
    @Column(name = "amount")
    private int amount;

    @Column(name = "date")
    private LocalDate date;

    @ManyToOne
    @JoinColumn(name="plant_id", nullable=false)
    @JsonBackReference ("plant-irrigation")
    private PlantEntity plantEntity;


    @ManyToOne
    @JoinColumn(name="user_id", nullable=false)
    @JsonBackReference ("users-irrigation")
    private UserEntity userEntity;

    public IrrigationEntity(int amount, LocalDate date, PlantEntity plantEntity, UserEntity userEntity) {
        this.amount = amount;
        this.date = date;
        this.plantEntity = plantEntity;
        this.userEntity = userEntity;
    }


}