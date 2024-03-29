package com.example.model.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String birthday;
    private String idCard;
    private Double salary;
    private String phone;
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

//    @ManyToOne(cascade = CascadeType.PERSIST)
//    @JoinColumn(name = "username",referencedColumnName = "User_Name")
//    private AppUser appUser;

    @OneToMany(mappedBy = "employee")
    private List<Contract>contracts;
    public Employee() {
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

    public List<Contract> getContracts() {
        return contracts;
    }

    public void setContracts(List<Contract> contracts) {
        this.contracts = contracts;
    }
}
