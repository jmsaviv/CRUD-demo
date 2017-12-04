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
public class AccountTest {
    
    public AccountTest() {
    }

    @Test
    public void testValidatePass() {
        Account account = new Account();
        account.setFirstName("John");
        account.setLastName("Doe");
        account.setEmailAddress("johndoe@gmail.com");
        Login login = new Login();
        login.setUsername("johndoe");
        login.setPassword("123456");
        account.setLogin(login);
        StudentProfile studentProfile = new StudentProfile();
        studentProfile.setFirstName("James");
        studentProfile.setLastName("Doe");
        studentProfile.setEmailAddress("jamesdoe@gmail.com");
        studentProfile.setGuardianName("Jane Doe");
        studentProfile.setGender("Male");
        studentProfile.setPhoneNumber("303-555-5555");
        studentProfile.setDob("1/1/16");
        studentProfile.setEnrollmentStatus("Waitlisted");
        boolean result = studentProfile.validate();
        assertTrue(result);
    }

    @Test
    public void testValidateFail() {
        Account Account = new Account();
        Account.setFirstName("John");
        Account.setLastName("Doe");
        Account.setEmailAddress("johndoe@gmail.com");
        Login login = new Login();
        login.setUsername("johndoe");
        login.setPassword("123456");
        Account.setLogin(login);
        StudentProfile studentProfile = new StudentProfile();
        studentProfile.setFirstName("James");
        studentProfile.setLastName("Doe");
        studentProfile.setEmailAddress("jamesdoe@gmail.com");
        studentProfile.setGuardianName("Jane Doe");
        studentProfile.setGender("Male");
        studentProfile.setPhoneNumber("303-555-5555");
        studentProfile.setDob("1/1/16");
        //studentProfile.setEnrollmentStatus("Waitlisted");
        boolean result = studentProfile.validate();
        assertFalse(result);
    }
    
}
