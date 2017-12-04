/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myclassroommanager.domain;

import java.lang.*;

/**
 *
 * @author jamesstrater-smith
 * 
 * StudentProfile class provides domain functionality for student profiles
 */

public class StudentProfile {
    
    private String firstName = "";
    private String lastName = "";
    private String emailAddress = "";
    private String guardianName = "";
    private String gender = "";
    private String phoneNumber = "";
    private String dob = "";
    private String enrollmentStatus = "";
    private int studentId;
    
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
    
    public String getGuardianName() {
        return guardianName;
    }
    
    public void setGuardianName(String guardianName) {
        this.guardianName = guardianName;
    }
    
    public String getGender() {
        return gender;
    }
    
    public void setGender(String gender) {
        this.gender = gender;
    }
    
    public String getPhoneNumber() {
        return phoneNumber;
    }
    
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    
    public String getDob() {
        return dob;
    }
    
    public void setDob(String dob) {
        this.dob = dob;
    }
    
    public String getEnrollmentStatus() {
        return enrollmentStatus;
    }
    
    public void setEnrollmentStatus(String enrollmentStatus) {
        this.enrollmentStatus = enrollmentStatus;
    }
    
    public int getStudentId() {
        return studentId;
    }
    
    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    @Override
    public String toString() {
        return "StudentProfile{" + "firstName=" + firstName + ", lastName=" 
                + lastName + ", emailAddress=" + emailAddress + ", guardianName=" 
                + guardianName + ", gender=" + gender + ", phoneNumber=" 
                + phoneNumber + ", dob=" + dob + ", enrollmentStatus=" 
                + enrollmentStatus + ", studentId=" + studentId + '}';
    }
    
    

    /**
     * This method copies student profile objects
     *
     * @return copied student profile 
     */
    public StudentProfile copy() {
        StudentProfile cloned = new StudentProfile();
        cloned.setFirstName(this.firstName);
        cloned.setLastName(this.lastName);
        cloned.setEmailAddress(this.emailAddress);
        cloned.setGuardianName(this.guardianName);
        cloned.setGender(this.gender);
        cloned.setPhoneNumber(this.phoneNumber);
        cloned.setDob(this.dob);
        cloned.setEnrollmentStatus(this.enrollmentStatus);
        return cloned;        
    }
    

    /**
     * This method validates student profile, returns true if profile is valid
     *
     * @return true or false
     */
    public boolean validate() {
        
        CharSequence charSeq = "@";
        
        if (firstName == null || firstName.equals("")) return false;
        System.out.println("1");
        if (lastName == null || lastName.equals("")) return false;
        System.out.println("2");
        if (emailAddress == null || emailAddress.equals("") || !emailAddress.contains(charSeq)) return false;
        System.out.println("3");
        if (guardianName == null || guardianName.equals("")) return false;
        System.out.println("4");
        if (gender == null || gender.equals("")) return false;
        System.out.println("5");
        if (phoneNumber == null || phoneNumber.equals("")) return false;
        System.out.println("6");
        if (dob == null || dob.equals("")) return false;
        System.out.println("7");
        if (enrollmentStatus == null || enrollmentStatus.equals("")) return false;
        System.out.println("8");
        return true;
    }
}
