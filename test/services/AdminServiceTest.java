/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import bdd.Gestionnaire;
import java.sql.Connection;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author adm
 */
public class AdminServiceTest {
    
    public AdminServiceTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of chargerAdmin method, of class AdminService.
     */
    @Test
    public void testChargerAdmin() {
        System.out.println("chargerAdmin");
        Connection conn = null;
        String identifiant = "";
        AdminService instance = new AdminService();
        Gestionnaire expResult = null;
        Gestionnaire result = instance.chargerAdmin(conn, identifiant);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of retirerAdmin method, of class AdminService.
     */
    @Test
    public void testRetirerAdmin() {
        System.out.println("retirerAdmin");
        Connection conn = null;
        Gestionnaire admin = null;
        AdminService instance = new AdminService();
        instance.retirerAdmin(conn, admin);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of creerAdmin method, of class AdminService.
     */
    @Test
    public void testCreerAdmin() {
        System.out.println("creerAdmin");
        Connection conn = null;
        String nom = "";
        String prenom = "";
        String adresse = "";
        String motDePasse = "";
        String identifiant = "";
        AdminService instance = new AdminService();
        instance.creerAdmin(conn, nom, prenom, adresse, motDePasse, identifiant);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of verifierAdmin method, of class AdminService.
     */
    @Test
    public void testVerifierAdmin() {
        System.out.println("verifierAdmin");
        Connection conn = null;
        String identifiant = "";
        String mot_de_passe = "";
        AdminService instance = new AdminService();
        boolean expResult = false;
        boolean result = instance.verifierAdmin(conn, identifiant, mot_de_passe);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
