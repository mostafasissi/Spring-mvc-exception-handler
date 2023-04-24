package mostafa.ehtp.appspringexceptionhandling.services;

import jakarta.transaction.Transactional;
import mostafa.ehtp.appspringexceptionhandling.entities.Patient;
import mostafa.ehtp.appspringexceptionhandling.repositories.PatientRepository;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;
@Service
@Transactional
public class IPatientServiceImpl implements IPatientService {
    private PatientRepository patientRepository;

    public IPatientServiceImpl(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @Override
    public Patient savePatient(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public Optional<Patient> findPatientById(Long id) {

        return patientRepository.findById(id);
    }

    @Override
    public List<Patient> findAllPatient() {
        return patientRepository.findAll();
    }
}
