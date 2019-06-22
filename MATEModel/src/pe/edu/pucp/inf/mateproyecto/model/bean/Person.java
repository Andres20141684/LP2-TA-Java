package pe.edu.pucp.inf.mateproyecto.model.bean;

import java.io.Serializable;
import java.util.*;

/**
 * 
 */
public class Person implements Serializable {

    /**
     * Default constructor
     */
    public Person() {
    }

    private int PersonID;

    private String name;

    private String lastName;

    private String secondLastName;

    private String dni;

    private String email;

    private String phone;

    private Date birthdate;
    
    private int state;

    public Person(String name, String lastName, String secondLastName, String dni, String email, String phone, Date birthdate) {
        this.name = name;
        this.lastName = lastName;
        this.secondLastName = secondLastName;
        this.dni = dni;
        this.email = email;
        this.phone = phone;
        this.birthdate = birthdate;
    }

    public int getPersonID() {
        return PersonID;
    }

    public void setPersonID(int id) {
        this.PersonID = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSecondLastName() {
        return secondLastName;
    }

    public void setSecondLastName(String secondLastName) {
        this.secondLastName = secondLastName;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

   
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }
    
    public void setState(int state){
        this.state = state;
    }
    
    public int getState(){
        return this.state;
    }

}