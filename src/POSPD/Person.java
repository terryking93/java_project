package POSPD;
/**
 * The representation of an employee
 */
public class Person
{

	/**
	 * The employees cashier info
	 */
	private Cashier cashier;
	/**
	 * The employees name
	 */
	private String name;
	/**
	 * The employee's address
	 */
	private String address;
	/**
	 * The employee's city
	 */
	private String city;
	/**
	 * The employee's state
	 */
	private String state;
	/**
	 * The employee's zip code
	 */
	private String zip;
	/**
	 * The employee's phone number
	 */
	private String phone;
	/**
	 * The employee's social security number
	 */
	private String sSN;

	public Cashier getCashier()
	{
		return this.cashier;
	}

	public void setCashier(Cashier cashier)
	{
		this.cashier = cashier;
	}

	public String getName()
	{
		return this.name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getAddress()
	{
		return this.address;
	}

	public void setAddress(String address)
	{
		this.address = address;
	}

	public String getCity()
	{
		return this.city;
	}

	public void setCity(String city)
	{
		this.city = city;
	}

	public String getState()
	{
		return this.state;
	}

	public void setState(String state)
	{
		this.state = state;
	}

	public String getZip()
	{
		return this.zip;
	}

	public void setZip(String zip)
	{
		this.zip = zip;
	}

	public String getPhone()
	{
		return this.phone;
	}

	public void setPhone(String phone)
	{
		this.phone = phone;
	}

	public String getSSN()
	{
		return this.sSN;
	}

	public void setSSN(String sSN)
	{
		this.sSN = sSN;
	}

	/**
	* The default constructor for Person
	*
	*/
	public Person()
	{
		
	}

	/**
	 * 
	 * * The constructor that instantiates the personal details of the employee
	 * *
	 * * @param name The name of the employee
	 * * @param address The employee's address
	 * * @param city The employee's city
	 * * @param state The employee's state
	 * * @param zip The employee's zip code
	 * * @param phone The employee's phone number
	 * * @param sSN The employee's social security number
	 * * @return
	 * 
	 * @param name
	 * @param address
	 * @param city
	 * @param state
	 * @param zip
	 * @param phone
	 * @param sSN
	 */
	public Person(String name, String address, String city, String state, String zip, String phone, String sSN)
	{
		setName(name);
		setAddress(address);
		setCity(city);
		setState(state);
		setZip(zip);
		setPhone(phone);
		setSSN(sSN);
	}

	/**
	* Returns the string representation of peron
	*
	* @return String The string representation of person
	*/
	public String toString()
	{
		// TODO - implement Person.toString
		throw new UnsupportedOperationException();
	}

}