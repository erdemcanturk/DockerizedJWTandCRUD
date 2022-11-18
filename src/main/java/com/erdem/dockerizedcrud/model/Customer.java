package com.erdem.dockerizedcrud.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.persistence.*;

@Data   //getter setter
@NoArgsConstructor
@AllArgsConstructor    //constructor oluşturduk
@Entity //Jpa
@Table(name = "customers")

public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //primary
    private long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "customer_mail")
    private String custMail;

    @Column(name = "street_name")
    private String street;

    @Column(name = "phone_num")
    private String phoneNum;

}
