/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import entities.User;

/**
 *
 * @author jifang
 */
public class AccountService {
    public User login(String username, String password) {
        User ret = null;
        
        if ((username.compareToIgnoreCase("abe")==0 || username.compareToIgnoreCase("barb")==0) 
                && password.compareTo("password") == 0) {
            ret = new User(username, password);
        }
        
        return ret;
    }
}
