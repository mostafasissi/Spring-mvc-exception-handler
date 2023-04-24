package mostafa.ehtp.appspringexceptionhandling.services;

import jakarta.transaction.Transactional;
import mostafa.ehtp.appspringexceptionhandling.entities.Patient;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface IPatientService {
    public Patient savePatient(Patient patient);
    public Optional<Patient> findPatientById(Long id);
    public List<Patient> findAllPatient();

}
