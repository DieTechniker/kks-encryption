/*--- (C) 1999-2019 Techniker Krankenkasse ---*/

package de.tk.sys.security.cms.api;

import java.io.InputStream;

/**
 * Schnittstelle f�r das Entschl�sseln und Verschl�sseln von Nachrichten im PKCS#7/CMS-Format. Nachrichten m�ssen
 * grunds�tzlich mit Signaturen versehen werden. Beim Entschl�sseln wird die Signatur der Nachricht anhand des
 * entsprechenden Signatur-Zertifikats gepr�ft. Beim Verschl�sseln wird die Nachricht entsprechend mit dem
 * Signatur-Zertifikat signiert. Siehe auch <a href="https://tools.ietf.org/html/rfc5652">RFC5652</a>
 *
 * @author  Wolfgang Schmiesing (P224488, IT.IN.FRW)
 */
public interface PKCS7CMSService {

	/**
	 * Signiert und verschl�sselt eine Nachricht (erst Signieren dann Verschl�sseln). Die Nachricht wird zun�chst
	 * signiert und als SignedData-Objekt verpackt. Danach wird die signierte Nachricht verschl�sselt und als
	 * EnvelopedData-Objekt zur�ckgeliefert.
	 *
	 * @param   payload     die zu verschl�sselnde Nachricht
	 * @param   identifier  die ID des Empf�ngers, z.B. die Arbeitgebernummer
	 *
	 * @return  InputStream auf die signierte und mit dem Public-Key des Empf�ngers verschl�sselte SMIME-Nachricht
	 */
	InputStream signAndEncrypt(InputStream payload, String identifier);

	/**
	 * Entschl�sselt eine Nachricht und �berpr�ft die Signatur in der Nachricht.
	 *
	 * @param   signedAndEncrypted  signierte und verschl�sselte Nachricht
	 * @param   identifier          ID des Absenders/Signierenden
	 *
	 * @return  InputStream auf die entschl�sselte Nachricht im Klartext.
	 */
	InputStream decryptAndVerify(InputStream signedAndEncrypted, String identifier);

}

/*--- Formatiert nach TK Code Konventionen vom 05.03.2002 ---*/
