package com.webapp.getadoc.repository;

import com.webapp.getadoc.model.Appointment;
import com.webapp.getadoc.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

    List<Appointment> findAllByPatient(Patient patient);

    List<Appointment> findAllByPatient_Id(Long patientId);

    List<Appointment> findAllByDoctor_Id(long id);
}

