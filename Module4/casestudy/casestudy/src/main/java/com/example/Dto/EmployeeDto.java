package com.example.Dto;

import com.example.model.entity.*;

import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.List;

public class EmployeeDto {
    private Integer id;
    @NotBlank(message = "*please input name employee!!!!!")
    private String name;
    @Pattern(regexp = "^\\d{4}(\\/|-)\\d{2}(\\/|-)\\d{2}$")
    private String birthday;
    @Pattern(regexp = "^\\d{9}|\\d{12}$",message = "Id card Format Exception (XXXXXXXXX) or (XXXXXXXXXXXX)!!!")
    private String idCard;
    private Double salary;
    @Pattern(regexp = "(090|091|\\(84\\)\\+90|\\(84\\)\\+91)\\d{7}",message = "Number Phone Format Exception (090|091)XXXXXXX !!!")
    private String phone;
    @Pattern(regexp = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$",message = "abc@gmail.com")
    private String email;
    private String address;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "position_id",referencedColumnName = "id_position")
    private Position position;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "education_degree_id",referencedColumnName = "education_degree_id")
    private EducationDegree educationDegree;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "division_id",referencedColumnName = "division_id")
    private Division division;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "username",referencedColumnName = "username")
    private AppUser user;

    @OneToMany(mappedBy = "employee")
    private List<Contract> contracts;

    public EmployeeDto() {
    }

    public EmployeeDto(Integer id, String name, String birthday, String idCard, Double salary, String phone, String email, String address, Position position, EducationDegree educationDegree, Division division, AppUser user, List<Contract> contracts) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
        this.idCard = idCard;
        this.salary = salary;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.position = position;
        this.educationDegree = educationDegree;
        this.division = division;
        this.user = user;
        this.contracts = contracts;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
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

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public EducationDegree getEducationDegree() {
        return educationDegree;
    }

    public void setEducationDegree(EducationDegree educationDegree) {
        this.educationDegree = educationDegree;
    }

    public Division getDivision() {
        return division;
    }

    public void setDivision(Division division) {
        this.division = division;
    }

    public AppUser getUser() {
        return user;
    }

    public void setUser(AppUser user) {
        this.user = user;
    }

    public List<Contract> getContracts() {
        return contracts;
    }

    public void setContracts(List<Contract> contracts) {
        this.contracts = contracts;
    }
}
