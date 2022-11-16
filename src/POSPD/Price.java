package POSPD;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * The price of a particular item
 */
public class Price implements Comparable<Price>
{

	/**
	 * The item that needs a price
	 */
	private Item item;
	/**
	 * The price of the item
	 */
	private BigDecimal price;
	/**
	 * The date when the new price takes place
	 */
	private LocalDate effectiveDate;

	public Item getItem()
	{
		return this.item;
	}

	public void setItem(Item item)
	{
		this.item = item;
	}

	public BigDecimal getPrice()
	{
		return this.price;
	}

	public void setPrice(BigDecimal price)
	{
		this.price = price;
	}

	public LocalDate getEffectiveDate()
	{
		return this.effectiveDate;
	}

	public void setEffectiveDate(LocalDate effectiveDate)
	{
		this.effectiveDate = effectiveDate;
	}

	public Price()
	{
		
	}

	/**
	 * 
	 * @param parameter
	 */
	public Price(Item item, String price, String effectiveDate)
	{
		this();
		this.price = new BigDecimal(price);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/d/yyyy");
		this.effectiveDate = LocalDate.parse(effectiveDate, formatter);
		item.addPrice(this);
	}

	/**
	 * If the price is in effect
	 * @param date
	 */
	public boolean isEffective(LocalDate date)
	{
		if(effectiveDate.isEqual(date) || effectiveDate.isBefore(date))
		{
			return true;
		}
		return false;
	}

	/**
	 * Calculates the total amount for the quantity of the item
	 * @param quantity
	 */
	public BigDecimal calcAmountForQty(int quantity)
	{
		return price.multiply(new BigDecimal(quantity));
	}

	/**
	 * Compares one price to another
	 * @param price
	 */
	public int compareTo(Price price)
	{
		return effectiveDate.compareTo(price.effectiveDate);
	}

	public String toString()
	{
		
		return this.price.toString() + " " + effectiveDate.toString();
	}

}