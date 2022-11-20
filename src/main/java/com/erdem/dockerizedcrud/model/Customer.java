package com.erdem.dockerizedcrud.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


import javax.persistence.*;


@Entity
@Table(name = "customers")
@ApiModel(value = "User Api model documentation", description = "Model")
public class Customer {
    @ApiModelProperty(value = "Unique id field of user object")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //primary
    private long id;

    @ApiModelProperty(value = "firstName field of user object")
    @Column(name = "first_name", nullable = false)
    private String firstName;
    @ApiModelProperty(value = "lastName field of user object")
    @Column(name = "last_name", nullable = false)
    private String lastName;

    @ApiModelProperty(value = "emailAddress field of user object")
    @Column(name = "customer_mail",nullable = false)
    private String custMail;

    @ApiModelProperty(value = "street name field of user object")
    @Column(name = "street_name",nullable = false)
    private String street;

    @Column(name = "phone_num",nullable = false)
    private String phoneNum;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCustMail() {
        return custMail;
    }

    public void setCustMail(String custMail) {
        this.custMail = custMail;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }
}
