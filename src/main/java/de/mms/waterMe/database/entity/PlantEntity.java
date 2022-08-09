package de.mms.waterMe.database.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@AllArgsConstructor
@ToString(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "plant")
public class PlantEntity {
@Id
@GeneratedValue (strategy = GenerationType.IDENTITY)
@Column(name = "id")
private  Long id;
    @Column(name = "icon")
    private String icon;
    @Column(name = "soil_changed")
    private LocalDate soilChanged;
    @Column(name = "room")
    private String room;
    @Column(name = "floor")
    private int floor;
    @Column(name = "name")
    private String name;
    @Column (name = "wiki_link")
    private String wikiLink;

    @OneToMany(mappedBy= "plantEntity")
    @JsonManagedReference
    private Set<IrrigationEntity> irrigationEntities;

    @OneToMany(mappedBy= "plantEntity")
    @JsonManagedReference
    private Set<IssueEntity> issueEntities;

    @OneToMany(mappedBy="plantEntity")
    @JsonManagedReference
    private Set<PlantSponsorEntity> plantSponsorEntities;


    public PlantEntity(String icon, LocalDate soilChanged, String room, int floor, String name, String wikiLink) {
        this.icon = icon;
        this.soilChanged = soilChanged;
        this.room = room;
        this.floor=floor;
        this.name = name;
        this.wikiLink = wikiLink;
    }

//    public Long getId() {
//        return id;
//    }
//
//    public String getIcon() {
//        return icon;
//    }
//
//// getters
//    public LocalDate getSoilChanged() {
//        return soilChanged;
//    }
//
//    public String getRoom() {
//        return room;
//    }
//
//    public int getFloor() {
//        return floor;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public String getWikiLink() {
//        return wikiLink;
//    }
//
//    // setters
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public void setIcon(String icon) {
//        this.icon = icon;
//    }
////check
//    public void setSoilChanged(LocalDate soilChanged) {
//        this.soilChanged = soilChanged;
//    }
//
//    public void setRoom(String room) {
//        this.room = room;
//    }
//
//    public void setFloor(int floor) {
//        this.floor = floor;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public void setWikiLink(String wikiLink) {
//        this.wikiLink = wikiLink;
//    }
//
//
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        PlantEntity that = (PlantEntity) o;
//
//        return icon.equals(that.icon) && soilChanged.equals(that.soilChanged) && room.equals(that.room)
//                && floor==that.floor && name.equals(that.name) && wikiLink.equals(that.wikiLink);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(id, icon, soilChanged, room, floor, name, wikiLink);
//    }
//
//    @Override
//    public String toString() {
//        return "Plant{" +
//                "id=" + id +
//                ", icon=" + icon +
//                ", soilChanged =" + soilChanged  +
//                ", room=" + room +
//                ", floor=" + floor +
//                ", name=" + name +
//                ", wikiLink=" + wikiLink +
//                '}';
//    }

}
