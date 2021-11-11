package comp125;

import static org.junit.Assert.*;

import org.junit.Test;

/*
 * Test class for BankAccount.
 * This is a set of methods each of which tests one of the methods
 * from the BankAccount class.
 * When you click on the run button, Eclipse/Java/Junit first creates a main
 * method "behind the scene" which calls all the test methods. 
 * Then Eclipse/Java/Junit runs this hidden main method.
 */
public class BankAccountTest {

	
	@Test
	public void testCreateEmpty() {
		// When we create a bank account, the balance should be zero
		
		BankAccount myAccount = new BankAccount();
		
		assertEquals(0.0, myAccount.getBalance(), 0.01);
	}
	
	@Test
	public void testDepositBalance() {
		// we can deposit money in the account and the balance is correct
		
		BankAccount myAccount = new BankAccount();
		myAccount.deposit(100);
		assertEquals(100, myAccount.getBalance(), 0.01);
		
		myAccount.deposit(20);
		assertEquals(120, myAccount.getBalance(), 0.01);
	}
	
	
	@Test 
	public void testWithdraw() {
		// we can withdraw money and the balance is correct
		
		BankAccount yourAccount = new BankAccount();
		yourAccount.deposit(100);
		assertEquals(100, yourAccount.getBalance(), 0.01);
		yourAccount.withdraw(20);
		assertEquals(80, yourAccount.getBalance(), 0.01);
		yourAccount.withdraw(12.3f);
		assertEquals(67.7, yourAccount.getBalance(), 0.01);
		
	}
	
	@Test
	public void testOverdrawn() {
		// if we spend too much, we go overdrawn
		
		BankAccount theirAccount = new BankAccount();
		
		theirAccount.deposit(100);
		
		assertEquals(false, theirAccount.overdrawn());
		
		theirAccount.withdraw(100.3f);
		
		assertEquals(true, theirAccount.overdrawn());
		
	}
	
}
