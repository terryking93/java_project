package POSPD;

import java.math.BigDecimal;

/**
 * Keeps track of the cash in the register
 */
public class CashDrawer
{

	/**
	 * The amount of cash in the drawer
	 */
	private BigDecimal cashAmount;
	/**
	 * The position of the cash drawer
	 */
	private int position;

	public BigDecimal getCashAmount()
	{
		return this.cashAmount;
	}

	public void setCashAmount(BigDecimal cashAmount)
	{
		this.cashAmount = cashAmount;
	}

	public int getPosition()
	{
		return this.position;
	}

	public void setPosition(int position)
	{
		this.position = position;
	}

	public CashDrawer()
	{
		cashAmount = new BigDecimal(0);
		position = 0;
	}

	/**
	 * Removes cash from the drawer
	 * @param cash
	 */
	public void removeCash(BigDecimal cash)
	{
		cashAmount.subtract(cash);
	}

	/**
	 * Records adding cash to the register
	 * @param cash
	 */
	public void addCash(BigDecimal cash)
	{
		cashAmount.add(cash);
	}

	public String toString()
	{
		// TODO - implement CashDrawer.toString
		throw new UnsupportedOperationException();
	}

}