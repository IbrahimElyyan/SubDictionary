// -----------------------------------------------------
// Part: (2)
// -----------------------------------------------------

import java.util.Scanner;
/**
 * This is the class that its object  will be in the linked list
 * @author ibrahim_elyyan
 *
 */
public class CellPhone {
	long serialNum;
	String brand;
	int year;
	double price;
	/**
	 * constructor that initializes variables
	 */
	public CellPhone() {
		this.serialNum = 0;
		this.brand = null;
		this.year = 0;
		this.price = 0;
	}
	
	/**
	 * @param serialNum
	 * @param brand
	 * @param year
	 * @param price
	 */
	public CellPhone(long serialNum, String brand, int year, double price) {
		super();
		this.serialNum = serialNum;
		this.brand = brand;
		this.year = year;
		this.price = price;
	}
	/**
	 * Copy constructor
	 * @param cell
	 * @param value
	 */
	public CellPhone(CellPhone cell, long value) {
		this.serialNum = value;
		this.brand = cell.brand;
		this.year = cell.year;
		this.price = cell.price;
	}
	/**
	 * Clone method
	 * @param cell
	 * @return
	 */
	public static CellPhone clone(CellPhone cell) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Please enter new serial number for copy: ");
		CellPhone duplicate = new CellPhone(cell, sc.nextLong());
		System.out.println(duplicate);
		sc.close();
		return duplicate;
	}
	/**
	 * @return the serialNum
	 */
	public long getSerialNum() {
		return serialNum;
	}
	/**
	 * @param serialNum the serialNum to set
	 */
	public void setSerialNum(long serialNum) {
		this.serialNum = serialNum;
	}
	/**
	 * @return the brand
	 */
	public String getBrand() {
		return brand;
	}
	/**
	 * @param brand the brand to set
	 */
	public void setBrand(String brand) {
		this.brand = brand;
	}
	/**
	 * @return the year
	 */
	public int getYear() {
		return year;
	}
	/**
	 * @param year the year to set
	 */
	public void setYear(int year) {
		this.year = year;
	}
	/**
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}
	/**
	 * @param price the price to set
	 */
	public void setPrice(double price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		return "[" + serialNum + ": " + brand + " " + price + "$ " + year + "]";
	}
	/**
	 * Equals method to test of two cell phone objects are equal
	 * @param cell
	 * @return
	 */
	public boolean equals(CellPhone cell) {
		if(this.getBrand()==cell.getBrand() && this.getPrice()==cell.getPrice() && this.getYear()==cell.getYear()) {
			return true;
		} else return false;
	}
	
	
}
