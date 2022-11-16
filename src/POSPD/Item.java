package POSPD;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;
import java.util.function.Consumer;

/**
 * The representation of an item in the store
 */
public class Item
{

	/**
	 * The items that are being sole
	 */
	private ArrayList<SaleLineItem> saleLineItems;
	/**
	 * The price of the item
	 */
	private TreeSet<Price> prices;
	/**
	 * The UPC code of the item
	 */
	private TreeMap<String, UPC> uPCs;
	/**
	 * The items identification number
	 */
	private String number;
	/**
	 * The description of the item
	 */
	private String description;
	/**
	 * The tax category of the item
	 */
	private TaxCategory taxCategory;

	public ArrayList<SaleLineItem> getSaleLineItems()
	{
		return this.saleLineItems;
	}

	public void setSaleLineItems(ArrayList<SaleLineItem> saleLineItems)
	{
		this.saleLineItems = saleLineItems;
	}

	public TreeSet<Price> getPrices()
	{
		return this.prices;
	}

	public void setPrices(TreeSet<Price> prices)
	{
		this.prices = prices;
	}

	public TreeMap<String, UPC> getUPCs()
	{
		return this.uPCs;
	}

	public void setUPCs(TreeMap<String, UPC> uPCs)
	{
		this.uPCs = uPCs;
	}

	public String getNumber()
	{
		return this.number;
	}

	public void setNumber(String number)
	{
		this.number = number;
	}

	public String getDescription()
	{
		return this.description;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}

	public TaxCategory getTaxCategory()
	{
		return this.taxCategory;
	}

	public void setTaxCategory(TaxCategory taxCategory)
	{
		this.taxCategory = taxCategory;
	}

	public Item()
	{
		prices = new TreeSet<Price>();
		uPCs = new TreeMap<String, UPC>();
	}

	/**
	 * 
	 * @param number
	 * @param description
	 */
	public Item(Store store, String number, String description, String taxCategory)
	{
		this();
		setNumber(number);
		setDescription(description);
		setTaxCategory(store.findTaxCategoryByName(taxCategory));
		store.addItem(this);
	}

	/**
	 * Adds a price to an item
	 * @param price
	 */
	public void addPrice(Price price)
	{
		prices.add(price);
	}

	/**
	 * Removes a price from an item
	 * @param price
	 */
	public void removePrice(Price price)
	{
		// TODO - implement Item.removePrice
		throw new UnsupportedOperationException();
	}
	 
	/**
	 * Adds a UPC code to an item
	 * @param upc
	 */
	public void addUPC(UPC upc)
	{
		uPCs.put(upc.getUPC(), upc);
	}

	/**
	 * Removes a UPC code from an item
	 * @param upc
	 */
	public void removeUPC(UPC upc)
	{
		// TODO - implement Item.removeUPC
		throw new UnsupportedOperationException();
	}

	/**
	 * Gets the price based off of the date
	 * @param date
	 */
	public Price getPriceForDate(LocalDate date)
	{
		Price currentPrice = null;
		for(Price value: prices)
		{
			if(value.isEffective(date))
			{
				currentPrice = value;
			}
		}
		return currentPrice;
	}
 
	/**
	 * Gets the tax rate based off of the date
	 * @param date
	 */
	public BigDecimal getTaxRateForDate(LocalDate date)
	{
		return taxCategory.getTaxRateForDate(date);
	}

	/**
	 * Calculates the amount of the item based off of the date
	 * @param date
	 * @param quantity
	 */
	public BigDecimal calcAmountForDateQty(LocalDate date, int quantity)
	{
		return getPriceForDate(date).calcAmountForQty(quantity);
	}

	public String toString()
	{
		String upc = "";
		for(UPC u : getUPCs().values())
		{
			upc += u.toString();
		}
		String itemInfo = (number + " " + description + " " + getPriceForDate(LocalDate.now()).toString() + " " + taxCategory.toString() + " " + upc);
		return itemInfo;
	}

}