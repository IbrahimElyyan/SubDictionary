// -----------------------------------------------------
// Part: (1)
// -----------------------------------------------------


import java.util.ArrayList;
import java.util.Scanner;
import java.io.PrintWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
/**
 * This class takes any text file and outputs all the words in alphabetical order, words occur only once
 * @author ibrahim_elyyan
 *
 */
public class SubDictionary {

	public static void main(String[] args) {
		getWords("/Users/ibrahim_elyyan/Desktop/PersonOfTheCentury.txt");
	}
	/**
	 * This method does most of the work, it checks for duplicates and filters out all the special characters like ! and ? and then 
	 * outputs the result into a new file
	 * @param intput_fileame the name of the file
	 */
	public static void getWords(String intput_fileame) {
		// Creating a scanner to read the file
		Scanner myFile = null;
		File file = new File(intput_fileame);
		try {
			myFile = new Scanner(file);
		} catch (FileNotFoundException e) {
			System.out.println(e);;
		}
		ArrayList<String> words = new ArrayList<String>();
		// Adding the words to the filtering array list
		while(myFile.hasNext()) {
			words.add(myFile.next());
		}
		// Doing the required filtering
		for(int i=0; i<words.size(); i++) {
			words.set(i, words.get(i).replace(".", ""));
			words.set(i, words.get(i).replace("!", ""));
			words.set(i, words.get(i).replace(",", ""));
			words.set(i, words.get(i).replace(";", ""));
			words.set(i, words.get(i).replace(":", ""));
			words.set(i, words.get(i).replace("?", ""));
			words.set(i, words.get(i).replace("'s", ""));
			words.set(i, words.get(i).replace("'m", ""));
			words.set(i, words.get(i).toUpperCase());
		}
		for(int i=0; i<words.size(); i++) {
			if(words.get(i).contains("1")||words.get(i).contains("2")||words.get(i).contains("3")||words.get(i).contains("4")||words.get(i).contains("5")||words.get(i).contains("6")||words.get(i).contains("7")||words.get(i).contains("8")||words.get(i).contains("9")) {
				words.remove(i);
			} else if((words.get(i).length()<=1 && !words.get(i).equalsIgnoreCase("A") && !words.get(i).equalsIgnoreCase("I")) || words.get(i).contains("=")) {
				words.remove(i);
			} 
		}
		// Only adding unique words to final array list
		ArrayList<String> list= new ArrayList<String>();
		for (String duplicate : words) {
			if (!list.contains(duplicate)) {
				list.add(duplicate);
			}
		}
		sortArrayList(list);
		try {
			writeToFile(list);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * This method orders the words alphabetically
	 * @param ll is an array list
	 */
	public static void sortArrayList(ArrayList<String> ll) {
		for (int i=0; i<ll.size();i++) {
			for(int j=0;j<ll.size();j++) {
				if(ll.get(i).compareTo(ll.get(j))<0) {
					String temp = ll.get(i);
					ll.set(i, ll.get(j));
					ll.set(j, temp);
				}
			}
		}
	}
	/**
	 * this method writes an array list to a file
	 * @param ll
	 * @throws IOException
	 */
	public static void writeToFile(ArrayList<String> ll) throws IOException {
		File file1 = new File("SubDictionary.txt");
		FileOutputStream fo = new FileOutputStream(file1);
		PrintWriter pw = new PrintWriter(fo);

		String[] alphabet = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
		for(int i=0; i<alphabet.length;i++) {
			pw.println(alphabet[i]);
			pw.println("==");
			for(int j=0;j<ll.size();j++) {
				if(ll.get(j).startsWith(alphabet[i])) {
					pw.println(ll.get(j));
				}
			}
			pw.println();
		}
		pw.close();
		fo.close();
		displayFileContents(file1);
	}

	/**
	 * Displays the contents of the file
	 * @param file1 the file that will be displayed
	 * @return returns the contents of the file
	 * @throws FileNotFoundException
	 */
	public static File displayFileContents(File file1) throws FileNotFoundException {
		Scanner sc = new Scanner(file1);
		while(sc.hasNextLine()) {
			System.out.println(sc.nextLine());
		}
		sc.close();
		return file1;
	}
}
