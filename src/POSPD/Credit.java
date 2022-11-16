package POSPD;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * The representation of the customers creditcard
 */
public class Credit extends AuthorizedPayment
{

	/**
	 * The card's brand
	 */
	private String cardType;
	/**
	 * The customers bank account number
	 */
	private String acctNumber;
	/**
	 * The credit cards expiration date
	 */
	private LocalDate expireDate;

	public String getCardType()
	{
		return this.cardType;
	}

	public void setCardType(String cardType)
	{
		this.cardType = cardType;
	}

	public String getAcctNumber()
	{
		return this.acctNumber;
	}

	public void setAcctNumber(String acctNumber)
	{
		this.acctNumber = acctNumber;
	}

	public LocalDate getExpireDate()
	{
		return this.expireDate;
	}

	public void setExpireDate(LocalDate expireDate)
	{
		this.expireDate = expireDate;
	}

	public Credit()
	{
		// TODO - implement Credit.Credit
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param cardType
	 * @param acctNumber
	 * @param exireDate
	 */
	public Credit(String cardType, String acctNumber, String expireDate)
	{
		setCardType(cardType);
		setAcctNumber(acctNumber);
		LocalDate ed;
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/d/yyyy");
		ed = LocalDate.parse(expireDate, formatter);
		setExpireDate(ed);
	}

	/**
	 * Whether or not the card is authorized
	 */
	public boolean isAuthorized()
	{
		if(expireDate.isAfter(LocalDate.now()))
		{
			return true;
		}
		return false;
	}

	public String toString()
	{
		// TODO - implement Credit.toString
		throw new UnsupportedOperationException();
	}

}