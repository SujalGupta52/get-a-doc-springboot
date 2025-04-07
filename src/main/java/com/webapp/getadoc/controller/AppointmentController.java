package com.webapp.getadoc.controller;

import com.webapp.getadoc.model.Appointment;
import com.webapp.getadoc.model.Doctor;
import com.webapp.getadoc.model.Patient;
import com.webapp.getadoc.repository.AppointmentRepository;
import com.webapp.getadoc.repository.DoctorRepository;
import com.webapp.getadoc.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

class AppointmentEntity {
    public long doctorId;
    public long patientId;
    public Date time;
}

@RestController
@RequestMapping("/api/appointment")
public class AppointmentController {
    @Autowired
    private AppointmentRepository repository;
    @Autowired
    private DoctorRepository doctorRepository;
    @Autowired
    private PatientRepository patientRepository;

    @GetMapping(value = "{id}")
    public Optional<Appointment> getAppointmentByID(@PathVariable("id") long id) {
        return repository.findById(id);
    }

    //root mapping
    @GetMapping(value = "/")
    public List<Appointment> getAllAppointment() {
        return repository.findAll();
    }

    @PostMapping(value = "create")
    public String createAppointment(@RequestBody AppointmentEntity appointment) {
        Optional<Doctor> doctor = doctorRepository.findById(appointment.doctorId);
        Optional<Patient> patient = patientRepository.findById(appointment.patientId);
        Appointment newAppointment = new Appointment(appointment.time, doctor.get(), patient.get());
        doctor.get().getAppointments().add(newAppointment);
        patient.get().getAppointments().add(newAppointment);
        Appointment output = repository.save(newAppointment);
        doctorRepository.save(doctor.get());
        patientRepository.save(patient.get());
        return "Appointment with id " + output.getId() + "created successsfully";
    }

    @DeleteMapping(value = "delete/{id}")
    public String deleteAppointment(@PathVariable("id") long id) {
        if (!repository.existsById(id))
            return "Appointment by given id not found";
        repository.deleteById(id);
        return "Deleted successfully";
    }

    @GetMapping(value = "/patient/{id}")
    public List<Appointment> getAppointmentsByPatient(@PathVariable("id") long id) {
        return repository.findAllByPatient_Id(id);
    }
    @GetMapping(value = "/doctor/{id}")
    public List<Appointment> getAppointmentsByDoctor(@PathVariable("id")long id) {
        return repository.findAllByDoctor_Id(id);
    }
}
