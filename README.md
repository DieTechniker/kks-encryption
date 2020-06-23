#KKS Verschl�sselung auf Basis von CMS

Spezifikation siehe [GKV Anlage 16 SecuritySchnittstelle SECON](https://www.gkv-datenaustausch.de/media/dokumente/standards_und_normen/technische_spezifikationen/Anlage_16_-_Security-Schnittstelle.pdf)

##Interfaces
 
	PKCS7CMSService: Schnittstelle f�r Verschl�sselung/Signatur und Entschl�sselung/Signaturpr�fung 
	
	PKCS7KeyLocator: Schnittstelle f�r die Schl�sselverwaltung
	
## Eingesetzte Technologie

[BouncyCastle](https://bouncycastle.org/)

[Cryptographic Message Syntax (CMS)](https://tools.ietf.org/html/rfc5652) 