package eu.europa.esig.dss.cookbook.example.snippets;

import java.util.List;

import org.apache.commons.codec.binary.Base64;

import eu.europa.esig.dss.DigestAlgorithm;
import eu.europa.esig.dss.SignatureValue;
import eu.europa.esig.dss.ToBeSigned;
import eu.europa.esig.dss.token.DSSPrivateKeyEntry;
import eu.europa.esig.dss.token.MSCAPISignatureToken;
import eu.europa.esig.dss.token.SignatureTokenConnection;

public class MSCAPISnippet {

	public static void main(String[] args){

		// tag::demo[]

		SignatureTokenConnection token = new MSCAPISignatureToken();

		List<DSSPrivateKeyEntry> keys = token.getKeys();
		for (DSSPrivateKeyEntry entry : keys) {
			System.out.println(entry.getCertificate().getCertificate());
		}

		ToBeSigned toBeSigned = new ToBeSigned("Hello world".getBytes());
		SignatureValue signatureValue = token.sign(toBeSigned, DigestAlgorithm.SHA256, keys.get(0));

		System.out.println("Signature value : " + Base64.encodeBase64String(signatureValue.getValue()));

		// end::demo[]
	}

}
