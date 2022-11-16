package POSPD;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * What percentage of the sale the tax is
 */
public class TaxRate implements Comparable<TaxRate>
{

	/**
	 * The percentage of the sale the tax is
	 */
	private BigDecimal taxRate;
	/**
	 * The date the new tax is taken into effect
	 */
	private LocalDate effectiveDate;

	public BigDecimal getTaxRate()
	{
		return this.taxRate;
	}

	public void setTaxRate(BigDecimal taxRate)
	{
		this.taxRate = taxRate;
	}

	public LocalDate getEffectiveDate()
	{
		return this.effectiveDate;
	}

	public void setEffectiveDate(LocalDate effectiveDate)
	{
		this.effectiveDate = effectiveDate;
	}

	public TaxRate()
	{
		// TODO - implement TaxRate.TaxRate
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param effectiveDate
	 * @param rate
	 */
	public TaxRate(LocalDate effectiveDate, BigDecimal rate)
	{
		setTaxRate(rate);
		setEffectiveDate(effectiveDate);
	}

	/**
	 * If the tax is effective or not
	 * @param date
	 */
	public boolean isEffective(LocalDate date)
	{
		if(effectiveDate.isEqual(date) || effectiveDate.isBefore(date))
		{
			return true;
		}
		else return false;
	}

	/**
	 * Compares one tax rate to another
	 * @param taxRate
	 */
	public int compareTo(TaxRate taxRate)
	{
		return effectiveDate.compareTo(taxRate.effectiveDate);
	}

	public String toString()
	{
		return taxRate.toString();
		
	}

}