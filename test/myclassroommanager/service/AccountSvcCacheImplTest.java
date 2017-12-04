/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myclassroommanager.service;

import myclassroommanager.domain.Account;
import myclassroommanager.domain.Login;
import myclassroommanager.domain.StudentProfile;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jamesstrater-smith
 */
public class AccountSvcCacheImplTest {
    
    public AccountSvcCacheImplTest() {
    }

    @Test
    public void testAccountSvcCacheImplCRUD() {
        
        AccountSvcCacheImpl impl = AccountSvcCacheImpl.getInstance();
        List<Account> accounts = impl.retrieveAll();
        assertEquals(accounts.size(), 0);
        
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
        // test create
        assertNotNull(account);
        assertNotEquals(account.getId(), 1);
        // test retrieveAll
        accounts = impl.retrieveAll();
        assertEquals(accounts.size(), 0);
        //test update
        account.setFirstName("Jane");
        account = impl.update(account);
        accounts = impl.retrieveAll();
        assertEquals(accounts.size(), 0);
        assertEquals(account.getFirstName(), "Jane");
        //test delete
        account = impl.delete(account);
        assertEquals(accounts.size(), 0);
        //test authenticate
        Account account1 = new Account();
        account1.setFirstName("John");
        account1.setLastName("Doe");
        Login login1 = new Login();
        login1.setUsername("jdoe");
        login1.setPassword("123456");
        account1.setLogin(login1);
        account1 = impl.create(account1);
        assertNotNull(account1);
        
        Account account2 = new Account();
        account2.setFirstName("Jane");
        account2.setLastName("McDoe");
        Login login2 = new Login();
        login2.setUsername("jmcdoee");
        login2.setPassword("7890");
        account2.setLogin(login2);
        account2 = impl.create(account2);
        assertNotNull(account2);
        
        Login login3 = new Login();
        login3.setUsername("blah");
        login3.setPassword("yada");
        Account authenticatedAccount = impl.authenticate(login3);
        assertNull(authenticatedAccount);
        login3.setUsername("jdoe");
        authenticatedAccount = impl.authenticate(login3);
        assertNull(authenticatedAccount);
        login3.setPassword("123456");
        authenticatedAccount = impl.authenticate(login3);
        assertNotNull(authenticatedAccount);
        login3.setUsername("jmcdoee");
        authenticatedAccount = impl.authenticate(login3);
        assertNull(authenticatedAccount);
        login3.setPassword("7890");
        authenticatedAccount = impl.authenticate(login3);
        assertNotNull(authenticatedAccount);
    }
    
}
