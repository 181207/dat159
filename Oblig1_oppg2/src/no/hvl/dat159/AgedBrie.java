package no.hvl.dat159;

public class AgedBrie extends Item {
	public AgedBrie(String name, int sellIn, int quality) {
		super("AgedBrie", sellIn, quality);
	}

	@Override
	public void updateQtyOnQty() {
		if (highQty()) {
			quality++;
		}
	}
	@Override
	public void updateQtyOnSellIn() {
		if(highQty() && sellIn<0) {
			quality++;
		}
	}

}
