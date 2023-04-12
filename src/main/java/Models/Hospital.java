package Models;

public class Hospital {
    int id_hospital;
    String name_hospital;
    String specialisation;

    @Override
    public String toString() {
        return "Hospital: " +
                "Id_hospital: " + id_hospital + '\'' +
                "Name_hospital: " + name_hospital + '\'' +
                "Specialisation: " + specialisation + '\'' +
                ' ';
    }

    public Hospital(int id_hospital, String name_hospital, String specialisation) {
        this.id_hospital = id_hospital;
        this.name_hospital = name_hospital;
        this.specialisation = specialisation;
    }

    public Hospital(String name_hospital, String specialisation) {
        this.name_hospital = name_hospital;
        this.specialisation = specialisation;
    }

    public int getId_hospital() {
        return id_hospital;
    }

    public void setId_hospital(int id_hospital) {
        this.id_hospital = id_hospital;
    }

    public String getName_hospital() {
        return name_hospital;
    }

    public void setName_hospital(String name_hospital) {
        this.name_hospital = name_hospital;
    }

    public String getSpecialisation() {
        return specialisation;
    }

    public void setSpecialisation(String specialisation) {
        this.specialisation = specialisation;
    }
}
