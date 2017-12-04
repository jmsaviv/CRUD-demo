/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myclassroommanager.service;

import myclassroommanager.domain.*;
import java.util.*;

/**
 * This interface connects all CRUD activities for student profiles
 *
 * @author jamesstrater-smith
 */
public interface IStudentProfileSvc {
    
    public StudentProfile create(StudentProfile studentProfile); 
    public List<StudentProfile> retrieveAll();
    public StudentProfile update(StudentProfile studentProfile);
    public StudentProfile delete(StudentProfile studentProfile);
    
}
