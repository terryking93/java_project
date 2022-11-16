package POSPD;

import java.util.*;

/**
 * The representation of a cashier working at the store
 */
public class Cashier
{

	/**
	 * The cashiers id number
	 */
	private String number;
	/**
	 * The cashiers password
	 */
	private String password;
	/**
	 * The active sessions
	 */
	private ArrayList<Session> sessions;
	/**
	 * The employee information of the cashier
	 */
	private Person person;

	public String getNumber()
	{
		return this.number;
	}

	public void setNumber(String number)
	{
		this.number = number;
	}

	public String getPassword()
	{
		return this.password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	public ArrayList<Session> getSessions()
	{
		return this.sessions;
	}

	public void setSessions(ArrayList<Session> sessions)
	{
		this.sessions = sessions;
	}

	public Person getPerson()
	{
		return this.person;
	}

	public void setPerson(Person person)
	{
		this.person = person;
	}

	public Cashier()
	{
		sessions = new ArrayList<Session>();
	}

	/**
	 * 
	 * @param number
	 * @param person
	 * @param password
	 */
	public Cashier(String number, Person person, String password)
	{
		this();
		setNumber(number);
		setPerson(person);
		setPassword(password);
	}

	/**
	 * Starts a session under the cashiers info
	 * @param session
	 */
	public void addSession(Session session)
	{
		sessions.add(session);
	}

	/**
	 * Removes a previous session
	 * @param session
	 */
	public void removeSession(Session session)
	{
		// TODO - implement Cashier.removeSession
		throw new UnsupportedOperationException();
	}

	/**
	 * Checks if the cashier is allowed to use the register
	 * @param password
	 */
	public boolean isAuthorized(String password)
	{
		// TODO - implement Cashier.isAuthorized
		throw new UnsupportedOperationException();
	}

	public String toString()
	{
		return (this.number + " " + this.person.getName());
	}

}