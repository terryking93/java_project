package POSPD;
/**
 * The representation of a  single cash register
 */
public class Register
{

	/**
	 * The registers identifying number
	 */
	private String number;
	/**
	 * The cash drawer of the register
	 */
	private CashDrawer cashDrawer;

	public String getNumber()
	{
		return this.number;
	}

	public void setNumber(String number)
	{
		this.number = number;
	}

	public CashDrawer getCashDrawer()
	{
		return this.cashDrawer;
	}

	public void setCashDrawer(CashDrawer cashDrawer)
	{
		this.cashDrawer = cashDrawer;
	}

	public Register()
	{
		number = null;
	}

	/**
	 * 
	 * @param number
	 */
	public Register(String number)
	{
		setNumber(number);
	}

	/**
	 * Returns the string representation of the register
	 */
	public String toString()
	{
		return number;
	}

}