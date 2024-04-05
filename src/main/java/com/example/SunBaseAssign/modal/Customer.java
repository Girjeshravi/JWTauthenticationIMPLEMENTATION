package com.example.SunBaseAssign.modal;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;


@Table(name = "StudentInformation")
@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level= AccessLevel.PRIVATE)
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    String firstName;

    String lastName;

    String street;

    String address;

    String city;

    String state;

    @Column(unique = true,nullable = false)
    String customerEmail;

    @Column(unique = true,nullable = false)
    String mobileNo;

}
