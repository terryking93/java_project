package POSPD;

import java.math.BigDecimal;


/**
 * The payment as cash
 */
public class Cash extends Payment
{

	public Cash()
	{
		// TODO - implement Cash.Cash
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param amount
	 * @param amtTendered
	 */
	public Cash(String amount, BigDecimal amtTendered)
	{
		this.setAmount(new BigDecimal(amount));
		this.setAmtTendered(amtTendered);
	}

	/**
	 * If the payment counts as cash
	 */
	public boolean countsAsCash()
	{
		return true;
	}

	public String toString()
	{
		// TODO - implement Cash.toString
		throw new UnsupportedOperationException();
	}
}
