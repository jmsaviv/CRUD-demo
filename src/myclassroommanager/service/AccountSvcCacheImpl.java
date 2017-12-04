/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myclassroommanager.service;

import myclassroommanager.domain.*;
import java.util.*;



/**
 * This class allows for implementation of all CRUD activities for user accounts
 * 
 * @author jamesstrater-smith
 */

public class AccountSvcCacheImpl implements IAccountSvc {
    
    private List<Account> cache = new ArrayList<Account>();
    private int nextId = 0;
    
    private AccountSvcCacheImpl(){
    }
    
    private static AccountSvcCacheImpl instance = new AccountSvcCacheImpl();
    
    public static AccountSvcCacheImpl getInstance(){
        return instance;
    }
    
    /**
     * This method creates account, account ID, and adds created account to cache
     * 
     * @param account
     * @return account
     */
    public Account create(Account account) {
        account.setId(++nextId);
        cache.add(account);
        return account;
    }
    
    /**
     * This method retrieves copied list of accounts 
     * 
     * @return cacheCopy
     */
    public List<Account> retrieveAll() {
        List<Account> cacheCopy = new ArrayList<Account>(cache.size());
        for (Account account: this.cache) {
            cacheCopy.add(account.copy());
        }
        return cacheCopy;
    }  
    
    /**
     * This method updates an account
     * 
     * @param account
     * @return account
     */
    public Account update(Account account) {
        for (int i = 0; i < cache.size(); i ++) {
            Account next = cache.get(i);
            if (next.getId() == account.getId()) {
                cache.set(i, account);
                break;
            }
        }
        return account;
    }
    
    /**
     * This method deletes an account
     * 
     * @param account
     * @return account
     */
    public Account delete(Account account) {
        for (int i = 0; i < cache.size(); i ++) {
            Account next = cache.get(i);
            if (next.getId() == account.getId()) {
                cache.set(i, account);
                break;
            }
        }
        return account;
    }
    
    /**
     * This method authenticates a given account 
     * 
     * @param login
     * @return null
     */
    public Account authenticate(Login login) {
        Account account = null;
        for ( int i=0; i<cache.size(); i++) {
            account = cache.get(i);
            Login accountLogin = account.getLogin();
            if (login.equals(accountLogin)) return account;
        }
        return null;
    }
}
