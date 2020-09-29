package no.hvl.dat159;

public class Item {

	public String name;

	public int sellIn;

	public int quality;

	public Item(String name, int sellIn, int quality) {
		this.name = name;
		this.sellIn = sellIn;
		this.quality = quality;
	}

	@Override
	public String toString() {
		return this.name + ", " + this.sellIn + ", " + this.quality;
	}

	public void updateQtyOnQty() {
		if (lowQty()) {
			quality--;
		}
	}

	public void updateSellIn() {
		sellIn--;
	}

	public boolean lowQty() {
		return this.quality > 0;
	}

	public boolean highQty() {
		return this.quality < 50;
	}

	void updateQtyOnSellIn() {
		if (quality > 0 && sellIn < 0) {
			quality--;
		}
	}

}