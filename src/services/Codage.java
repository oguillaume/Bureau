/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Formatter;

/**
 *
 * @author adm
 */
public class Codage {
    public static String encryptPassword(String password,String type) //cryptage du mot de passe
    {
        String passhache = "";
        try
        {
            MessageDigest crypt = MessageDigest.getInstance(type);
            crypt.reset();
            crypt.update(password.getBytes("UTF-8"));
            passhache = byteToHex(crypt.digest());
        }catch(NoSuchAlgorithmException | UnsupportedEncodingException e){
            e.printStackTrace();
        }
        return passhache;
    }
    private static String byteToHex(final byte[] hash) // conversion octet-hexa
    {
        Formatter formatter = new Formatter();
        for (byte b : hash){
        formatter.format("%02x", b);
        }
        String result = formatter.toString();
        formatter.close();
        return result;
    }
}
