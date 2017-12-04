/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myclassroommanager.domain;

/**
 *
 * @author jamesstrater-smith
 * 
 * Login class provides domain layer functionality for user logins
 */
public class Login {
    
    private String username = "";
    private String password = "";
    
    public String getUsername() {
        return username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    
    public String getPassword() {
        return password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Login{" + "username=" + username + ", password=" + password + '}';
    }
    
    /**
    * equals method checks if set username and password equal user given
    * username and password
    *
    * @param obj
    *
    * @return true if user's login username and password are 
    * valid, and false if they are not
    */ 
    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (! (obj instanceof Login)) return false;
        Login login = (Login)obj;
        if (!this.username.equals(login.getUsername())) return false;
        if (!this.password.equals(login.getPassword())) return false;
        return true;
    }

    /**
     * This method validates login object, returns true if valid
     *
     * @return true or false
     */
    public boolean validate () {
        if (username == null || username.equals("")) return false;
        if (password == null || password.equals("")) return false;
        return true;
    }
}
