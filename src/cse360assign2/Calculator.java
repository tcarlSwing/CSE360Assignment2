/**
 * Author: Thomas Duke
 * Class ID: 367
 * Assignment #: 2
 * 
 * Implements a Calculator class to perform basic operations
 * and retrieve operation history.
 */
package cse360assign2;

/**
 * Defines the Calculator class.
 * Calculator operations include: add, subtract, multiply, divide.
 * Additional functions: getTotal and getHistory.
 */
public class Calculator {

	private int total;
	
	/**
	 * Constructor for the Calculator class.
	 * Performs all necessary initialization.
	 */
	public Calculator () {
		total = 0;  // not needed - included for clarity
	}
	
	/**
	 * Returns the total value computed by the calculator.
	 * @return The total value.
	 */
	public int getTotal () {
		return total;
	}
	
	/**
	 * Adds value to this object's total.
	 * @param value The value to add
	 */
	public void add (int value) {
		total += value;
	}
	
	/**
	 * Subtracts value from this object's total.
	 * @param value The value to subtract
	 */
	public void subtract (int value) {
		total -= value;
	}
	
	/**
	 * Multiplies value to this object's total.
	 * @param value The value to multiply
	 */
	public void multiply (int value) {
		total *= value;
	}
	
	/**
	 * Divides this object's total by value.
	 * @param value The value to divide total by
	 */
	public void divide (int value) {
		total = ( value == 0 ) ? 0 : total / value;
	}
	
	/**
	 * Retrieves and yields the command history for this object.
	 * @return This calculator's command history.
	 */
	public String getHistory () {
		return "";
	}
}
