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
@Table(name = "issue")
public class IssueEntity {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "plant_id",insertable = false,updatable = false)
    private Long plant_id;
    @Column(name = "description")
    private String description;
    @Column(name = "picture")
    private byte[] picture;
    @Column(name = "date")
    private LocalDate date;

    @ManyToOne
    @JoinColumn(name="plant_id", nullable=false)
    @JsonBackReference
    private PlantEntity plantEntity;

    public IssueEntity(PlantEntity plantEntity, String description, byte[] picture, LocalDate date) {
        this.plantEntity = plantEntity;
        this.description = description;
        this.picture = picture;
        this.date = date;
    }

//    public Long getId() {
//        return this.id;
//    }
//
//    public Long getplant_id() {
//        return plant_id;
//    }
//
//    public String getDescription() {
//        return description;
//    }
//
//    public byte[] getPicture() {
//        return picture;
//    }
//
//    public LocalDate getDate() {
//        return date;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public void setplant_id(Long plant_id) {
//        this.plant_id = plant_id;
//    }
//
//    public void setDescription(String description) {
//        this.description = description;
//    }
//
//    @JsonSetter("picture")
//    public void setPicture(byte[] picture) {
//        this.picture = picture;
//    }
//
//    @JsonSetter("picture")
//    public void setPicture(String picture) {
//        this.picture = Base64.getDecoder().decode(picture.getBytes(StandardCharsets.UTF_8));
//    }
//
//    public void setDate(LocalDate date) {
//        this.date = date;
//    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        IssueEntity issueEntity = (IssueEntity) o;
//        return plant_id.equals(issueEntity.plant_id) && Objects.equals(description, issueEntity.description) && Arrays.equals(picture, issueEntity.picture) && date.equals(issueEntity.date);
//    }
//
//    @Override
//    public int hashCode() {
//        int result = Objects.hash(plant_id, description, date);
//        result = 31 * result + Arrays.hashCode(picture);
//        return result;
//    }
//
//    @Override
//    public String toString() {
//        return "Issue{" +
//                "id=" + id +
//                ", plant_id=" + plant_id +
//                ", description='" + description + '\'' +
//                ", picture=" + Arrays.toString(picture) +
//                ", date=" + date +
//                '}';
//    }
}
