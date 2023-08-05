package models;


import jakarta.persistence.*;

@Entity
@Table(name="Address")

public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // autoincrement
    @Column(name="id")
    private Long id;
    @Column(name="country")
    private String country;
    @Column(name="cp")
    private String cp;
    @Column(name="city")
    private String city;
    @Column(name="street")
    private String street;
    @Column(name="number")
    private String number;



}
