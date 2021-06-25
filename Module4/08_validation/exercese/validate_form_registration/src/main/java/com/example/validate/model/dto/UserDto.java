package com.example.validate.model.dto;

import javax.persistence.Column;
import javax.validation.constraints.*;

public class UserDto {
    private Long id;

    @NotBlank(message = "please input fist name (null)")
    @Size(min = 5,max = 45)
    private String firstName;
    @Size(min = 5,max = 45)
    @NotBlank(message = "please input last name(null)")
    private String lastName;
    @NotBlank(message = "please input phone number(null)")
    @Pattern(regexp = "(09|03|07|08|05)+([0-9]{8})",message = "Invalid format phone")
    private String phoneNumber;
    @Min(value = 18,message = "please age<18")
    private int age;
    @NotBlank(message = "please input email(null")
    @Pattern(regexp = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$")
    private String email;

    public UserDto() {
    }

    public UserDto(Long id, String firstName, String lastName, String phoneNumber, int age, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.age = age;
        this.email = email;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
