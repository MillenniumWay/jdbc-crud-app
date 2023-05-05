package Models;

import java.sql.Date;

public class Client {
    int client_id;
      String first_name;
      String last_name;
      String passport_num;
      String code_of_diagnose;
      String date_entry;
      int fk_doctor_id;

      public Client(String first_name, String last_name, String passport_num, String code_of_diagnose,String date_entry, int fk_doctor_id) {
            this.first_name = first_name;
            this.last_name = last_name;
            this.passport_num = passport_num;
            this.code_of_diagnose = code_of_diagnose;
            this.date_entry = date_entry;
            this.fk_doctor_id = fk_doctor_id;
      }


      public Client(int client_id, String first_name, String last_name, String passport_num, String code_of_diagnose, String date_entry, int fk_doctor_id) {
            this.client_id = client_id;
            this.first_name = first_name;
            this.last_name = last_name;
            this.passport_num = passport_num;
            this.code_of_diagnose = code_of_diagnose;
            this.date_entry = date_entry;
            this.fk_doctor_id = fk_doctor_id;
      }




      public Client() {
      }

      @Override
      public String toString() {
            return "Client{" +
                    "client_id=" + client_id +
                    ", first_name='" + first_name + '\'' +
                    ", last_name='" + last_name + '\'' +
                    ", passport_num='" + passport_num + '\'' +
                    ", code_of_diagnose='" + code_of_diagnose + '\'' +
                    ", date_entry='" + date_entry + '\'' +
                    ", fk_doctor_id=" + fk_doctor_id +
                    '}';
      }

      public int getClient_id() {
            return client_id;
      }

      public String getFirst_name() {
            return first_name;
      }

      public String getLast_name() {
            return last_name;
      }

      public String getPassport_num() {
            return passport_num;
      }

      public String getCode_of_diagnose() {
            return code_of_diagnose;
      }


      public String getDate_entry() {
            return date_entry;
      }

      public void setDate_entry(String date_entry) {
            this.date_entry = date_entry;
      }

      public int getFk_doctor_id() {
            return fk_doctor_id;
      }




}
