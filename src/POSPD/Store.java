package POSPD;
import java.util.*;

import POSDM.StoreDM;

/**
 * Knows about all the things that goes into making a sale
 */
public class Store
{

	/**
	 * The store's number
	 */
	private String number;
	/**
	 * The store's name
	 */
	private String name;
	/**
	 * The tax category for the store
	 */
	private TreeMap<String, TaxCategory> taxCategories;
	/**
	 * The store's items
	 */
	private TreeMap<String, Item> items;
	/**
	 * The store's cashiers
	 */
	private TreeMap<String, Cashier> cashiers;
	/**
	 * The store's registers
	 */
	private TreeMap<String, Register> registers;
	/**
	 * The store's sessions
	 */
	private ArrayList<Session> sessions;
	/**
	 * The store's scanable codes
	 */
	private TreeMap<String, UPC> uPCs;

	public String getNumber()
	{
		return this.number;
	}

	public void setNumber(String number)
	{
		this.number = number;
	}

	public String getName()
	{
		return this.name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public TreeMap<String, TaxCategory> getTaxCategories()
	{
		return this.taxCategories;
	}

	public void setTaxCategories(TreeMap<String, TaxCategory> taxCategories)
	{
		this.taxCategories = taxCategories;
	}

	public TreeMap<String, Item> getItems()
	{
		return this.items;
	}

	public void setItems(TreeMap<String, Item> items)
	{
		this.items = items;
	}

	public TreeMap<String, Cashier> getCashiers()
	{
		return this.cashiers;
	}

	public void setCashiers(TreeMap<String, Cashier> cashiers)
	{
		this.cashiers = cashiers;
	}

	public TreeMap<String, Register> getRegisters()
	{
		return this.registers;
	}

	public void setRegisters(TreeMap<String, Register> registers)
	{
		this.registers = registers;
	}

	public ArrayList<Session> getSessions()
	{
		return this.sessions;
	}

	public void setSessions(ArrayList<Session> sessions)
	{
		this.sessions = sessions;
	}

	public TreeMap<String, UPC> getUPCs()
	{
		return this.uPCs;
	}

	public void setUPCs(TreeMap<String, UPC> uPCs)
	{
		this.uPCs = uPCs;
	}

	/**
	* Default constructor for Store
	*
	*
	* greater than 0
	*/
	public Store()
	{
		taxCategories = new TreeMap<String, TaxCategory>();
		items = new TreeMap<String, Item>();
		cashiers = new TreeMap<String, Cashier>();
		registers = new TreeMap<String, Register>();
		sessions = new ArrayList<Session>();
		uPCs = new TreeMap<String, UPC>();
	}

	/**
	 * 
	 * *Default constructor for Store that instantiates name and number
	 * *
	 * * @param number The store number
	 * * @param name The store's name
	 * 
	 * @param number
	 * @param name
	 */
	public Store(String number, String name)
	{
		this();
		this.setNumber(number);
		this.setName(name);
	}

	/**
	 * 
	 * * Adds an item to the store
	 * *
	 * * @param item This is the item to be added to the store
	 * 
	 * @param item
	 */
	public void addItem(Item item)
	{
		items.put(item.getNumber(), item);
	}

	/**
	 * 
	 * * Removes an item from the store
	 * *
	 * * @param item The item to be removed from the store
	 * 
	 * @param item
	 */
	public void removeItem(Item item)
	{
		// TODO - implement Store.removeItem
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * * Adds a UPC to the store
	 * *
	 * * @param upc The UPC to be added to the store
	 * 
	 * @param upc
	 */
	public void addUPC(UPC upc)
	{
		uPCs.put(upc.getUPC(), upc);
	}

	/**
	 * 
	 * * Removes a UPC from the store
	 * *
	 * * @param upc The UPC to be removed from the store
	 * 
	 * @param upc
	 */
	public void removeUPC(UPC upc)
	{
		// TODO - implement Store.removeUPC
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * * Adds a register to the store
	 * *
	 * * @param register The register to be added to the store
	 * 
	 * @param register
	 */
	public void addRegister(Register register)
	{
		registers.put(register.getNumber(), register);
	}

	/**
	 * 
	 * * Removes a register from the store
	 * *
	 * * @param register The register to be removed from the store
	 * 
	 * @param register
	 */
	public void removeRegister(Register register)
	{
		// TODO - implement Store.removeRegister
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * * Adds a cashier to the store
	 * *
	 * * @param cashier The cashier to be added to the store
	 * 
	 * @param cashier
	 */
	public void addCashier(Cashier cashier)
	{
		cashiers.put(cashier.getNumber(), cashier);
	}

	/**
	 * 
	 * * Removes a cashier from the store
	 * *
	 * * @param cashier The cashier to be removed from the store
	 * 
	 * @param cashier
	 */
	public void removeCashier(Cashier cashier)
	{
		// TODO - implement Store.removeCashier
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * * Adds a tax category to the store
	 * *
	 * * @param taxCategory The tax category to be added to the store
	 * 
	 * @param taxCategory
	 */
	public void addTaxCategory(TaxCategory taxCategory)
	{
		taxCategories.put(taxCategory.getCategory(), taxCategory);
	}

	/**
	 * 
	 * * Removes a tax category from the store
	 * *
	 * * @param taxCategory The tax category to  be removed from the store
	 * 
	 * @param taxCategory
	 */
	public void removeTaxCategory(TaxCategory taxCategory)
	{
		// TODO - implement Store.removeTaxCategory
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * * Adds a sale session to the store
	 * *
	 * * @param  session The session to be added to the store
	 * 
	 * @param session
	 */
	public void addSession(Session session)
	{
		sessions.add(session);
	}

	/**
	 * 
	 * * Removes a sale session from the store
	 * *
	 * * @param session The session to be removed
	 * 
	 * @param session
	 */
	public void removeSession(Session session)
	{
		// TODO - implement Store.removeSession
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * * Locates a register by its number
	 * *
	 * * @param number The register's number that you are looking for
	 * * @return Register The register that has been found
	 * 
	 * @param number
	 */
	public Register findRegisterByNumber(String number)
	{
		if(number.length() > 0)
		{
			return registers.get(number);
		}
		else return null;
	}

	/**
	 * 
	 * * Finds an item based on it's UPC
	 * *
	 * * @param upc The UPC of the item you are looking for
	 * * @return Item The item that has been found
	 * 
	 * @param upc
	 */
	public Item findItemForUPC(String upc)
	{
		if(upc.length() > 0)
		{
			return uPCs.get(upc).getItem();
		}
		else return null;
	}

	/**
	 * 
	 * * Finds an item based off of it's number
	 * *
	 * * @param number The umber of the item to be found
	 * * @return Item The item that has been found
	 * 
	 * @param number
	 */
	public Item findItemForNumber(String number)
	{
		if(number.length() > 0)
		{
			return items.get(number);
		}
		else return null;
	}

	/**
	 * 
	 * * Finds a cashier based off of their number
	 * *
	 * * @param number The number of the cashier to be found
	 * * @return Cashier The cashier that has been found
	 * 
	 * @param number
	 */
	public Cashier findCashierForNumber(String number)
	{
		if(number.length() > 0)
		{
			return cashiers.get(number);
		}
		else return null;
	}

	/**
	 * 
	 * * Finds the tax category its name
	 * *
	 * * @param category The name of the tax category to be found
	 * * @return TaxCategory The tax category that has been found
	 * 
	 * @param category
	 */
	public TaxCategory findTaxCategoryByName(String category)
	{
		if(category.length() > 0)
		{
			return taxCategories.get(category);
		}
		else return null;
	}

	/**
	* The string representation of a store and all of its aspects
	*
	* @return String The string representation of the store
	*/
	public String toString()
	{
		return name;
	}

	public void openStore() {
		StoreDM.loadStore(this);
		
	}

}