// -----------------------------------------------------
// Part: (2)
// -----------------------------------------------------

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import java.util.Scanner;
/**
 * Contains main method, is the driver class that implements methods from CellList and CellPhone
 * @author ibrahim_elyyan
 *
 */
public class CellListUtilization implements Serializable {
	static CellPhone cell_phone[];

	public static void main(String[] args) {
		// Creating necessary variables to initiate the program
		long value;
		CellList list = new CellList();
		CellList list2 = new CellList();
		File file = new File("/Users/ibrahim_elyyan/Desktop/Cell_Info.txt");
		CellPhone[] cell_phone = new CellPhone[countFileLines("/Users/ibrahim_elyyan/Desktop/Cell_Info.txt")];
		Scanner sc = new Scanner(System.in);
		Scanner c = null;
		try {
			c = new Scanner(file);
		} catch (FileNotFoundException e) {
			System.out.println(e);;
		}
		// Reading from the file and making them into cell phone objects and putting them into an array
		for(int i=0; i<cell_phone.length;) {
			while(c.hasNextLine()) {
				long sNum = c.nextLong();
				String brand = c.next();
				double price = c.nextDouble();
				int year = c.nextInt();
				cell_phone[i] = new CellPhone(sNum,brand,year,price);
				i++;
			}
		}
		// checking for duplicate serial numbers
		for(int i=0; i<cell_phone.length; i++) {
			for(int j=0; j<cell_phone.length; j++) {
				if(cell_phone[i]==null || cell_phone[j]==null) {
					continue;
				}
				if(cell_phone[i].getSerialNum()==cell_phone[j].getSerialNum() && i!=j) {
					cell_phone[j]=null;
				}
			}
		}
		// Adding elements to linked list
		for(int i=0; i<cell_phone.length; i++) {
			if(cell_phone[i]==null) {
				continue;
			}
			list.addToStart(cell_phone[i]);
		}
		// User part
		System.out.println("This is list 1:");
		list.showContents();
		list2 = new CellList(list);
		System.out.println("This is list 2:");
		list2.showContents();
		System.out.println("Here are some implementations of certain methods: ");
		// try 9675654
		System.out.println();
		System.out.print("Please enter a serial number to find a specific phone? ");
		value = sc.nextLong();
		list.find(value);
		System.out.println();
		System.out.print("The linked list contains this item: " + list.contains(value));
		System.out.println();
		System.out.println();
		System.out.print("Enter the index of an item you want to delete: ");
		value = sc.nextLong();
		list.deleteFromIndex((int)value);
		System.out.println();
		System.out.print("Enter the index of an item you want to replace: ");
		CellPhone c1 = new CellPhone(111,"Xiaomi",2021,120);
		value = sc.nextLong();
		list.replaceAtIndex(c1, (int)value);
		System.out.println();
		System.out.print("Enter of where you want to add your item: ");
		CellPhone c2 = new CellPhone(22,"Poco",2019,100);
		value = sc.nextLong();
		list.insertAtIndex(c2, (int)value);
		list.showContents();
		System.out.println();
		CellPhone.clone(c2);
		System.out.println(c2);
		System.out.println("c1 and c2 equal: " + c2.equals(c1));
		
	}

	/**
	 * Counts the number of lines/records of the file
	 * @param fileName name of the file
	 * @return returns the number of lines/records of the file
	 */
	public static int countFileLines(String fileName) {

		int lines = 0;
		try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
			while (reader.readLine() != null) lines++;
		} catch (IOException e) {
			System.out.println(e);
		}
		return lines;
	}


}
