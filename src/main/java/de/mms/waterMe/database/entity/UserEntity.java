package de.mms.waterMe.database.entity;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;


@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@ToString(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "users")
public class UserEntity {

  //  @ToString.Include
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

//    @ToString.Include
//    @Column(name = "email")
//    private String email;

//    @ToString.Include
//    @Column(name = "name")
//    private String name;
//
//    @ToString.Include
//    @Column(name = "password")
//    private String password;

//  @ToString.Include
    @Column(name = "image", nullable = true)
    private byte[] image;

//    @ToString.Include
//    @Column(name = "role")
//    private String role;


    @OneToMany(mappedBy= "userEntity")
    @JsonManagedReference ("users-irrigation")
    private Set<IrrigationEntity> irrigationEntities;

//
//    @OneToMany(mappedBy= "userEntity")
//    private Set<PlantSponsorEntity> plantSponsorEntities;



    public UserEntity (byte[] image) {
        this.image = image;

    }


}


