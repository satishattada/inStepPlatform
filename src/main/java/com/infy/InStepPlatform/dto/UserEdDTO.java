package com.infy.InStepPlatform.dto;

import com.infy.InStepPlatform.entity.User;
import com.infy.InStepPlatform.enums.Degree;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.Date;

public class UserEdDTO {

    private int id;
    @NotNull(message = "degreeType is not null")
    private Degree degreeType;
    @NotNull(message = "degreeName is not null")
    private String degreeName;
    @NotNull(message = "gpa is not null")
    private Double gpa;
    @NotNull(message = "universityName is not null")
    private String universityName;
    @NotNull(message = "startDate is not null")
    private Date startDate;
    @NotNull(message = "endDate is not null")
    private Date endDate;

    public UserEdDTO() {
    }

    public UserEdDTO(int id, Degree degreeType, String degreeName, Double gpa, String universityName, Date startDate, Date endDate) {
        this.id = id;
        this.degreeType = degreeType;
        this.degreeName = degreeName;
        this.gpa = gpa;
        this.universityName = universityName;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Degree getDegreeType() {
        return degreeType;
    }

    public void setDegreeType(Degree degreeType) {
        this.degreeType = degreeType;
    }

    public String getDegreeName() {
        return degreeName;
    }

    public void setDegreeName(String degreeName) {
        this.degreeName = degreeName;
    }

    public Double getGpa() {
        return gpa;
    }

    public void setGpa(Double gpa) {
        this.gpa = gpa;
    }

    public String getUniversityName() {
        return universityName;
    }

    public void setUniversityName(String universityName) {
        this.universityName = universityName;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}
