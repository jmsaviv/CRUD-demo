/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myclassroommanager.domain;

import java.util.*;

/**
 *
 * @author jamesstrater-smith
 * 
 * Account Class provides domain layer functionality for user accounts
 */
public class Account {
    
    private String firstName = "";
    private String lastName = "";
    private String emailAddress = "";
    private Login login = null;
    private List<StudentProfile> studentProfiles = new LinkedList<StudentProfile>();
    private int id;
    private int nextId;
    
    public String getFirstName() {
        return firstName;
    }
    
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    
    public String getLastName() {
        return lastName;
    }
    
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    public String getEmailAddress() {
        return emailAddress;
    }
    
    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }
    
    public Login getLogin() {
        return login;
    }
    
    public void setLogin(Login login) {
        this.login = login;
    }
    
    public List<StudentProfile> getStudentProfiles() {
        return studentProfiles;
    }

    @Override
    public String toString() {
        return "Account{" + "firstName=" + firstName + ", lastName=" 
                + lastName + ", emailAddress=" + emailAddress + ", login=" 
                + login + ", studentProfiles=" + studentProfiles + ", id=" 
                + id + ", nextId=" + nextId + '}';
    }
    
    
    
    /**
     * takes student profile object and adds it to list of student profiles
     * 
     * @param student profile
     * @return student profile
     */
    public StudentProfile add(StudentProfile studentProfile) {
        studentProfile.setStudentId(++nextId);
        studentProfiles.add(studentProfile);
        return studentProfile;
    }
    
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }

    /**
     *This method copies an Account object
     * 
     * @return copied Account
     */
    public Account copy() {
        Account cloned = new Account();
        cloned.setFirstName(this.firstName);
        cloned.setLastName(this.lastName);
        cloned.setEmailAddress(this.emailAddress);
        cloned.setLogin(this.login);
        for (StudentProfile profile: this.studentProfiles) {
            cloned.add(profile.copy());
        }
        return cloned;        
    }

    /**
     *validates account object, returns true if account is valid
     * 
     * @return true if account is valid, false if account is invalid
     */
    public boolean validate() {
        
        CharSequence charSeq = "@";
        
        if (firstName == null || firstName.equals("")) return false;
        if (lastName == null || lastName.equals("")) return false;
        if (emailAddress == null || emailAddress.equals("") || !emailAddress.contains(charSeq)) return false;
        if (login == null) return false;
        //if (studentProfile == null) return false;
        return true;
    }
}
