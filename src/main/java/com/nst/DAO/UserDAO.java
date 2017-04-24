/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nst.DAO;

import com.nst.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author milisava
 */
@Repository
public interface UserDAO extends JpaRepository<User, Integer> {
    @Query("SELECT u FROM User u WHERE u.username=?1 AND u.password=?2")
    public User login(String username, String password);
    
}
