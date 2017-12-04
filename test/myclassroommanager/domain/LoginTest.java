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
public class LoginTest {
    
    public LoginTest() {
    }
    
        @Test
    public void testValidatePass() {
        Login login = new Login();
        login.setUsername("johndoe");
        login.setPassword("123456");
        boolean result = login.validate();
        assertTrue(result);
    }
    
    @Test
    public void testValidateFail() {
        Login login = new Login();
        login.setUsername("johndoe");
        //login.setPassword("123456");
        boolean result = login.validate();
        assertFalse(result);
    }
    
    @Test
    public void testEquals() {
        Login login1 = new Login();
        login1.setUsername("johndoe");
        login1.setPassword("12345");
        
        Login login2 = new Login();
        login2.setUsername("janedoe");
        login2.setPassword("54321");
        
        assertFalse(login1.equals(login2));
        login2.setUsername("johndoe");
        assertFalse(login1.equals(login2));
        login2.setPassword("12345");
        assertTrue(login1.equals(login2));
    }
}
