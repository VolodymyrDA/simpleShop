package org.vdoloka.entity;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "USERS")
public class UserEntity {
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name= "increment", strategy= "increment")
    @Column(name = "id", length = 6, nullable = false)
    private Long id;
    @NotEmpty(message = "First name may not be empty")
    @Column(name = "first_name")
    private String firstName;
    @NotEmpty(message = "Last name may not be empty")
    @Column(name = "last_name")
    private String lastName;

    @Digits(message = "Not a number", integer = 0, fraction = 0)
    @Column(name = "ammount_money")
    private Integer ammountMoney;

    public UserEntity(String firstName, String lastName, Integer ammountMoney) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.ammountMoney = ammountMoney;
    }

    public UserEntity() {

    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public Integer getAmmountMoney() {
        return ammountMoney;
    }

    public void setAmmountMoney(Integer ammountMoney) {
        this.ammountMoney = ammountMoney;
    }
}

