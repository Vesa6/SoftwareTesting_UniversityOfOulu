package fi.oulu.tol.sqat.tests;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import fi.oulu.tol.sqat.GildedRose;
import fi.oulu.tol.sqat.Item;

public class GildedRoseTest {

	@Test
	public void testTheTruth() {
		assertTrue(true);
	}
	
	
	@Test
	public void exampleTest() {
		//create an inn, add an item, and simulate one day
		GildedRose inn = new GildedRose();
		inn.setItem(new Item("+5 Dexterity Vest", 5, 20));
		inn.oneDay();
		
		//access a list of items, get the quality of the one set
		List<Item> items = inn.getItems();
		int quality = items.get(0).getQuality();
		
		//assert quality has decreased by one
		assertEquals("Failed quality for Dexterity Vest", 19, quality);
	}
	
	
	@Test
	public void testBries() {
		
		GildedRose inn = new GildedRose();
		
		inn.setItem(new Item("Aged Brie", 5, 20));
		inn.setItem(new Item("Aged Brie", -5, 20));
		inn.setItem(new Item("Aged Brie", 10, 55));
		inn.setItem(new Item("Aged Brie", 20, 80));
		inn.setItem(new Item("Aged Brie", -5, 51));
		
		inn.oneDay();
		
		List<Item> items = inn.getItems();
		int qual1 = items.get(0).getQuality();
		int qual2 = items.get(1).getQuality();
		int qual3 = items.get(2).getQuality();
		int qual4 = items.get(3).getQuality();
		int qual5 = items.get(4).getQuality();
		
		assertEquals("The quality of the Brie should increase by one.", 21, qual1);
		assertEquals("The quality of the Brie should increase by two.", 22, qual2);
		assertEquals("The quality of the Brie should stay the same", 55, qual3);
		assertEquals("The quality of the brie should stay the same", 80, qual4);
		assertEquals("The quality of the brie should stay the same.", 51, qual5);
	}
	
	@Test
	public void testPasses() {
		
		GildedRose inn = new GildedRose();
		
		inn.setItem(new Item("Backstage passes to a TAFKAL80ETC concert", 5, 20));
		inn.setItem(new Item("Backstage passes to a TAFKAL80ETC concert", 20, -20));
		inn.setItem(new Item("Backstage passes to a TAFKAL80ETC concert", 10, 55));
		inn.setItem(new Item("Backstage passes to a TAFKAL80ETC concert", 20, 80));
		
		inn.oneDay();
		
		List<Item> items = inn.getItems();
		int qual1 = items.get(0).getQuality();
		int qual2 = items.get(1).getQuality();
		int qual3 = items.get(2).getQuality();
		int qual4 = items.get(3).getQuality();
		
		
		
		assertEquals("The quality of the Pass should increase by three.", 23, qual1);
		assertEquals("The quality of the Pass should increase by one.", -19, qual2);
		assertEquals("The quality of the Pass should stay the same.", 55, qual3);
		assertEquals("The quality of the Pass should stay the same.", 80, qual4);
		
	}
	
	@Test
	public void testSulfuras() {
		
		GildedRose inn = new GildedRose();
		
		inn.setItem(new Item("Sulfuras, Hand of Ragnaros", 5, 20));
		inn.setItem(new Item("Sulfuras, Hand of Ragnaros", 10, 55));
		inn.setItem(new Item("Sulfuras, Hand of Ragnaros", 20, 80));
		
		inn.oneDay();
		
		List<Item> items = inn.getItems();
		int qual1 = items.get(0).getQuality();
		int qual2 = items.get(1).getQuality();
		int qual3 = items.get(2).getQuality();
		
		assertEquals("The quality of the Sulfuras should stay the same.", 20, qual1);
		assertEquals("The quality of the Sulfuras should stay the same.", 55, qual2);
		assertEquals("The quality of the Sulfuras should stay the same.", 80, qual3);
	}
	
	@Test
	public void testElixir() {
		
		GildedRose inn = new GildedRose();
		
		inn.setItem(new Item("Elixir of the Mongoose", 5, 20));
		inn.setItem(new Item("Elixir of the Mongoose", 10, 55));
		inn.setItem(new Item("Elixir of the Mongoose", 20, 80));
		inn.setItem(new Item("Elixir of the Mongoose", 10, -20));
		
		inn.oneDay();
		
		List<Item> items = inn.getItems();
		int qual1 = items.get(0).getQuality();
		int qual2 = items.get(1).getQuality();
		int qual3 = items.get(2).getQuality();
		int qual4 = items.get(3).getQuality();
		
		assertEquals("The quality of the Elixir should decrease by one.", 19, qual1);
		assertEquals("The quality of the Elixir should decrease by one.", 54, qual2);
		assertEquals("The quality of the Elixir should decrease by one.", 79, qual3);
		assertEquals("The quality of the Elixir should stay the same.", -20, qual4);
		
	}

	
	@Test
	public void testDifferentItems() {
		GildedRose inn = new GildedRose();
		inn.setItem(new Item("+5 Dexterity Vest", -20, 5));
		inn.setItem(new Item("+5 Dexterity Vest", 10, 55));
		inn.setItem(new Item("Backstage passes to a TAFKAL80ETC concert", -100, -20));
		inn.setItem(new Item("Sulfuras, Hand of Ragnaros", -100, -20));
		inn.setItem(new Item("Backstage passes to a TAFKAL80ETC concert", 1, 15));
		inn.setItem(new Item("Backstage passes to a TAFKAL80ETC concert", 12, 15));
		inn.setItem(new Item("Backstage passes to a TAFKAL80ETC concert", 1, 49));
		inn.setItem(new Item("Backstage passes to a TAFKAL80ETC concert", 1, 50));
		inn.setItem(new Item("Sulfuras, Hand of Ragnaros", -10, 5));
		
		inn.oneDay();
		
		List<Item> items = inn.getItems();
		int qual1 = items.get(0).getQuality();
		int qual2 = items.get(1).getQuality();
		int qual3 = items.get(2).getQuality();
		int qual4 = items.get(3).getQuality();
		int qual5 = items.get(4).getQuality();
		int qual6 = items.get(5).getQuality();
		int qual7 = items.get(6).getQuality();
		int qual8 = items.get(7).getQuality();
		int qual9 = items.get(8).getQuality();
		
		assertEquals("The quality of the Vest should decrease by 2.", 3, qual1);
		assertEquals("The quality of the Vest should decrease by 1.", 54, qual2);
		assertEquals("The quality of the Pass shouldn't be negative.", 0, qual3);
		assertEquals("The quality of the Sulfuras should stay the same.", -20, qual4);
		assertEquals("The quality of the Pass should increase by 3.", 18, qual5);
		assertEquals("The quality of the Pass should increase by 1.", 16, qual6);
		assertEquals("The quality of the Vest should increase by 1.", 50, qual7);
		assertEquals("The quality of the Elixir should stay the same", 50, qual8);
		assertEquals("The quality of the Elixir should stay the same", 5, qual9);
	
	}
	
	
	@Test
	public void testMain() {
		GildedRose inn = new GildedRose();
		GildedRose.main(null);
		
		inn.oneDay();
		
		assertTrue(true);
	}
	
}
