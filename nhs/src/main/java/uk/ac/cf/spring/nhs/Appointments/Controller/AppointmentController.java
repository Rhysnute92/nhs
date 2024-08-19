package uk.ac.cf.spring.nhs.Appointments.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import uk.ac.cf.spring.nhs.AddPatient.Entity.Patient;
import uk.ac.cf.spring.nhs.AddPatient.Repository.PatientRepository;
import uk.ac.cf.spring.nhs.AddPatient.Service.PatientService;
import uk.ac.cf.spring.nhs.Appointments.DTO.AppointmentDTO;
import uk.ac.cf.spring.nhs.Appointments.Model.Appointment;
import uk.ac.cf.spring.nhs.Appointments.Service.AppointmentService;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@RestController
@RequestMapping("/appointments")
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    @Autowired
    private PatientRepository patientRepository;

    @GetMapping
    public List<Appointment> getAllAppointments() {
        return appointmentService.getAppointmentsByUserId(1);
    }

    @GetMapping("/{id}")
    public Appointment getAppointmentById(@PathVariable Integer id) {
        return appointmentService.getAppointmentById(id);
    }

    @PostMapping
    public ResponseEntity<Appointment> createAppointment(@RequestBody AppointmentDTO appointmentDTO) {
        Appointment savedAppointment = appointmentService.saveAppointment(appointmentDTO);
        return new ResponseEntity<>(savedAppointment, HttpStatus.CREATED);
    }

    @PostMapping("/patients/{id}/add-lymphoedema-appointment")
    public String addLymphoedemaAppointment(@PathVariable("id") Long patientId,
                                            @RequestParam("date") String date,
                                            @RequestParam("time") String time,
                                            @RequestParam("location") String location) {
        Patient patient = patientRepository.findById(patientId).orElse(null);
        if (patient != null) {
            LocalDate localDate = LocalDate.parse(date);
            LocalTime localTime = LocalTime.parse(time);

            LocalDateTime apptDateTime = LocalDateTime.of(localDate, localTime);

            Appointment appointment = new Appointment();
            appointment.setPatient(patient);
            appointment.setApptDateTime(apptDateTime);
            appointment.setApptType("Lymphoedema appointment");
            appointment.setApptLocation(location);
            appointment.setIsDeletable(false);
            appointmentService.saveAppointment(appointment);
        }
        return "redirect:/patients/" + patientId + "/appointments";
    }

    @DeleteMapping("/{id}")
    public void deleteAppointment(@PathVariable Integer id) {
        appointmentService.deleteAppointment(id);
    }
}
