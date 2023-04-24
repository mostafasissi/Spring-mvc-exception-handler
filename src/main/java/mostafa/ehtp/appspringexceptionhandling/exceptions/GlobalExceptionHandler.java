package mostafa.ehtp.appspringexceptionhandling.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {

    // la methode pour intercepter tous les exceptions de l'application
    @ExceptionHandler(value = {ResourceNotFoundException.class , MissingServletRequestParameterException.class, NoDataFoundException.class})
    public String handleException(Exception exception , Model model){
        if(exception instanceof NoDataFoundException) {
            return handleNoDataFoundException((NoDataFoundException) exception,model);
        }
        else if (exception instanceof MissingServletRequestParameterException) {
           return handleMissingServletRequestParameterException((MissingServletRequestParameterException) exception,model);
        }
        else {
           return handleResourceNotFoundException((ResourceNotFoundException) exception,model);
        }
    }

    // ==> methode de gestion de chaque exception
    public String handleResourceNotFoundException(ResourceNotFoundException resourceNotFoundException, Model model){
        // créer un objet qui contient les détails de l'erreur
        DetailException detailException = new DetailException(
                resourceNotFoundException.getMessage(),
                resourceNotFoundException,
                HttpStatus.NO_CONTENT,
                ZonedDateTime.now(ZoneId.of("Z"))// crée une instance de ZonedDateTime pour la date et l'heure actuelles
        );
        model.addAttribute("detailException" , detailException);
        return "ExceptionPage";
    }
    public String handleMissingServletRequestParameterException(MissingServletRequestParameterException ex , Model model){
        // créer un objet qui contient les détails de l'erreur
        DetailException detailException = new DetailException(
                ex.getMessage(),
                ex,
                HttpStatus.BAD_REQUEST,
                ZonedDateTime.now(ZoneId.of("Z"))// crée une instance de ZonedDateTime pour la date et l'heure actuelles
        );
        model.addAttribute("detailException" , detailException);
        return "ExceptionPage";
    }
    public String handleNoDataFoundException(NoDataFoundException noDataFoundException , Model model ){
        DetailException detailException = new DetailException(
                noDataFoundException.getMessage(),
                noDataFoundException,
                HttpStatus.NOT_FOUND,
                ZonedDateTime.now(ZoneId.of("Z"))

        );
        model.addAttribute("detailException" , detailException);
        return "ExceptionPage";
    }

}
