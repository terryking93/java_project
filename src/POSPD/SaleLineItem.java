package POSPD;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * The item that is being bought
 */
public class SaleLineItem
{

	/**
	 * The item that is being bought
	 */
	private Item item;
	/**
	 * The sale that includes the items being bought
	 */
	private Sale sale;
	/**
	 * The quantity of the item/s being bought
	 */
	private int quantity;

	public Item getItem()
	{
		return this.item;
	}

	public void setItem(Item item)
	{
		this.item = item;
	}

	public Sale getSale()
	{
		return this.sale;
	}

	public void setSale(Sale sale)
	{
		this.sale = sale;
	}

	public int getQuantity()
	{
		return this.quantity;
	}

	public void setQuantity(int quantity)
	{
		this.quantity = quantity;
	}

	public SaleLineItem()
	{
		sale = null;
		item = null;
		quantity= 0;
	}

	/**
	 * 
	 * @param sale
	 * @param item
	 * @param quantity
	 */
	public SaleLineItem(Sale sale, Item item, String quantity)
	{
		setSale(sale);
		setItem(item);
		setQuantity(Integer.valueOf(quantity));
		sale.addSaleLineItem(this);
	}
	
	public BigDecimal calcSubTotal() {
		
		return item.calcAmountForDateQty(LocalDate.now(), quantity);
	}
	
	public BigDecimal calcTax() {
		return item.getTaxRateForDate(LocalDate.now()).multiply(calcSubTotal()).setScale(2, RoundingMode.HALF_UP);
	}
	
	public String toString(){
		return (item.getNumber() + " " + item.getDescription() + " " + String.valueOf(quantity) + " @" + item.getPriceForDate(LocalDate.now())
		+ " " + calcSubTotal().toString());
	}

}