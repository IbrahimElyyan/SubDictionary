// -----------------------------------------------------
// Part: (2)
// -----------------------------------------------------

import java.util.NoSuchElementException;
/**
 * This is the operations class for the cell phone objects, it is a linked list class from scratch
 * @author ibrahim_elyyan
 *
 */
public class CellList {

	private CellNode head;
	private int size;
	/**
	 * constructor that initializes variables
	 */
	public CellList() {
		head = null;
		size = 0;
		CellList list = null;
	}
	/**
	 * Parameterized constructor that initializes variables accordingly
	 * @param list
	 */
	public CellList(CellList list) {
		this.head = list.head;
		this.size = list.size;
	}
	/**
	 * method that adds not to the beginning of the linked list
	 * @param cell is a cell phone object
	 * @return cell
	 */
	public CellPhone addToStart(CellPhone cell) {
		if(head==null) {
			CellNode n = new CellNode(cell, null);
			head = n;
			size++;
			return cell;
		} else {
			CellNode n = new CellNode(cell, head);
			head = n;
			size++;
			return cell;
		}
	}
	/**
	 * Inserts a node at the specified index
	 * @param cell
	 * @param index the place in the linked list
	 */
	public void insertAtIndex(CellPhone cell, Integer index) {
		try {
			if (index>size || index<0) {
				throw new NoSuchElementException();
			}
		} catch (NoSuchElementException e) {
			System.out.println(e);
			System.exit(0);
		}
		CellNode node = new CellNode(cell, null);
		if(index==0) {
			addToStart(cell);
		} else {
			CellNode n = head;
			for(int i=0; i<index-1; i++) {
				n = n.pointer;
			}
			node.pointer = n.pointer;
			n.pointer = node;
		}
		size++;
	}
	/**
	 * Method to delete a node from a specified index
	 * @param index
	 */
	public void deleteFromIndex(int index) {
		try {
			if (index>=size || index<0) {
				throw new NoSuchElementException();
			}
		} catch (NoSuchElementException e) {
			System.out.println(e);
			System.exit(0);
		}
		if(index==0) {
			head = head.pointer;
		} else {
			CellNode n = head;
			CellNode n1 = null;
			for(int i=0;i<index-1;i++)
			{
				n = n.pointer;
			}
			n1 = n.pointer;
			n.pointer = n1.pointer;
			n1 = null;
		}
		size--;
	} 
	/**
	 * Method deletes head node
	 * @return
	 */
	public CellNode deleteFromStart() {
		if (head == null)
			return null;
		head = head.pointer;
		size--;
		return head;
	}
	/**
	 * Method replaces node at specified index
	 * @param cell
	 * @param index
	 */
	public void replaceAtIndex(CellPhone cell, Integer index) {
		insertAtIndex(cell, index);
		deleteFromIndex(index+1);
	}
	/**
	 * Method finds a node based on specified serial number
	 * @param serial_number is unique identification number
	 * @return 
	 */
	public CellNode find(long serial_number) {
		CellNode n = head;
		for(int i=0; i<size; i++) {
			if(n.getCell().getSerialNum()==serial_number) {
				System.out.println("FOUND, Number of iterations: " + i);
				System.out.println(n.getCell());
				return n.pointer;
			} else {
				n=n.pointer;
			}
		}
		System.out.println("NOT FOUND, number of iterations: " + size);
		return null;
	}
	/**
	 * Checks if node exists in linked list
	 * @param serial_number
	 * @return true or false
	 */
	public boolean contains(long serial_number) {
		CellNode n = head;
		for(int i=0; i<size; i++) {
			if(n.getCell().getSerialNum()==serial_number) {
				return true;
			} else {
				n=n.pointer;
			}
		}
		return false;
	}
	/**
	 * Displays the contents of the linked list
	 */
	public void showContents() {
		System.out.println("The size of the list is " + size + ". Here are the records of the list:");
		System.out.println("=======================================================================");
		CellNode n = head;
		int count = 0;
		for(int i=0; i<size; i++) {
			if(n==null) {
				continue;
			}

			System.out.print(n.getCell() + "--->");
			n=n.pointer;
			count++;

			if(count==3) {
				count = 0;
				System.out.println();
			}
		}
		System.out.println(" X");
		System.out.println();
	}
	/**
	 * Equals method to check if two linked lists are equal
	 * @param list
	 * @return true/false
	 */
	public boolean equals(CellList list) {
		if(this.head==list.head && this.size==list.size) {
			return true;
		}
		return false;
	}

	/**
	 * @return the head
	 */
	public CellNode getHead() {
		return head;
	}
	/**
	 * @param head the head to set
	 */
	public void setHead(CellNode head) {
		this.head = head;
	}
	/**
	 * @return the size
	 */
	public int getSize() {
		return size;
	}
	/**
	 * @param size the size to set
	 */
	public void setSize(int size) {
		this.size = size;
	}

	class CellNode {
		CellPhone cell;
		CellNode pointer;
		public CellNode() {
			cell = null;
			pointer = null;
		}
		/**
		 * @param cell
		 * @param pointer
		 */
		public CellNode(CellPhone cell, CellNode pointer) {
			this.cell = cell;
			this.pointer = pointer;
		}
		/**
		 * 
		 * @param cn
		 */
		public CellNode(CellNode cn) {
			this.cell = cn.cell;
			this.pointer = cn.pointer;
		}
		public Object clone(CellNode cn) {  
			CellNode node = new CellNode(cn);
			return node;
		}  

		/**
		 * @return the cell
		 */
		public CellPhone getCell() {
			return cell;
		}
		/**
		 * @param cell the cell to set
		 */
		public void setCell(CellPhone cell) {
			this.cell = cell;
		}
		/**
		 * @return the pointer
		 */
		public CellNode getPointer() {
			return pointer;
		}
		/**
		 * @param pointer the pointer to set
		 */
		public void setPointer(CellNode pointer) {
			this.pointer = pointer;
		}

	}
}
