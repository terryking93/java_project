package POSPD;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * The temporary discounted price of an item
 */
public class PromoPrice extends Price implements Comparable<Price>
{

	/**
	 * The end date of the promo price
	 */
	private LocalDate endDate;

	public LocalDate getEndDate()
	{
		return this.endDate;
	}

	public void setEndDate(LocalDate endDate)
	{
		this.endDate = endDate;
	}

	public PromoPrice()
	{
		// TODO - implement PromoPrice.PromoPrice
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param price
	 * @param effectiveDate
	 * @param endDate
	 */
	public PromoPrice(String price, String effectiveDate, String endDate)
	{
		this.setPrice(new BigDecimal(price));
		LocalDate ef;
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M/d/yy");
		
		ef = LocalDate.parse(effectiveDate, formatter);
		this.setEffectiveDate(ef);
		
		ef = LocalDate.parse(endDate, formatter);
		this.setEndDate(ef);
		
	}

	/**
	 * Checks if the promo price is in effect
	 * @param date
	 */
	public boolean isEffective(LocalDate date)
	{
		if(this.getEffectiveDate().isEqual(date) || this.getEffectiveDate().isBefore(date) && date.isBefore(endDate))
		{
			return true;
		}
		return false;
	}

	/**
	 * Compares the promo price to the regular price
	 * @param price
	 */
	public int compareTo(Price price)
	{
		return this.getEffectiveDate().compareTo(price.getEffectiveDate());
	}

	public String toString()
	{
		return this.getPrice().toString() + " " + this.getEffectiveDate().toString() + " - " + endDate.toString();

	}

}