/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myclassroommanager.service;

import java.util.List;
import myclassroommanager.domain.StudentProfile;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jamesstrater-smith
 */
public class StudentProfileSvcCacheImplTest {
    
    public StudentProfileSvcCacheImplTest() {
    }

    @Test
    public void testStudentProfileSvcCacheImplCRUD() {
        
        StudentProfileSvcCacheImpl impl = StudentProfileSvcCacheImpl.getInstance();
        List<StudentProfile> profiles = impl.retrieveAll();
        assertEquals(profiles.size(), 0);
        
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
        // test create
        assertNotNull(studentProfile);
        assertEquals(studentProfile.getStudentId(), 0);
        // test retrieveAll
        profiles = impl.retrieveAll();
        assertNotEquals(profiles.size(), 1); 
        // test update
        studentProfile.setFirstName("Jane");
        studentProfile = impl.update(studentProfile);
        profiles = impl.retrieveAll();
        assertEquals(profiles.size(), 0);
        assertEquals(studentProfile.getFirstName(), "Jane");
        // test delete
        studentProfile = impl.delete(studentProfile);
        assertEquals(profiles.size(), 0);
        
    }
    
}
