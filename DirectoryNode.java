/**
 *  Sergio Saraiva
 * 	111950948
 *      sergio.saraiva@stonybrook.edu
 *	CSE214 
 */

public class DirectoryNode {

	String name;
	boolean isFile;
	DirectoryNode parent, left, middle, right;
	
	/*
	 * Intializes DirectoryNode using name and isFile parameters.
	 */
	public DirectoryNode(String name, boolean isFile) {
		this.name = name;
		this.parent = null;
		this.left = null;
		this.middle = null;
		this.right = null;
		this.isFile = isFile;
	}
	
	/*
	 * Adds newChild to any of the open child positions of this node (left, middle, or right).
	 * 
	 * Preconditions:
	 * 	This node is not a file.
	 *	There is at least one empty position in the children of this node (left, middle, or right).
	 *
	 * Postconditions
	 * 	newChild has been added as a child of this node.
	 */
	public void addChild(DirectoryNode newChild) {
			if (this.left == null) 
				this.left = newChild;
			else if (this.middle == null) 
				this.middle = newChild;
			else if (this.right == null)
				this.right = newChild;
			else
				System.out.println("Full");
	}
	
	/*
	 * Checks whether the current node contains a parent node.
	 * 
	 * Returns:
	 * 	True if parent class exists, false otherwise
	 */
	public boolean hasParent() {
		if (this.parent != null)
			return true;
		else 
			return false;
	}
	
	/*
	 * Sets a parent node to cursor.
	 */
	public void setParent(DirectoryNode parent) {
		this.parent = parent;
	}

	/*
	 * Returns:
	 * 	Parent node of cursor.
	 */
	public DirectoryNode getParent() {
		return this.parent;
	}
	
	/*
	 * Returns:
	 * 	True is current node is a file, false otherwise.
	 */
	public boolean getIsFile() {
		return this.isFile;
	}
	
	/*
	 * Returns:
	 * 	Name of current node
	 */
	public String getName() {
		return this.name;
	}
	
	/*
	 * Sets the name of current node
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/*
	 * Returns:
	 * 	The left node of current node.
	 */
	public DirectoryNode getLeft() {
		return this.left;
	}
	
	/*
	 * Returns:
	 * 	Middle node of current node
	 */
	public DirectoryNode getMiddle() {
		return this.middle;
	}
	
	/*
	 * Returns:
	 * 	Right node of current node.
	 */
	public DirectoryNode getRight() {
		return this.right;
	}
	
	
}
