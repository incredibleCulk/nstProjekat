/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nst.service;

import com.nst.model.User;

/**
 *
 * @author milisava
 */
public interface IUserService {
    User login(String username,String password);
}
