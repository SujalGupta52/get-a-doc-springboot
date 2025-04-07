package com.webapp.getadoc.model;

import jakarta.persistence.*;

import java.util.List;

@MappedSuperclass
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String firstName;
    @Column(nullable = false)
    private String lastName;
    @OneToMany
    private List<Appointment> appointments;

    public User() {
        this.firstName = null;
        this.lastName = null;
        this.id = 0L;
        this.appointments = null;
    }

    public User(String firstName, String lastName, List<Appointment> appointments) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.appointments = appointments;
    }


    public Long getId() {
        return id;
    }

    public User setId(Long id) {
        this.id = id;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public User setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public User setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public List<Appointment> getAppointments() {
        return appointments;
    }

    public User setAppointments(List<Appointment> appointments) {
        this.appointments = appointments;
        return this;
    }
}
