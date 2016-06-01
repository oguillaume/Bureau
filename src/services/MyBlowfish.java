/* Updates: 2004.03.23 */

package services;
import java.math.*;
import javax.crypto.*;
import java.security.*;
import javax.crypto.spec.*;


/** 
 * Cette classe propose des m�thodes permettant de crypter et d�crypter des 
 * messages avec l'algorithme de Blowfish.
 */
public class MyBlowfish {
  public final static int KEY_SIZE = 128;  // [32..448]

  private Key secretKey;
  
  
  public MyBlowfish() {
  }

 
  public Key getSecretKey() {
    return secretKey;
  }
  
  
  /**
   * Retourne toutes les informations de la cl� sous forme d'un tableau de
   * bytes. Elle peut ainsi �tre stock�e puis reconstruite ult�rieurement en
   * utilisant la m�thode setSecretKey(byte[] keyData)
   */
  public byte[] getSecretKeyInBytes() {
    return secretKey.getEncoded();
  }
  
    
  public void setSecretKey(Key secretKey) {
    this.secretKey = secretKey;
  }
  
  
  /**
   * Permet de reconstruire la cl� secr�te � partir de ses donn�es, stock�es 
   * dans un tableau de bytes.
   */
  public void setSecretKey(byte[] keyData) {
    secretKey = new SecretKeySpec(keyData, "Blowfish");    
  }
  
  
  public void generateKey() {
    try {
      KeyGenerator keyGen = KeyGenerator.getInstance("Blowfish");
      keyGen.init(KEY_SIZE);
      secretKey = keyGen.generateKey();  
    }
    catch (Exception e) {System.out.println(e);} 
  }


  public byte[] crypt(byte[] plaintext) {
    try {
      Cipher cipher = Cipher.getInstance("Blowfish");
      cipher.init(Cipher.ENCRYPT_MODE, secretKey);
      return cipher.doFinal(plaintext);    
    }
    catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | IllegalBlockSizeException | BadPaddingException e) {System.out.println(e);} 
    return null;
  }

  
  public byte[] crypt(String plaintext) {
    return crypt(plaintext.getBytes());
  }
  

  public byte[] decryptInBytes(byte[] ciphertext) {
    try {
      Cipher cipher = Cipher.getInstance("Blowfish");
      cipher.init(Cipher.DECRYPT_MODE, secretKey);
      return cipher.doFinal(ciphertext);
    }
    catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | IllegalBlockSizeException | BadPaddingException e) {System.out.println(e);} 
    return null;
  }
  
  
  public String decryptInString(byte[] ciphertext) {
    return new String(decryptInBytes(ciphertext));
  }


  /**
   * Cette m�thode permet de tester le bon fonctionnement des autres.
   */
  public static void main(String[] args) {
    String plaintext = args[0];
    System.out.println("plaintext = " + plaintext);
    MyBlowfish bf = new MyBlowfish();
    bf.generateKey();
    byte[] secretKey = bf.getSecretKeyInBytes();
    byte[] ciphertext = bf.crypt(plaintext);   
    System.out.println("ciphertext = " + new BigInteger(ciphertext));

    bf.setSecretKey(secretKey);
    String plaintext2 = bf.decryptInString(ciphertext);
    System.out.println("plaintext2 = " + plaintext2);
    if (!plaintext2.equals(plaintext)) System.out.println("Error: plaintext2 != plaintext");
  }
}