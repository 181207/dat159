package no.hvl.dat159;

public class Backstage extends Item {

	public Backstage(String name, int sellIn, int quality) {
		super("Backstage", sellIn, quality);
	}

	@Override
	public void updateQtyOnQty() {
		increaseQty();
		if (sellIn < 11) {
			increaseQty();
		}
		if (sellIn < 6) {
			increaseQty();
		}
	}

	private void increaseQty() {
		if (highQty()) {
			quality++;
		}
	}
	
	@Override
	void updateQtyOnSellIn() {
		if(sellIn<0) {
			quality = 0;
		}
	}
}