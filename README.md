# KKS Verschlüsselung auf Basis von CMS

Spezifikation siehe [GKV Anlage 16 SecuritySchnittstelle SECON](https://www.gkv-datenaustausch.de/media/dokumente/standards_und_normen/technische_spezifikationen/Anlage_16_-_Security-Schnittstelle.pdf)

## Interfaces
 
	PKCS7CMSService: Schnittstelle für Verschlüsselung/Signatur und Entschlüsselung/Signaturprüfung 
	
	PKCS7KeyLocator: Schnittstelle für die Schlüsselverwaltung
	
## Eingesetzte Technologie

[BouncyCastle](https://bouncycastle.org/)

[Cryptographic Message Syntax (CMS)](https://tools.ietf.org/html/rfc5652) 
