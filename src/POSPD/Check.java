package POSPD;
/**
 * The representation of a check that the customer writes
 */
public class Check extends AuthorizedPayment
{

	/**
	 * The number connected to the customer's bank account
	 */
	private String routingNumber;
	/**
	 * The customers bank account number
	 */
	private String accountNumber;
	/**
	 * The checks identification number
	 */
	private String checkNumber;

	public String getRoutingNumber()
	{
		return this.routingNumber;
	}

	public void setRoutingNumber(String routingNumber)
	{
		this.routingNumber = routingNumber;
	}

	public String getAccountNumber()
	{
		return this.accountNumber;
	}

	public void setAccountNumber(String accountNumber)
	{
		this.accountNumber = accountNumber;
	}

	public String getCheckNumber()
	{
		return this.checkNumber;
	}

	public void setCheckNumber(String checkNumber)
	{
		this.checkNumber = checkNumber;
	}

	public Check()
	{
		// TODO - implement Check.Check
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param routingNumber
	 * @param accountNumber
	 * @param checkNumber
	 */
	public Check(String routingNumber, String accountNumber, String checkNumber)
	{
		setAccountNumber(accountNumber);
		setRoutingNumber(routingNumber);
		setCheckNumber(checkNumber);
		
	}

	/**
	 * Checks if the check is authorized or not
	 */
	public boolean isAuthorized()
	{
		// TODO - implement Check.isAuthorized
		throw new UnsupportedOperationException();
	}

	public String toString()
	{
		// TODO - implement Check.toString
		throw new UnsupportedOperationException();
	}

}