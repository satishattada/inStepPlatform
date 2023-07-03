package com.infy.InStepPlatform.dto;

import com.infy.InStepPlatform.entity.UserEdQual;
import com.infy.InStepPlatform.enums.Role;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public class UserDTO {
    private int id;
    @NotNull(message = "email id cannot be null")
    private String email;
    @NotNull(message = "password cannot be null")
    private String password;
    @NotNull(message = "firstName cannot be null")
    private String firstName;
    @NotNull(message = "lastName cannot be null")
    private String lastName;
    @NotNull(message = "role cannot be null")
    private Role role;
    @NotNull(message = "phoneNumber cannot be null")
    private String phoneNumber;
    private String address;
    @NotNull(message = "skills cannot be null")
    private String skills;

    @NotNull(message = "UserEdQual cannot be null")
    private List<UserEdDTO> userEdQuals;
    private String lastUpdatedAt;
    private String createdAt;
    private String createdBy;
    private String updatedBy;

    public UserDTO(){

    }
    public UserDTO(int id, String email, String password, String firstName, String lastName, Role role, String phoneNumber, String address, String skills, List<UserEdDTO> userEdQuals, String lastUpdatedAt, String createdAt, String createdBy, String updatedBy) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.role = role;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.skills = skills;
        this.userEdQuals = userEdQuals;
        this.lastUpdatedAt = lastUpdatedAt;
        this.createdAt = createdAt;
        this.createdBy = createdBy;
        this.updatedBy = updatedBy;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    public String getLastUpdatedAt() {
        return lastUpdatedAt;
    }

    public void setLastUpdatedAt(String lastUpdatedAt) {
        this.lastUpdatedAt = lastUpdatedAt;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public List<UserEdDTO> getUserEdQuals() {
        return userEdQuals;
    }

    public void setUserEdQuals(List<UserEdDTO   > userEdQuals) {
        this.userEdQuals = userEdQuals;
    }
}
