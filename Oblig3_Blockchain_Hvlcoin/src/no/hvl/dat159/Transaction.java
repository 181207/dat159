package no.hvl.dat159;

import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import no.hvl.dat159.util.SignatureUtil;

public class Transaction {
	
	private List<Input> inputs = new ArrayList<>();
	private List<Output> outputs = new ArrayList<>();
	
	/*
	 * Simplification!:
	 * In reality, each input should have a public key and a signature. To simplify 
	 * things, we assume that all inputs belong to the same public key => We can 
	 * store the public key in the transaction and sign for all inputs in one go.
	 */
	private PublicKey senderPublicKey;
	private byte[] signature; 
	
	public Transaction(PublicKey senderPublicKey) {
		this.senderPublicKey = senderPublicKey;
	}
	
	public void signTxUsing(PrivateKey privateKey) {
		SignatureUtil.signWithDSA(privateKey, inputs.toString());
	}

	public boolean isValid(UtxoMap utxoMap) {
		//Matching the public key with the address of the referenced output
		//Checking that the signature is valid
	    //TODO
		boolean valid = false;
		if (inputs==null || outputs==null || senderPublicKey==null || signature==null) {
			return false;
		}
		if (inputs.isEmpty() || outputs.isEmpty()) {
			return false;
		}
	    //No outputs can be zero or negative
		for (Output output : outputs) {
			if (output.getValue() <= 0){
				return false;
			}
		}
	    //All inputs must exist in the UTXO-set
		for (Input input : inputs) {
			Set set = utxoMap.getAllUtxos();
			if (!set.contains(input)) {
				return false;
			}
		}
	    //All inputs must belong to the sender of this transaction
        //No inputs can be zero or negative
        //The list of inputs must not contain duplicates
        //The total input amount must be equal to (or less than, if we 
        //allow fees) the total output amount
        //The signature must belong to the sender and be valid
        //The transaction hash must be correct
	    return true;
		
	}
	
	/**
	 *	The transaction hash (= a unique txid) as a hexadecimal String. 
	 */
	public String getTxId() {
		//TODO
		return null;
	}

	public void addInput(Input input) {
		inputs.add(input);
	}
	
	public void addOutput(Output output) {
		outputs.add(output);
	}
	
	public List<Input> getInputs() {
		return inputs;
	}

	public List<Output> getOutputs() {
		return outputs;
	}

	public PublicKey getSenderPublicKey() {
		return senderPublicKey;
	}

	public byte[] getSignature() {
		return signature;
	}

	@Override
	public String toString() {
		String s = getTxId();
		for (int i=0; i<inputs.size(); i++) {
			s += "\n\tinput(" + i + ")   : " + inputs.get(i);
		}
		for (int i=0; i<outputs.size(); i++) {
			s += "\n\toutput(" + i + ")  : " + outputs.get(i);
		}
		return s;
	}

	
}
