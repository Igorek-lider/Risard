package com.htp.rentcar.doman.to;

import java.util.Date;

public class User {

    private Long idUser;
    private String username;
    private String password;
    private String passport;
    private String driversLicense;
    private Integer experience;
    private Date passwordCreatDate;
    private String lastPasswords;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public String getDriversLicense() {
        return driversLicense;
    }

    public void setDriversLicense(String driversLicense) {
        this.driversLicense = driversLicense;
    }

    public Integer getExperience() {
        return experience;
    }

    public void setExperience(Integer experience) {
        this.experience = experience;
    }

    public Date getPasswordCreatDate() {
        return passwordCreatDate;
    }

    public void setPasswordCreatDate(Date passwordCreatDate) {
        this.passwordCreatDate = passwordCreatDate;
    }

    public String getLastPasswords() {
        return lastPasswords;
    }

    public void setLastPasswords(String lastPasswords) {
        this.lastPasswords = lastPasswords;
    }

    public Integer getIdRole() {
        return idRole;
    }

    public void setIdRole(Integer idRole) {
        this.idRole = idRole;
    }

    public Long getIdUser() {

        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    private Integer idRole;

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("User{");
        sb.append("idUser=").append(idUser);
        sb.append(", username='").append(username).append('\'');
        sb.append(", password='").append(password).append('\'');
        sb.append(", passport='").append(passport).append('\'');
        sb.append(", driversLicense='").append(driversLicense).append('\'');
        sb.append(", experience=").append(experience);
        sb.append(", passwordCreatDate=").append(passwordCreatDate);
        sb.append(", lastPasswords='").append(lastPasswords).append('\'');
        sb.append(", idRole=").append(idRole);
        sb.append('}');
        return sb.toString();
    }
}
