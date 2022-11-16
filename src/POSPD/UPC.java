package POSPD;

/**
 * The UPC codes associated to every item that is sold
 */
public class UPC
{

	/**
	 * The item that is linked to the UPC
	 */
	private Item item;
	/**
	 * The UPC that is linked to an item
	 */
	private String uPC;

	public Item getItem()
	{
		return this.item;
	}

	public void setItem(Item item)
	{
		this.item = item;
	}

	public String getUPC()
	{
		return this.uPC;
	}

	public void setUPC(String uPC)
	{
		this.uPC = uPC;
	}

	public UPC()
	{
		// TODO - implement UPC.UPC
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param upc
	 */
	public UPC(String upc, Item item)
	{
		setUPC(upc);
		setItem(item);
		item.addUPC(this);
	}

	public String toString()
	{
		return uPC;
	}

}