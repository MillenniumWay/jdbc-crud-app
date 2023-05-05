package Hibernate.Entity;

import lombok.*;

import javax.persistence.*;
import java.util.Collection;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@Builder
@Getter
@Setter
@EqualsAndHashCode
public class Hospital {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_hospital", nullable = false)
    private long idHospital;
    @Basic
    @Column(name = "name_hospital", nullable = false, length = 46)
    private String nameHospital;
    @Basic
    @Column(name = "specialisation", nullable = false, length = 46)
    private String specialisation;
    @OneToMany(mappedBy = "hospitalByHospitalId")
    private Collection<Doctor> doctorsByIdHospital;

    public Hospital(String nameHospital, String specialisation) {
        this.nameHospital = nameHospital;
        this.specialisation = specialisation;
    }
}

