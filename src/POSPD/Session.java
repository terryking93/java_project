package POSPD;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

/**
 * A customer checking out
 */
public class Session
{
	private String number;
	/**
	 * The cashier checking out the customer
	 */
	private Cashier cashier;
	/**
	 * The register the session is occurring on
	 */
	private Register register;
	/**
	 * The sale at the end of the session
	 */
	private ArrayList<Sale> sales;
	/**
	 * The date and time the session starts
	 */
	private LocalDateTime startDateTime;
	/**
	 * The date and time the session ends
	 */
	private LocalDateTime endDateTime;

	public String getNumber()
	{
		return number;
	}
	
	public Cashier getCashier()
	{
		return this.cashier;
	}

	public void setCashier(Cashier cashier)
	{
		this.cashier = cashier;
	}

	public Register getRegister()
	{
		return this.register;
	}

	public void setRegister(Register register)
	{
		this.register = register;
	}

	public ArrayList<Sale> getSales()
	{
		return this.sales;
	}

	public void setSales(ArrayList<Sale> sales)
	{
		this.sales = sales;
	}

	public LocalDateTime getStartDateTime()
	{
		return this.startDateTime;
	}

	public void setStartDateTime(LocalDateTime startDateTime)
	{
		this.startDateTime = startDateTime;
	}

	public LocalDateTime getEndDateTime()
	{
		return this.endDateTime;
	}

	public void setEndDateTime(LocalDateTime endDateTime)
	{
		this.endDateTime = endDateTime;
	}

	/**
	* The Default constructor for session
	*
	*/
	public Session()
	{
		sales = new ArrayList<Sale>();
		startDateTime = LocalDateTime.now();
	}

	/**
	 * 
	 * * the constructor for session that takes in the cashier and the register as parameters
	 * *
	 * * @param cashier The cashier in charge of the session
	 * * @param register The register the session is happening on
	 * 
	 * @param cashier
	 * @param register
	 */
	public Session(Cashier cashier, Register register)
	{
		this();
		setCashier(cashier);
		setRegister(register);
	}

	/**
	 * 
	 * * Adds a sale to the session
	 * *
	 * * @param sale The sale to be added
	 * 
	 * @param sale
	 */
	public void addSale(Sale sale)
	{
		sales.add(sale);
	}

	/**
	 * 
	 * * Removes a sale from the session
	 * *
	 * * @param sale The sale to be removed
	 * 
	 * @param sale
	 */
	public void removeSale(Sale sale)
	{
		// TODO - implement Session.removeSale
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * * Counts the cash and calculates the difference
	 * *
	 * * @param cash The amount of cash at the end of the session
	 * 
	 * @param cash
	 */
	public BigDecimal calcCashCountDiff(BigDecimal cash)
	{
		// TODO - implement Session.calcCashCountDiff
		throw new UnsupportedOperationException();
	}

	/**
	* Returns the string representation of the session
	*
	* @return String
	*/
	public String toString()
	{
		BigDecimal total = new BigDecimal(0);
		for(Sale sale : sales)
		{
			total = total.add(sale.calcTotal());
		}
		String endTime = "";
		if (endDateTime == null)
		{
			endTime = "";
		}
		
		
		return ("Session: Cashier: " + cashier.getPerson().getName() + " Register: " + register.getNumber() + " Total: " + total.toString() +
					" " + startDateTime.toString() + " - " + endTime + "\n" + "\n" + sales.toString() + "\n");
	}

}