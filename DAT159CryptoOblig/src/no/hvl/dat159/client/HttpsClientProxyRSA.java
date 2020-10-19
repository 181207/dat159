package no.hvl.dat159.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.SocketAddress;
import java.net.URL;
import java.security.InvalidKeyException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.SignatureException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;

import javax.crypto.NoSuchPaddingException;
import javax.net.ssl.HttpsURLConnection;

import no.hvl.dat159.config.ProxyConfig;
import no.hvl.dat159.config.ServerConfig;
import no.hvl.dat159.crypto.DigitalSignature;
import no.hvl.dat159.crypto.KeyStores;

public class HttpsClientProxyRSA {

	private String server;
	private int port;
	
	public HttpsClientProxyRSA(String server, int port) {
		this.server = server;
		this.port = port;
	}
	
	public void doClient(String message) throws InvalidKeyException, NoSuchAlgorithmException, SignatureException, NoSuchPaddingException, UnrecoverableKeyException, KeyStoreException, CertificateException {
		
		URL url;
		
		SocketAddress addr = new InetSocketAddress(ProxyConfig.SERVER, ProxyConfig.PORT);
		Proxy proxy = new Proxy(Proxy.Type.HTTP, addr);
		
		try {
			
			// sign the message and append the signature to the message to the server
			
			// implement me
			String algoritm = DigitalSignature.SIGNATURE_SHA256WithRSA;
			PrivateKey pk = getPrivateKey();
			byte [] signature = DigitalSignature.sign(message, pk, algoritm);
			String signatureinhex = DigitalSignature.getHexValue(signature);
						
			message = message + "-"+signatureinhex;			// format message as: Message-Signature

			
			url = new URL("https://"+server+":"+port+"/"+message);
			
			HttpsURLConnection con = (HttpsURLConnection) url.openConnection(proxy);
			
			BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
			
			StringBuffer sb = new StringBuffer();
			String line = "";
			while((line = br.readLine())!=null) {
				sb.append(line+"\n");
			}
			
			System.out.println(sb);
			
			con.disconnect();
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private PrivateKey getPrivateKey() throws NoSuchAlgorithmException, NoSuchPaddingException, UnrecoverableKeyException, KeyStoreException, CertificateException, IOException {
		
		// implement me
		String keystore = "mykeys/tcp_keystore";
		String alias = "tcpexample";
		String password = "password";
		return KeyStores.getPrivateKeyFromKeyStore(keystore, alias, password);
		
	}
	
	public static void main(String[] args) throws InvalidKeyException, NoSuchAlgorithmException, SignatureException, NoSuchPaddingException, UnrecoverableKeyException, KeyStoreException, CertificateException {
		
		// set the truststores dynamically using the system property
		System.setProperty("javax.net.ssl.trustStore","mykeys/tcp_truststore");
		System.setProperty("javax.net.ssl.trustStorePassword", "password");
		// implement me - You need to also add the zap truststore in order for your to route ssl traffic via zap
		System.setProperty("javax.net.ssl.trustStore","owasp_zap_root_ca.cer");
		System.setProperty("javax.net.ssl.trustStorePassword", "password");
		
		String message = "Message from HTTPS client";
		HttpsClientProxyRSA c = new HttpsClientProxyRSA(ServerConfig.SERVER, ServerConfig.S_PORT);
		c.doClient(message);

	}

}
