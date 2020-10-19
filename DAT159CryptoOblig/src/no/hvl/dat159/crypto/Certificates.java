/**
 * 
 */
package no.hvl.dat159.crypto;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.security.PublicKey;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;

/**
 * @author tdoy
 *
 */
public class Certificates {

	/**
	 * Given a certificate, extract the public key for operations such as encryption/signature
	 */
	
	/**
	 * Client side public key methods
	 * @param certfile
	 * @return
	 */
	public static PublicKey getPublicKey(String certfile) {
		
		
		// implement me
		X509Certificate certificate = null;
		
		try {
			FileInputStream stream = new FileInputStream(certfile);
			CertificateFactory cf = CertificateFactory.getInstance("X509");
			certificate = (X509Certificate) cf.generateCertificate(stream);
		} catch (CertificateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		return certificate.getPublicKey();
	}

}
