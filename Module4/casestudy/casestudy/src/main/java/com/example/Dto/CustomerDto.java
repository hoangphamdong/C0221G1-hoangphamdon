package com.example.Dto;

import com.example.model.entity.CustomerType;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class CustomerDto {

    private Integer id;

    @NotBlank(message = "*Please input code Customer..!")
    @Pattern(regexp = "^(KH-)\\d{4}$",message = "Code customer format exception (KH-XXXX)!!!")
    private String code;

    @NotBlank(message = "*Please input name Customer..!")
    private String name;

    @Column(name = "birthday",columnDefinition = "date")
    @Pattern(regexp = "^\\d{4}(\\/|-)\\d{2}(\\/|-)\\d{2}$",message = "Date Format Exception (dd/mm/YYYY)!!!")
    private String birthday;

    private String gender;

    @Pattern(regexp = "^\\d{9}|\\d{12}$",message = "Id card Format Exception (XXXXXXXXX) or (XXXXXXXXXXXX)!!!")
    private String idCard;

    @Pattern(regexp = "(090|091|\\(84\\)\\+90|\\(84\\)\\+91)\\d{7}",message = "Number Phone Format Exception (090|091)XXXXXXX !!!")
    private String phone;
    @Pattern(regexp = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$",message = "abc@gmail.com")
    private String email;

    private String address;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "customer_type_id", referencedColumnName = "id")
    private CustomerType customerType;

    public CustomerDto() {
    }

    public CustomerDto(Integer id, String code, String name, String birthday, String gender, String idCard, String phone, String email, String address, CustomerType customerType) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.birthday = birthday;
        this.gender = gender;
        this.idCard = idCard;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.customerType = customerType;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }
}
