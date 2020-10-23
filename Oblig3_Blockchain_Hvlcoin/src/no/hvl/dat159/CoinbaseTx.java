package no.hvl.dat159;

/**
 * 
 */
public class CoinbaseTx {
	
	/*
	 * The block number wherein this coinbase tx is located.
	 * This is to ensure unique txIds, see BIP34
	 */
	private int blockHeight; 
	
	/*
	 * The message for this coinbase tx.
	 */
	private String message;
	
	/*
	 * The output for this coinbase tx.
	 */
	private Output output;

	/* --------------------------------------------------------------------- */

	public CoinbaseTx(int blockHeight, String message, String walletAddress) {
		this.blockHeight = blockHeight;
		this.message = message;
		this.output = new Output(Blockchain.BLOCK_REWARD,walletAddress);
	}
	
	public boolean isValid(UtxoMap utxoMap) {
		//TODO		
		return true;
	}

	public String getMessage() {
		return message;
	}

	public Output getOutput() {
		return output;
	}

	/**
	 *	The transaction hash (= a unique txid) as a hexadecimal String. 
	 */
	public String getTxId() {
		
		//TODO
		return null;
	}
	
	@Override
	public String toString() {
		return getTxId() + "\n\tmessage    : " + message + "\n\toutput(0)  : " + output;
	}
	
}
