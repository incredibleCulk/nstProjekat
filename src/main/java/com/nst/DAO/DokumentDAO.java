/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nst.DAO;

import com.nst.model.Dokument;
import java.io.Serializable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author milisava
 */
@Repository
public interface DokumentDAO extends JpaRepository<Dokument, Integer>{
    
}
