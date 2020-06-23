/*--- (C) 1999-2020 Techniker Krankenkasse ---*/

package de.tk.sys.security.cms.api;

import java.math.BigInteger;
import java.security.PrivateKey;
import java.security.cert.X509Certificate;

import javax.security.auth.x500.X500Principal;

/**
 * Ermittelt die f�r PKCS#7 n�tigen Schl�ssel und Zertifikate f�r Signatur, Verschl�sselung, Entschl�sselung und
 * Signaturpr�fung. An welchem Ort die Schl�ssel und Zertifikate verwaltet werden, bleibt der Implementierung �berlassen
 *
 * @author  Wolfgang Schmiesing (P224488, IT.IN.FRW)
 */
public interface PKCS7KeyLocator {

	/**
	 * Gibt den �ffentlichen Schl�ssel des Empf�ngers mit der �bergebenen ID zur�ck. Mit diesem Schl�ssel wird die
	 * Nachricht verschl�sselt (oder genauer ein symmetrischer Schl�ssel f�r die Nachrichtenverschl�sselung, siehe
	 * PKCS#7)
	 *
	 * @param   identifier  ID des Empf�ngers, z.B. Arbeitgebernummer o.�.
	 *
	 * @return  �ffentlicher Schl�ssel des Nachrichtenempf�ngers
	 */
	X509Certificate lookupEncryptionCertificate(String identifier);

	/**
	 * Gibt das Signaturzertifikat des Absenders zur�ck. Die Informationen �ber den Signierer werden mit in die
	 * signierte Nachricht �bernommen (Issuer und Seriennummer).
	 *
	 * @return  Signaturzertifikat des Absenders
	 */
	X509Certificate lookupSignatureCertificate();

	/**
	 * Gibt den privaten Schl�ssel des Absenders zur Signatur der Nachricht zur�ck. Mit diesem Key wird die Nachricht
	 * signiert.
	 *
	 * @return  Signaturschl�ssel
	 */
	PrivateKey lookupSignatureKey();

	/**
	 * @return  Gibt das Zertifikat f�r die Entschl�sselung der Nachricht zur�ck.
	 */
	X509Certificate lookupDecryptionCertificate();

	/**
	 * @return  Gibt den privaten Schl�ssel f�r die Entschl�sselung einer empfangenen Nachricht zur�ck.
	 */
	PrivateKey lookupDecryptionKey();

	/**
	 * Gibt das Zertifikat zur�ck anhand dessen die Signatur der Nachricht �berpr�ft werden soll. Es wird das Zertifikat
	 * zur�ckgegeben, welches zur �bergebenen Seriennummer/Issuer-Kombination passt
	 *
	 * @param   serialNumber   Seriennummer des Zertifikats
	 * @param   x500Principal  Issuer-DN (Zertifikatsherausgeber)
	 * @param   identifier     Identifier der den Signaturersteller identifiziert (z.B. Betriebsnummer, IK o.�.)
	 *
	 * @return  Zertifikat gegen das die Signatur gepr�ft wird.
	 */
	X509Certificate lookupVerificationCertificate(
		BigInteger    serialNumber,
		X500Principal x500Principal,
		String		  identifier
	);

}

/*--- Formatiert nach TK Code Konventionen vom 05.03.2002 ---*/
