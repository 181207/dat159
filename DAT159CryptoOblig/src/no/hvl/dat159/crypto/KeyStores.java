/**
 * 
 */
package no.hvl.dat159.crypto;

import java.io.FileInputStream;
import java.io.InputStream;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;


/**
 * @author tdoy
 *
 */
public class KeyStores {

	
	/**
	 * 
	 * @param keystore
	 * @param alias
	 * @param keystorepassword
	 * @return
	 * @throws KeyStoreException 
	 * @throws NoSuchAlgorithmException 
	 * @throws UnrecoverableKeyException 
	 */
	public static PrivateKey getPrivateKeyFromKeyStore(String keystore, String alias, String keystorepassword) throws KeyStoreException, NoSuchAlgorithmException, CertificateException, UnrecoverableKeyException {
		
		// Load the keystore (programmatically) and extract the private key from the keystore
		KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
		try(InputStream stream = new FileInputStream(keystore)){
			keyStore.load(stream, keystorepassword.toCharArray());
		} catch(Exception e) {
			
		}
		PrivateKey pk = (PrivateKey) keyStore.getKey(alias, keystorepassword.toCharArray());
		// implement me
		
		return pk;
	}
}
