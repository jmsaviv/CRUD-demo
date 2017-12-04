/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myclassroommanager.service;

import java.util.ArrayList;
import java.util.List;
import myclassroommanager.domain.StudentProfile;

/**
 * This class allows for implementation of all CRUD activities for student profiles
 *
 * @author jamesstrater-smith
 */
public class StudentProfileSvcCacheImpl implements IStudentProfileSvc{
    
    private List<StudentProfile> cache = new ArrayList<StudentProfile>();
    private int nextId = 0;
    
      private StudentProfileSvcCacheImpl(){
    }
    
    private static StudentProfileSvcCacheImpl instance = new StudentProfileSvcCacheImpl();
    
    public static StudentProfileSvcCacheImpl getInstance(){
        return instance;
    }
    
    /**
     * This method creates a student profile, sets a student ID for the profile,
     * and adds the created profile to a cache
     *
     * @param studentProfile
     * @return studentProfile
     */
    public StudentProfile create(StudentProfile studentProfile) {
        studentProfile.setStudentId(++nextId);
        cache.add(studentProfile);
        return studentProfile;
    }

    /**
     * This method copies cache of student profiles for viewing
     * 
     * @return cachecopy
     */
    @Override
    public List<StudentProfile> retrieveAll() {
        List<StudentProfile> cacheCopy = new ArrayList<StudentProfile>(cache.size());
        for (StudentProfile profile: this.cache) {
            cacheCopy.add(profile.copy());
        }
        return cacheCopy;
    }   

    /**
     * This method updates any changes made to copied student profile
     * 
     * @param studentProfile
     * @return studentProfile
     */
    @Override
    public StudentProfile update(StudentProfile studentProfile) {
        for (int i = 0; i < cache.size(); i ++) {
            StudentProfile next = cache.get(i);
            if (next.getStudentId() == studentProfile.getStudentId()) {
                cache.set(i, studentProfile);
                break;
            }
        }
        return studentProfile;
    }
    
    /**
     * This method deletes a student profile 
     *
     * @param studentProfile
     * @return studentProfile 
     */
    @Override
    public StudentProfile delete(StudentProfile studentProfile) {
        for (int i = 0; i < cache.size(); i ++) {
            StudentProfile next = cache.get(i);
            if (next.getStudentId() == studentProfile.getStudentId()) {
                cache.set(i, studentProfile);
                break;
            }
        }
        return studentProfile;
    }
}
