import javax.crypto.spec.SecretKeySpec;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.NoSuchAlgorithmException;

public class GenerateKey {
	public static void generateKey(String KeyAlgorithm) throws NoSuchAlgorithmException {
		try {
			KeyGenerator key = KeyGenerator.getInstance(KeyAlgorithm);
			SecretKey key1 = key.generateKey();
			byte[] sk1 = key1.getEncoded();
			int len1 = sk1.length;
			
			System.out.println("\nAlgorithm used is: " + KeyAlgorithm);
			System.out.println("Key1 generated is: " + key1);
			System.out.println("Key1 length is:" +len1);
			
			SecretKey key2 = new SecretKeySpec(sk1, KeyAlgorithm);
			byte[] sk2 = key2.getEncoded();
			int len2 = sk2.length;
			
			System.out.println("\nAlgorithm used is: " + KeyAlgorithm);
			System.out.println("Key2 generated is: " + key2);
			System.out.println("Key2 length is:" +len2);
			
			System.out.println("Are both keys symmetric? " + key1.equals(key2));
		}
		catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) throws NoSuchAlgorithmException {
		generateKey("DES");
		generateKey("AES");
		generateKey("Blowfish");
		generateKey("DESede");
		generateKey("HmacMD5");
		generateKey("HmacSHA1");
	}
}

