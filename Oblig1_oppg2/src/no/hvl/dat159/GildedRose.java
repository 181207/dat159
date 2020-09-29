package no.hvl.dat159;


public class GildedRose {
	 Item[] items;

	    public GildedRose(Item[] items) {
	        this.items = items;
	    }

	    public void updateQuality() {
	        for(Item item : items) {
	            item.updateQtyOnQty();
	            item.updateSellIn();
	            item.updateQtyOnSellIn();
	        }
	    }
}