package com.webapp.getadoc.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Doctor extends User {
    @Column(nullable = false)
    private String qualification;

    public Doctor() {
        super();
        this.qualification = null;
    }

    public Doctor(String firstName, String lastName, String qualification, List<Appointment>appointments) {
        super(firstName, lastName, appointments);
        this.qualification = qualification;
    }

    public String getQualification() {
        return qualification;
    }

    public Doctor setQualification(String qualification) {
        this.qualification = qualification;
        return this;
    }
}
