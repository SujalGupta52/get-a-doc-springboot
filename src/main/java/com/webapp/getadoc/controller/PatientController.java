package com.webapp.getadoc.controller;

import com.webapp.getadoc.model.Appointment;
import com.webapp.getadoc.model.Patient;
import com.webapp.getadoc.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/patient")
public class PatientController {
    @Autowired
    private PatientRepository repository;

    @GetMapping(value = "{id}")
    public Optional<Patient> getPatientByID(@PathVariable("id") long id) {
        return repository.findById(id);
    }

    //root mapping
    @GetMapping(value = "/")
    public List<Patient> getAllPatient() {
        return repository.findAll();
    }

    @PostMapping(value = "create")
    public Patient createPatient(@RequestBody Patient patient) {
        return repository.save(patient);
    }

    @PutMapping(value = "edit")
    public Patient editPatient(@RequestBody Patient patient) {
        return repository.save(patient);
    }

    @DeleteMapping(value = "delete/{id}")
    public String deletePatient(@PathVariable("id") long id) {
        if (!repository.existsById(id))
            return "Patient by given id not found";
        repository.deleteById(id);
        return "Deleted successfully";
    }

    @GetMapping(value = "{id}/appointments")
    public List<Appointment> getAppointments(@PathVariable("id") long id) {
        Optional<Patient> patient = repository.findById(id);
        return patient.get().getAppointments();
    }
}
