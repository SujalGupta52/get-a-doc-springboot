package com.webapp.getadoc.model;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

import java.util.List;
import java.util.Set;

@Entity
public class Patient extends User {
    public Patient() {
        super();
    }

    public Patient(String firstName, String lastName, List<Appointment> appointments) {
        super(firstName, lastName, appointments);
    }

}
