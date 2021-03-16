/**
 *  Sergio Saraiva
 * 	111950948
 *      sergio.saraiva@stonybrook.edu
 *	CSE214 
 */

public class DirectoryTree {

	private DirectoryNode root, cursor;
	double leftCounter, middleCounter, rightCounter;
	
	/*
	 * Initializes a DirectoryTree object with a single DirectoryNode named "root".
	 * 
	 * Postconditions
	 * 	The tree contains a single DirectoryNode named "root", and both cursor and root reference this node.
	 */
	public DirectoryTree() {
		root = new DirectoryNode("root", false);
		cursor = root;
	}

	/*
	 * Moves the cursor to the root node of the tree.
	 * 
	 * Postconditions
	 * 	The cursor now references the root node of the tree.
	 */
	public void resetCursor() {
		cursor = root;
	}
	
	/*
	 * Moves the cursor to the directory with the name indicated by name.
	 * 
	 * Preconditions
	 * 	'name' references a valid directory ('name' cannot reference a file).
	 * 
	 * Postconditions
	 * 	The cursor now references the directory with the name indicated by name.
	 */
	public void changeDirectory(String name) {
		boolean foundDir = false;
		if(cursor.getLeft() != null) {
			if (cursor.getLeft().getName().equals(name) && cursor.getLeft().getIsFile() != true) {
				cursor = cursor.getLeft();
				foundDir = true;
			}
		}
		if(cursor.getMiddle() != null) {
			if (cursor.getMiddle().getName().equals(name) && cursor.getMiddle().getIsFile() != true) {
				cursor = cursor.getMiddle();
				foundDir = true;
			}
		}
		if(cursor.getRight() != null) {
			if (cursor.getRight().getName().equals(name) && cursor.getRight().getIsFile() != true) {
				cursor = cursor.getRight();
				foundDir = true;
			}
		}
		if(!foundDir) 
			System.out.println("ERROR: No such directory.");
	}
	
	/*
	 * Returns:
	 *  a String containing the path of directory names from the root node of the tree to the cursor,
	 * 	with each name separated by a forward slash "/".
	 * 
	 * Postconditions
	 * 	The cursor remains at the same DirectoryNode.
	 */
	public String presentWorkingDirectory() {
		String[] listOfParent = new String[10];
		DirectoryNode tempCursor = cursor;
		boolean hasParent = true;
		int count = 0;
		String str1 = "";
		
		if (cursor.getName().equals("root"))
			return cursor.getName() + "\n";
		else {
			str1 = tempCursor.getName();
			hasParent = tempCursor.hasParent();
			while(hasParent) {
				tempCursor = tempCursor.getParent();
				count++;
				listOfParent[count - 1] = tempCursor.getName();
				if(tempCursor.hasParent() == true) 
					hasParent = true;
				else 
					hasParent = false;
			}
			for(int i = count; i > 0; i--) 
				System.out.print(listOfParent[i - 1] + "/");
			
			listOfParent = new String[0];
			return str1 + "\n";
		}
	}
	
	/*
	 *  Returns  String containing a space-separated list of names of all the child directories or files of the cursor.
	 *  e.g. dev home bin if the cursor is at root in the example above.
	 *  
	 *  Postconditions
	 *   The cursor remains at the same DirectoryNode.
	 * 
	 *  Returns
	 *   A formatted String of DirectoryNode names.
	 */
	public String listDirectory() {
		String str1 = "", str2 = "", str3 = "";
		if(cursor.getLeft() != null) 
			str1 = cursor.getLeft().getName();
		if(cursor.getMiddle() != null) 
			str2 = cursor.getMiddle().getName();
		if(cursor.getRight() != null)
			str3 = cursor.getRight().getName();
		if(str1 == "" && str2 == "" && str3 == "")
			return "ERROR: There are nothing to list.\n";
		
		String list = str1 + " " + str2 + " " + str3;
		return list.trim() + "\n";
	}
	
	/*
	 * Prints a formatted nested list of names of all the nodes in the directory tree, starting from the cursor.
	 * 
	 * Postconditions:
	 *  The cursor remains at the same DirectoryNode.
	 */
	public void printDirectoryTree() {
		
	}
	
	/*
	 * Moves cursor up one node to cursor's parent.
	 * 
	 * Precondition
	 * 	Cursor must have a parent node
	 * 
	 * Postcondition
	 * 	Cursor is now pointing at parent node
	 */
	public void moveUpToParent() {
		if (cursor.hasParent())
			cursor = cursor.getParent();
		else
			System.out.print("ERROR: Already at root directory.\n");
	}
	
	/*
	 * Creates a directory with the indicated name and adds it to the children of the cursor node
	 * 
	 * Parameters:
	 *	name The name of the directory to add.
	 *
	 * Preconditions:
	 *	'name' is a legal argument (does not contain spaces " " or forward slashes "/").
	 *
	 * Postconditions:
	 *	A new DirectoryNode has been added to the children of the cursor, or an exception has been thrown.
	 */
	public void makeDirectory(String name) {
		DirectoryNode newNode;
		if (cursor == root) {
			if(cursor.getLeft() == null) {
				newNode = new DirectoryNode(name, false);
				newNode.setParent(cursor);
				cursor.addChild(newNode);
			}
			else if(cursor.getMiddle() == null) {
				newNode = new DirectoryNode(name, false);
				newNode.setParent(cursor);
				cursor.addChild(newNode);
			}
			else if(cursor.getRight() == null) {
				newNode = new DirectoryNode(name, false);
				newNode.setParent(cursor);
				cursor.addChild(newNode);
			}
			else
				System.out.print("ERROR: Present directory is full.\n");

		}
		else {
			if(cursor.getIsFile() != true && cursor.getLeft() == null) {
				newNode = new DirectoryNode(name, false);
				newNode.setParent(cursor);
				cursor.addChild(newNode);
			}
			else if(cursor.getIsFile() != true && cursor.getMiddle() == null) {
				newNode = new DirectoryNode(name, false);
				newNode.setParent(cursor);
				cursor.addChild(newNode);
			}
			else if(cursor.getIsFile() != true && cursor.getRight() == null) {
				newNode = new DirectoryNode(name, false);
				newNode.setParent(cursor);
				cursor.addChild(newNode);
			}
			else
				System.out.print("ERROR: Present directory is full.\n");
		}
	}
	
	/*
	 * Creates a file with the indicated name and adds it to the children of the cursor node
	 * 
	 * Parameters:
	 *	name The name of the file to add.
	 *
	 * Preconditions:
	 *	'name' is a legal argument (does not contain spaces " " or forward slashes "/").
	 *
	 * Postconditions:
	 *	A new DirectoryNode has been added to the children of the cursor, or an exception has been thrown.
	 */
	public void makeFile(String name) {
		DirectoryNode newNode;
		if(cursor.getIsFile() != true && cursor.getLeft() == null) {
			newNode = new DirectoryNode(name, true);
			newNode.setParent(cursor);
			cursor.addChild(newNode);
		}
		else if(cursor.getIsFile() != true && cursor.getMiddle() == null) {
			newNode = new DirectoryNode(name, true);
			newNode.setParent(cursor);
			cursor.addChild(newNode);
		}
		else if(cursor.getIsFile() != true && cursor.getRight() == null) {
			newNode = new DirectoryNode(name, true);
			newNode.setParent(cursor);
			cursor.addChild(newNode);
		}
		else {
			System.out.print("ERROR: Present directory is full.\n");
		}
	}
}
