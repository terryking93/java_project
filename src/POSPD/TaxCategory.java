package POSPD;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import POSPD.TaxRate;

public class TaxCategory
{

	/**
	 * The category of the tax
	 */
	private String category;
	/**
	 * The rate of the tax category
	 */
	private TreeSet<TaxRate> taxRates;

	public String getCategory()
	{
		return this.category;
	}

	public void setCategory(String category)
	{
		this.category = category;
	}

	public TreeSet<TaxRate> getTaxRates()
	{
		return this.taxRates;
	}

	public void setTaxRates(TreeSet<TaxRate> taxRates)
	{
		this.taxRates = taxRates;
	}

	public TaxCategory()
	{
		taxRates = new TreeSet<TaxRate>();
	}

	/**
	 * 
	 * @param category
	 */
	public TaxCategory(String category, String effectiveDate, String taxRate)
	{
		this();
		setCategory(category);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
		TaxRate tr = new TaxRate( LocalDate.parse(effectiveDate, formatter), new BigDecimal(taxRate));
		this.addTaxRate(tr);
	}

	/**
	 * Gets the tax rate that is active during that date
	 * @param date
	 */
	public BigDecimal getTaxRateForDate(LocalDate date)
	{
		BigDecimal currentTax = new BigDecimal(0);
		for(TaxRate value: taxRates)
		{
			if(value.isEffective(date))
			{
				currentTax = value.getTaxRate();
			}
		}
		return currentTax;
	}

	/**
	 * Adds a tax rate
	 * @param taxRate
	 */
	public void addTaxRate(TaxRate taxRate)
	{
		taxRates.add(taxRate);
	}

	/**
	 * Removes a tax rate
	 * @param taxRate
	 */
	public void removeTaxRate(TaxRate taxRate)
	{
		// TODO - implement TaxCategory.removeTaxRate
		throw new UnsupportedOperationException();
	}

	public String toString()
	{
		return this.taxRates.toString();
	}

}