/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nst.service.impl;

import com.nst.DAO.UserDAO;
import com.nst.model.User;
import com.nst.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author milisava
 */
@Service
public class UserServiceImpl implements IUserService       
{   @Autowired
    private UserDAO userDAO;
    

    @Override
    public User login(String username, String password) {
        return userDAO.login(username,password);
    }
    
}
