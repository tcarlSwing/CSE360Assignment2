/**
 * Author: Thomas Duke
 * Class ID: 367
 * Assignment #: 2
 * 
 * Implements a Calculator class to perform basic operations
 * and retrieve operation history.
 */
package cse360assign2;

import java.util.*; // Needed for Queue

/**
 * Defines the Calculator class.
 * Calculator operations include: add, subtract, multiply, divide.
 * Additional functions: getTotal and getHistory.
 */
public class Calculator {

	private int total;
	private Queue<String> history;
	private Queue<String> tmpHistory;
	
	/**
	 * Constructor for the Calculator class.
	 * Performs all necessary initialization.
	 */
	public Calculator () {
		total = 0;  // not needed - included for clarity
		
		// Initialize the history queues
		history = new LinkedList<String>();
		history.offer("0");
		tmpHistory = new LinkedList<String>();
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
		history.offer("+");
		history.offer(Integer.toString(value));
	}
	
	/**
	 * Subtracts value from this object's total.
	 * @param value The value to subtract
	 */
	public void subtract (int value) {
		total -= value;
		history.offer("-");
		history.offer(Integer.toString(value));
	}
	
	/**
	 * Multiplies value to this object's total.
	 * @param value The value to multiply
	 */
	public void multiply (int value) {
		total *= value;
		history.offer("*");
		history.offer(Integer.toString(value));
	}
	
	/**
	 * Divides this object's total by value.
	 * @param value The value to divide total by
	 */
	public void divide (int value) {
		total = ( value == 0 ) ? 0 : total / value;
		history.offer("/");
		history.offer(Integer.toString(value));
	}
	
	/**
	 * Retrieves and yields the command history for this object.
	 * This function saves the history for the lifetime of this
	 * object.
	 * @return This calculator's command history.
	 */
	public String getHistory () {
		String concatHistory = "";
		
		// Build the return string.
		String nextEntry = history.poll();
		tmpHistory.offer(nextEntry); // Save the history onto our temp queue.
		while(nextEntry != null)
		{
			concatHistory += " ";
			concatHistory += nextEntry;
			
			concatHistory += " ";
			nextEntry = history.poll();
			tmpHistory.offer(nextEntry); // Save the history onto our temp queue.
		}
		
		// Restore the history we cleared when building the return string.
		String tmpEntry = tmpHistory.poll();
		while(tmpEntry != null)
		{
			history.offer(tmpEntry);
			tmpEntry = tmpHistory.poll();
		}
		
		return concatHistory;
	}
}
