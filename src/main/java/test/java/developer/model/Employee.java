package test.java.developer.model;

import jakarta.persistence.*;
import org.hibernate.annotations.BatchSize;
import org.springframework.hateoas.RepresentationModel;

import java.sql.Date;

@Entity
@Table(name = "employees")
public class Employee extends RepresentationModel<Employee> {

    @Id
    @Column(name = "emp_no",length = 11)
    private Integer emp_no;
    private Date birth_date;
    @Column(name = "first_name",length = 14)
    private String first_name;
    @Column(name = "last_name",length = 16)
    private String last_name;
    @Enumerated(EnumType.STRING)
    private GENDER gender;
    private Date hire_date;

    public Employee(){

    }
    public Integer getEmp_no() {
        return emp_no;
    }

    public void setEmp_no(Integer emp_no) {
        this.emp_no = emp_no;
    }

    public Date getBirth_date() {
        return birth_date;
    }

    public void setBirth_date(Date birth_date) {
        this.birth_date = birth_date;
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

    public GENDER getGender() {
        return gender;
    }

    public void setGender(GENDER gender) {
        this.gender = gender;
    }

    public Date getHire_date() {
        return hire_date;
    }

    public void setHire_date(Date hire_date) {
        this.hire_date = hire_date;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "emp_no=" + emp_no +
                ", birth_date=" + birth_date +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", gender=" + gender +
                ", hire_date=" + hire_date +
                '}';
    }
}
