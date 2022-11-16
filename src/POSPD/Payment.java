package POSPD;

import java.math.BigDecimal;

/**
 * The representation of the customers payment
 */
public abstract class Payment
{

	/**
	 * The amount the payment needs to be
	 */
	private BigDecimal amount;
	/**
	 * The amount given by the customer
	 */
	private BigDecimal amtTendered;

	public BigDecimal getAmount()
	{
		return this.amount;
	}

	public void setAmount(BigDecimal amount)
	{
		this.amount = amount;
	}

	public BigDecimal getAmtTendered()
	{
		return this.amtTendered;
	}

	public void setAmtTendered(BigDecimal amtTendered)
	{
		this.amtTendered = amtTendered;
	}
	
	/**
	 * If the payment counts as cash
	 */
	public abstract boolean countsAsCash();
	
}