package org.vdoloka.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "USERS")
public class UserEntity {
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name= "increment", strategy= "increment")
    @Column(name = "id", length = 6, nullable = false)
    private Long id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;

    @Column(name = "ammount_money")
    private Integer ammountMoney;

    public UserEntity(Long id, String firstName, String lastName, Integer ammountMoney) {
        this.id = id;
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

