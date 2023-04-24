package mostafa.ehtp.appspringexceptionhandling.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;
import java.util.Date;

@Entity
@AllArgsConstructor @NoArgsConstructor @Data
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    private String nom ;
    @Temporal(TemporalType.DATE)
    private Date dateNaissance ;
    private boolean malade ;
}
