package POSPD;

/**
 * The representation of the payment that has been authorized
 */
public class AuthorizedPayment extends Payment
{

	/**
	 * The code that confirms the payment has been authorized
	 */
	private String authorizationCode;

	public String getAuthorizationCode()
	{
		return this.authorizationCode;
	}

	public void setAuthorizationCode(String authorizationCode)
	{
		this.authorizationCode = authorizationCode;
	}

	/**
	 * Whether or not the payment has been accepted
	 */
	public boolean isAuthorized()
	{
		// TODO - implement AuthorizedPayment.isAuthorized
		throw new UnsupportedOperationException();
	}

	/**
	 * Whether or not the payment is cash or not
	 */
	public boolean countsAsCash()
	{
		return false;
	}

}