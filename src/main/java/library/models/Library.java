package library.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name= "library")
public class Library {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // autoincrement
    @Column(name="id")
    private Long id;
    @Column(name="name")
    private String name;
    @Column(name="website")
    private String website;
    @Column(name="email")
    private String email;
    @Column(name="phone")
    private String phone;
    @Column(name="address")
    private String address;



    }







