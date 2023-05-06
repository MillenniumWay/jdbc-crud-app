package Hibernate.Entity;

import lombok.*;

import javax.persistence.*;
import java.sql.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@Builder
@Getter
@Setter
@EqualsAndHashCode
public class Client {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "client_id", nullable = false)
    private long clientId;
    @Basic
    @Column(name = "first_name", nullable = false, length = 32)
    private String firstName;
    @Basic
    @Column(name = "last_name", nullable = false, length = 32)
    private String lastName;
    @Basic
    @Column(name = "passport_num", nullable = true, length = 32)
    private String passportNum;
    @Basic
    @Column(name = "code_of_diagnose", nullable = false, length = 16)
    private String codeOfDiagnose;
    @Basic
    @Column(name = "date_entry", nullable = false)
    private Date dateEntry;
    @Basic
    @Column(name = "fk_doctor_id", nullable = false)
    private int fkDoctorId;
    @ManyToOne
    @JoinColumn(name = "fk_doctor_id", referencedColumnName = "doctor_id", nullable = false, insertable = false, updatable = false)
    private Doctor doctorByFkDoctorId;

    public Client(String firstName, String lastName, String passportNum, String codeOfDiagnose, Date dateEntry, int fkDoctorId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.passportNum = passportNum;
        this.codeOfDiagnose = codeOfDiagnose;
        this.dateEntry = dateEntry;
        this.fkDoctorId = fkDoctorId;
    }

    @Override
    public String toString() {
        return "Client{" +
                "clientId=" + clientId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", passportNum='" + passportNum + '\'' +
                ", codeOfDiagnose='" + codeOfDiagnose + '\'' +
                ", dateEntry=" + dateEntry +
                ", fkDoctorId=" + fkDoctorId +
                '}';
    }
}
