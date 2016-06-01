/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.security.Key;
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
public class MyBlowfishTest {
    
    public MyBlowfishTest() {
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
    public void testGetSecretKey() {
        System.out.println("getSecretKey");
        MyBlowfish instance = new MyBlowfish();
        Key expResult = null;
        Key result = instance.getSecretKey();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetSecretKeyInBytes() {
        System.out.println("getSecretKeyInBytes");
        MyBlowfish instance = new MyBlowfish();
        byte[] expResult = null;
        byte[] result = instance.getSecretKeyInBytes();
        assertArrayEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testSetSecretKey_Key() {
        System.out.println("setSecretKey");
        Key secretKey = null;
        MyBlowfish instance = new MyBlowfish();
        instance.setSecretKey(secretKey);
        fail("The test case is a prototype.");
    }

    @Test
    public void testSetSecretKey_byteArr() {
        System.out.println("setSecretKey");
        byte[] keyData = null;
        MyBlowfish instance = new MyBlowfish();
        instance.setSecretKey(keyData);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGenerateKey() {
        System.out.println("generateKey");
        MyBlowfish instance = new MyBlowfish();
        instance.generateKey();
        fail("The test case is a prototype.");
    }

    @Test
    public void testCrypt_byteArr() {
        System.out.println("crypt");
        byte[] plaintext = null;
        MyBlowfish instance = new MyBlowfish();
        byte[] expResult = null;
        byte[] result = instance.crypt(plaintext);
        assertArrayEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testCrypt_String() {
        System.out.println("crypt");
        String plaintext = "";
        MyBlowfish instance = new MyBlowfish();
        byte[] expResult = null;
        byte[] result = instance.crypt(plaintext);
        assertArrayEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testDecryptInBytes() {
        System.out.println("decryptInBytes");
        byte[] ciphertext = null;
        MyBlowfish instance = new MyBlowfish();
        byte[] expResult = null;
        byte[] result = instance.decryptInBytes(ciphertext);
        assertArrayEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testDecryptInString() {
        System.out.println("decryptInString");
        byte[] ciphertext = null;
        MyBlowfish instance = new MyBlowfish();
        String expResult = "";
        String result = instance.decryptInString(ciphertext);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        MyBlowfish.main(args);
        fail("The test case is a prototype.");
    }
    
}
