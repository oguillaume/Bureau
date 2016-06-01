/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bdd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
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
public class BaseTest {
    
    public BaseTest() {
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

    @Test
    public void testConnexion() throws Exception {
        System.out.println("connexion");
        Base instance = new Base();
        Connection expResult = null;
        Connection result = instance.connexion();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testDeconnexion() {
        System.out.println("deconnexion");
        Connection conn = null;
        Base instance = new Base();
        instance.deconnexion(conn);
        fail("The test case is a prototype.");
    }

    @Test
    public void testExecuterRequeteQuery() throws Exception {
        System.out.println("executerRequeteQuery");
        String requete = "";
        Connection conn = null;
        Object[] objet = null;
        Base instance = new Base();
        ResultSet expResult = null;
        ResultSet result = instance.executerRequeteQuery(requete, conn, objet);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testExecuterRequeteUpdate() {
        System.out.println("executerRequeteUpdate");
        String requete = "";
        Connection conn = null;
        boolean clretour = false;
        Object[] objets = null;
        Base instance = new Base();
        int expResult = 0;
        int result = instance.executerRequeteUpdate(requete, conn, clretour, objets);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testInitialisationRequetePreparee() throws Exception {
        System.out.println("initialisationRequetePreparee");
        Connection connexion = null;
        String sql = "";
        boolean returnGenerateKeys = false;
        Object[] objets = null;
        PreparedStatement expResult = null;
        PreparedStatement result = Base.initialisationRequetePreparee(connexion, sql, returnGenerateKeys, objets);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testFermetureSilencieuse_ResultSet() {
        System.out.println("fermetureSilencieuse");
        ResultSet resultSet = null;
        Base.fermetureSilencieuse(resultSet);
        fail("The test case is a prototype.");
    }

    @Test
    public void testFermetureSilencieuse_Statement() {
        System.out.println("fermetureSilencieuse");
        Statement statement = null;
        Base.fermetureSilencieuse(statement);
        fail("The test case is a prototype.");
    }

    @Test
    public void testFermetureSilencieuse_Connection() {
        System.out.println("fermetureSilencieuse");
        Connection connexion = null;
        Base.fermetureSilencieuse(connexion);
        fail("The test case is a prototype.");
    }

    @Test
    public void testFermetureSilencieuse_Statement_Connection() {
        System.out.println("fermetureSilencieuse");
        Statement statement = null;
        Connection connexion = null;
        Base.fermetureSilencieuse(statement, connexion);
        fail("The test case is a prototype.");
    }

    @Test
    public void testFermetureSilencieuse_3args() {
        System.out.println("fermetureSilencieuse");
        ResultSet resultSet = null;
        Statement statement = null;
        Connection connexion = null;
        Base.fermetureSilencieuse(resultSet, statement, connexion);
        fail("The test case is a prototype.");
    }
    
}
