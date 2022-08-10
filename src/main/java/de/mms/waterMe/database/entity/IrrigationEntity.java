package de.mms.waterMe.database.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "irrigation")
//Заменяйте аннотации @Getter, @Setter, @AllArgsConstructor на @Data - она включает в себя все три перечисленные
@Data
@NoArgsConstructor
@ToString(onlyExplicitlyIncluded = true)
public class IrrigationEntity {

    //Для хибернейта лучше всего, с точки зрения производительности, использовать GenerationType.SEQUENCE
    //GenerationType.IDENTITY хуже, для справки: GenerationType.TABLE - лучше не использовать
    @Id
    @GeneratedValue (strategy = GenerationType.SEQUENCE, generator = "irrigation_generator")
    @SequenceGenerator(name="irrigation_generator", sequenceName = "irrigation_seq", allocationSize=1)
    private Long id;

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

    // Такие конструкторы можно убрать, они уже генерируются как только вы ппишите над классом @AllArgsConstructor или @Data
    public IrrigationEntity(int amount, LocalDate date, PlantEntity plantEntity, UserEntity userEntity) {
        this.amount = amount;
        this.date = date;
        this.plantEntity = plantEntity;
        this.userEntity = userEntity;
    }


}