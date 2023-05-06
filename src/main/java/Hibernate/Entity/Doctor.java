package Hibernate.Entity;

import lombok.*;
import org.hibernate.annotations.BatchSize;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@Builder
@Getter
@Setter
@EqualsAndHashCode
@BatchSize(size = 10)
public class Doctor {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "doctor_id", nullable = false)
    private long doctor_id;



    @Basic
    @Column(name = "hospital_id", nullable = false)
    private long hospitalId;
    @Basic
    @Column(name = "first_name", nullable = false, length = 32)
    private String firstName;
    @Basic
    @Column(name = "last_name", nullable = false, length = 32)
    private String lastName;
    @Basic
    @Column(name = "speciality", nullable = false, length = 32)
    private String speciality;
    @ManyToOne
    @JoinColumn(name = "hospital_id", referencedColumnName = "id_hospital", nullable = false, insertable = false, updatable = false)
    private Hospital hospitalByHospitalId;
    public Doctor(long hospitalId, String firstName, String lastName, String speciality) {
        this.hospitalId = hospitalId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.speciality = speciality;
    }

    public Doctor(long doctor_id, long hospitalId, String firstName, String lastName, String speciality) {
        this.doctor_id = doctor_id;
        this.hospitalId = hospitalId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.speciality = speciality;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "doctor_id=" + doctor_id +
                ", hospitalId=" + hospitalId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", speciality='" + speciality + '\'' +
                '}';
    }
}
