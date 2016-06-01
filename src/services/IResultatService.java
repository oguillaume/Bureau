/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.sql.Connection;
import java.util.List;

/**
 *
 * @author adm
 */
public interface IResultatService {
    public abstract List<List<String>> recupererResultatsElection(Connection conn);
    
    public abstract int nombreVotants(Connection conn);
    
    public abstract int nombreInscrits(Connection conn);
}
