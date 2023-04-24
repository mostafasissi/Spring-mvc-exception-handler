package mostafa.ehtp.appspringexceptionhandling.controllers;

import mostafa.ehtp.appspringexceptionhandling.entities.Patient;
import mostafa.ehtp.appspringexceptionhandling.exceptions.NoDataFoundException;
import mostafa.ehtp.appspringexceptionhandling.exceptions.ResourceNotFoundException;
import mostafa.ehtp.appspringexceptionhandling.services.IPatientService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
public class PatientController {
    final IPatientService patientService;

    public PatientController(IPatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping(path = "/")
    public String home(Model model){

        List<Patient> patientList = patientService.findAllPatient();
        if(patientList.size()>0){
            model.addAttribute("patientList",patientList);
            return "acceuil";
        }
        // levé une exception dans le cas où aucun patient est trouvé
        throw new ResourceNotFoundException("Ooops cant not get all patient : No patient available");
    }
    @GetMapping("/patient")
    public String searchPatient(@RequestParam(name = "id") Long id, Model model){
        // Dans le cas où id n'est pas present ,  une exception MissingServletRequestParameterException sera levée automatiquement
            Optional<Patient> patient = patientService.findPatientById(id);
            if (patient.isPresent()) {
                model.addAttribute("patient", patient.get());
                return "patientPage";
            } else {// aucun patient ne possède cette id
                throw new NoDataFoundException("Patient not found for the id->" + id);
            }

    }


}
