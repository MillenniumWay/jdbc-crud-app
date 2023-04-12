package Models;

public class Doctor {

   int doctor_id;
   int hospital_id;
   String first_name;
   String last_name;
   String speciality;

    public Doctor(int hospital_id, String first_name, String last_name, String speciality) {
        this.hospital_id = hospital_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.speciality = speciality;
    }

    public Doctor(int doctor_id, int hospital_id, String first_name, String last_name, String speciality) {
        this.doctor_id = doctor_id;
        this.hospital_id = hospital_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.speciality = speciality;
    }

    public Doctor(String first_name, String last_name, String speciality) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.speciality = speciality;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "doctor_id=" + doctor_id +
                ", hospital_id=" + hospital_id +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", speciality='" + speciality + '\'' +
                '}';
    }

    public int getDoctor_id() {
        return doctor_id;
    }

    public void setDoctor_id(int doctor_id) {
        this.doctor_id = doctor_id;
    }

    public int getHospital_id() {
        return hospital_id;
    }

    public void setHospital_id(int hospital_id) {
        this.hospital_id = hospital_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }
}
