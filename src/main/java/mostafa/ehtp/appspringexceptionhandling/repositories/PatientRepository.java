package mostafa.ehtp.appspringexceptionhandling.repositories;

import mostafa.ehtp.appspringexceptionhandling.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface PatientRepository extends JpaRepository<Patient,Long> {
    Optional<Patient> findById(Long id);
}
