package mostafa.ehtp.appspringexceptionhandling;

import mostafa.ehtp.appspringexceptionhandling.entities.Patient;
import mostafa.ehtp.appspringexceptionhandling.services.IPatientService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.stream.Stream;

@SpringBootApplication
public class AppSpringExceptionHandlingApplication {

    public static void main(String[] args) {
        SpringApplication.run(AppSpringExceptionHandlingApplication.class, args);
    }

    @Bean
    CommandLineRunner start(
            IPatientService patientService
    ) {
        return args -> {
            Stream.of("ahmed", "Ali", "Najat").forEach(
                    name -> {
                        Patient patient = new Patient();
                        patient.setNom(name);
                        patient.setMalade(true);
                        patient.setDateNaissance(new Date());
                        patientService.savePatient(patient);
                    }
            );
        };
    }
}
