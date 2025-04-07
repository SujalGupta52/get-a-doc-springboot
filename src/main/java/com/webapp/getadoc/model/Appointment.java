package com.webapp.getadoc.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date time;
    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    private Doctor doctor;
    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    private Patient patient;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public Appointment() {
        this.id = 0L;
        this.time = null;
        this.doctor = null;
        this.patient = null;
    }

    public Appointment(Date time, Doctor doctor, Patient patient) {
        this.time = time;
        this.doctor = doctor;
        this.patient = patient;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }
}
