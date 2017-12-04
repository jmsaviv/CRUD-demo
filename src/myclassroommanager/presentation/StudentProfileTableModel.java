/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myclassroommanager.presentation;

import myclassroommanager.domain.*;
import java.util.*;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author jamesstrater-smith
 * 
 * StudentProfileTableModel class extends AbstractTableModel and allows for 
 * created student profiles associated with a user account to be displayed in a 
 * table 
 */
public class StudentProfileTableModel extends AbstractTableModel {
    
    private String [] columnNames = {"First name", "Last name", "Guardian's name",
        "Email", "Phone Number", "Gender", "DOB", "Enrollment status"};

    private List<StudentProfile> studentProfiles = new LinkedList<StudentProfile>();

    public void setStudentProfiles(List<StudentProfile> studentProfiles) {
        this.studentProfiles = studentProfiles;
    }
    
    @Override
    public int getRowCount() {
        return studentProfiles.size();
    }
    
    @Override
    public int getColumnCount() {
        return columnNames.length;
    }
    
    /**
    * This method gets values associated with a particular row in the table, switching
    * through all of the columns in the given row and returning the values
    *
    * @param row
    * @param column
    * @return column values for particular row
    */
    @Override
    public Object getValueAt(int row, int column) {
        StudentProfile studentProfile = studentProfiles.get(row);
        switch (column) {
            case 0:
                return studentProfile.getFirstName();
            case 1:
                return studentProfile.getLastName();
            case 2:
                return studentProfile.getGuardianName();
            case 3:
                return studentProfile.getEmailAddress();
            case 4:
                return studentProfile.getPhoneNumber();
            case 5:
                return studentProfile.getGender();
            case 6:
                return studentProfile.getDob();
            case 7:
                return studentProfile.getEnrollmentStatus();
        }
        return "";
    }
    
    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }
}
