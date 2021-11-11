/**
 * A BankAccount class that manages the balance of an account
 */
package comp125;

/**
 * @author <type your name here>
 *
 */
public class BankAccount {

	// TODO You need to add the data variable (also known as instance variable)
	// that will store the account balance.
	
	/**
	 * Constructor that initializes the balance to zero.
	 * Actually Java provides this constructor by default,
	 * but it is better to include it explicitly in your class.
	 */
	BankAccount() {
		// TODO Auto-generated method stub
	}
	
	/**
	 * Return the balance of the account.
	 * @return the balance
	 */
	public double getBalance() {
		// TODO Auto-generated method stub
		return 0;  // You might want to change this statement.
	}

	/**
	 * Increase the balance by the amount specified.
	 * @param amount
	 */
	public void deposit(float amount) {
		// TODO Auto-generated method stub

	}

	/**
	 * Decrease the balance by the amount specified. It's OK if the resulting
	 * balance is negative (overdrawn).
	 * @param amount
	 */
	public void withdraw(float amount) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * Check if the balance is overdrawn.
	 * @return true if the balance is negative.
	 */
	public boolean overdrawn() {
		// TODO Auto-generated method stub
		return true;  // You might want to change this statement.
	}

}
