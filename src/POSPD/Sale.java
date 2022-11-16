package POSPD;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.*;

/**
 * The representation of the customer buying items
 */
public class Sale
{

	/**
	 * The items being bought
	 */
	private ArrayList<SaleLineItem> saleLineItems;
	/**
	 * The payment of the sale
	 */
	private ArrayList<Payment> payments;
	/**
	 * The date and time of the sale
	 */
	private LocalDateTime dateTime;
	/**
	 * If the sale is tax free or not
	 */
	private boolean taxFree;

	public ArrayList<SaleLineItem> getSaleLineItems()
	{
		return this.saleLineItems;
	}

	public void setSaleLineItems(ArrayList<SaleLineItem> saleLineItems)
	{
		this.saleLineItems = saleLineItems;
	}

	public ArrayList<Payment> getPayments()
	{
		return this.payments;
	}

	public void setPayments(ArrayList<Payment> payments)
	{
		this.payments = payments;
	}

	public LocalDateTime getDateTime()
	{
		return this.dateTime;
	}

	public void setDateTime(LocalDateTime dateTime)
	{
		this.dateTime = dateTime;
	}

	public boolean isTaxFree()
	{
		return this.taxFree;
	}

	public void setTaxFree(boolean taxFree)
	{
		this.taxFree = taxFree;
	}

	public Sale()
	{
		saleLineItems = new ArrayList<SaleLineItem>();
		payments = new ArrayList<Payment>();
	}

	/**
	 * 
	 * @param taxFree
	 */
	public Sale(String taxFree)
	{
		this();
		if (taxFree.equals("Y") || taxFree.equals("y"))
		{
			setTaxFree(true);
		}
		else
		{
			setTaxFree(false);
		}
	}

	/**
	 * adds a payment to the sale
	 * @param payment
	 */
	public void addPayment(Payment payment)
	{
		payments.add(payment);
	}

	/**
	 * removes a payment from the sale
	 * @param payment
	 */
	public void removePayment(Payment payment)
	{
		// TODO - implement Sale.removePayment
		throw new UnsupportedOperationException();
	}

	/**
	 * Adds an item to the sale
	 * @param sli
	 */
	public void addSaleLineItem(SaleLineItem sli)
	{
		saleLineItems.add(sli);
	}

	/**
	 * Removes an item from the sale
	 * @param sli
	 */
	public void removeSaleLineItem(SaleLineItem sli)
	{
		// TODO - implement Sale.removeSaleLineItem
		throw new UnsupportedOperationException();
	}

	/**
	 * calculates the total of the sale
	 */
	public BigDecimal calcTotal()
	{
		if(taxFree)
		{
			return calcSubTotal();	
		}
		else
		{
			return calcSubTotal().add(calcTax());
		}
		
	}

	/**
	 * calculates the sub total of the sale
	 */
	public BigDecimal calcSubTotal()
	{
		BigDecimal subTotal = new BigDecimal(0);
		for(int counter = 0; counter < saleLineItems.size(); counter++) 
		{
			subTotal = subTotal.add(saleLineItems.get(counter).calcSubTotal());
		}
		return subTotal;
	}

	/**
	 * calculates the tax of the sale
	 */
	public BigDecimal calcTax()
	{
		BigDecimal tax = new BigDecimal(0);
		for(int counter = 0; counter < saleLineItems.size(); counter++) 
		{
			tax = tax.add(saleLineItems.get(counter).calcTax());
		}
		return tax;
	}

	/**
	 * Gets the total of payments the customer has made
	 */
	public BigDecimal getTotalPayments()
	{
		BigDecimal totalPayments = new BigDecimal(0);
		for(int counter = 0; counter < payments.size(); counter++)
		{
			totalPayments = totalPayments.add(payments.get(counter).getAmount());
		}
		return	totalPayments;
	}

	/**
	 * If the payment the customer gives is enough
	 */
	public boolean isPaymentEnough()
	{
		BigDecimal payment = this.getTotalPayments();
		BigDecimal total = this.calcTotal();
		if (payment.compareTo(total) == 1 || payment.compareTo(total) == 0)
		{
			return true;
		}
		return false;
	}

	/**
	 * Calculates the amount for the payment
	 * @param amtTendered
	 */
	public void calcAmountForPayment(BigDecimal amtTendered)
	{
		// TODO - implement Sale.calcAmountForPayment
		throw new UnsupportedOperationException();
	}

	/**
	 * Calculates the change to give to the user
	 */
	public BigDecimal calcChange()
	{
		BigDecimal change = new BigDecimal(0);
		change = calcAmtTendered().subtract(calcTotal());
		return change;
	}

	/**
	 * Calculates the amount given to the cashier by the customer
	 */
	public BigDecimal calcAmtTendered()
	{
		BigDecimal AmtTendered = new BigDecimal(0);
		for(int counter = 0; counter < payments.size(); counter++)
		{
			AmtTendered = AmtTendered.add(payments.get(counter).getAmtTendered());
		}
		return AmtTendered;
	}

	public String toString()
	{
		String sLIString = "";
		for(SaleLineItem sli : saleLineItems)
		{
			sLIString += sli.toString();
			sLIString += "\n";
		}
		String tax = "0.00";
		if (!taxFree)
		{
			tax = calcTax().toString();
		}
		return ("Sale: SubTotal = " + calcSubTotal().toString() + " " + "Tax = " + tax + " Total = " + calcTotal() + " Payment = " + getTotalPayments().toString() +
				" Change = " + calcChange().toString() + "\n" + sLIString + "\n");
	}

}