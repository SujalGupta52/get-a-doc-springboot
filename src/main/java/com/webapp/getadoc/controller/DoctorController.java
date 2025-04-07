package com.webapp.getadoc.controller;

import com.webapp.getadoc.model.Appointment;
import com.webapp.getadoc.model.Doctor;
import com.webapp.getadoc.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/doctor")
public class DoctorController {
    @Autowired
    private DoctorRepository repository;

    @GetMapping(value = "{id}")
    public Optional<Doctor> getDoctorByID(@PathVariable("id") long id) {
        return repository.findById(id);
    }

    //root mapping
    @GetMapping(value = "/")
    public List<Doctor> getAllDoctor() {
        return repository.findAll();
    }

    @PostMapping(value = "create")
    public Doctor createDoctor(@RequestBody Doctor doctor) {
        return repository.save(doctor);
    }

    @PutMapping(value = "edit")
    public Doctor editDoctor(@RequestBody Doctor doctor) {
        return repository.save(doctor);
    }

    @DeleteMapping(value = "delete/{id}")
    public String deleteDoctor(@PathVariable("id") long id) {
        if (!repository.existsById(id))
            return "Doctor by given id not found";
        repository.deleteById(id);
        return "Deleted successfully";
    }

    @GetMapping(value = "{id}/appointments")
    public List<Appointment> getAppointments(@PathVariable("id") long id) {
        Optional<Doctor> doctor = repository.findById(id);
        return doctor.get().getAppointments();
    }
}
