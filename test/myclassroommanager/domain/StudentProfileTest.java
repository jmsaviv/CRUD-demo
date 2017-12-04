/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myclassroommanager.domain;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jamesstrater-smith
 */
public class StudentProfileTest {
    
    public StudentProfileTest() {
    }

        @Test
    public void testValidatePass() {
        StudentProfile studentProfile = new StudentProfile();
        studentProfile.setFirstName("John");
        studentProfile.setLastName("Doe");
        studentProfile.setEmailAddress("johndoe@gmail.com");
        studentProfile.setGuardianName("Jane Doe");
        studentProfile.setGender("Male");
        studentProfile.setGender("Male");
        studentProfile.setPhoneNumber("303-555-5555");
        studentProfile.setDob("1/1/16");
        studentProfile.setEnrollmentStatus("Waitlisted");
        boolean result = studentProfile.validate();
        assertTrue(result);
    }
    
    @Test
    public void testValidateFail() {
        StudentProfile studentProfile = new StudentProfile();
        studentProfile.setFirstName("John");
        studentProfile.setLastName("Doe");
        studentProfile.setEmailAddress("johndoegmail.com"); //email address contains no "@" symbol
        studentProfile.setGuardianName("Jane Doe");
        studentProfile.setGender("Male");
        studentProfile.setGender("Male");
        studentProfile.setPhoneNumber("303-555-5555");
        studentProfile.setDob("1/1/16");
        studentProfile.setEnrollmentStatus("Waitlisted");
        boolean result = studentProfile.validate();
        assertFalse(result);
    }
    
}
