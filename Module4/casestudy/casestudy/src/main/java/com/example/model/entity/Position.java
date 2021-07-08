package com.example.model.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "position")
public class Position {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_position")
    private Integer idPosition;
    @Column(name = "name_position")
    private String namePosition;

    @OneToMany(mappedBy = "position")
    private List<Employee>employeeList;

    public Position() {
    }

    public Position(Integer idPosition, String namePosition) {
        this.idPosition = idPosition;
        this.namePosition = namePosition;
    }

    public Integer getIdPosition() {
        return idPosition;
    }

    public void setIdPosition(Integer idPosition) {
        this.idPosition = idPosition;
    }

    public String getNamePosition() {
        return namePosition;
    }

    public void setNamePosition(String namePosition) {
        this.namePosition = namePosition;
    }
}
