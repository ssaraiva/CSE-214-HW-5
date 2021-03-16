/**
 *  Sergio Saraiva
 * 	111950948
 *      sergio.saraiva@stonybrook.edu
 *	CSE214 
 */
import java.util.Scanner;

public class BashTerminal {

	public static void main(String[] args) {
		DirectoryTree root = new DirectoryTree();
		Scanner input = new Scanner(System.in);
		String temp = null;
		boolean cont = true;
		String command;
		String[] splitCommand = null;
		System.out.println("Starting bash terminal.");
		
		while(cont) {
			System.out.print("[111950948@host]: $ ");
			command = input.nextLine();
			if(command.contains(" ")) { 
				splitCommand = command.split(" ");
				temp = splitCommand[0];
				if(splitCommand[1].contains("/") || splitCommand[1].contains("..") || splitCommand[1].contains("-R")) {
					temp = command;
				}
			}
			else 
				temp = command;
			
			switch(temp) {
			case "pwd":
				System.out.print(root.presentWorkingDirectory());
				cont = true;
				break;
			case "ls":
				System.out.print(root.listDirectory());
				cont = true;
				break;
			case "ls -R":
				root.printDirectoryTree();
				cont = true;
				break;
			case "cd":
				root.changeDirectory(splitCommand[1]);
				cont = true;
				splitCommand = null;
				break;
			case "cd /":
				root.resetCursor();
				cont = true;
				break;
			case "mkdir":
				root.makeDirectory(splitCommand[1]);
				cont = true;
				splitCommand = null;
				break;
			case "touch":
				root.makeFile(splitCommand[1]);
				cont = true;
				splitCommand = null;
				break;
			case "cd ..":
				root.moveUpToParent();
				cont = true;
				break;
			case "exit":
				cont = false;
				System.out.println("Program terminating normally");
				break;
			
			}
		}
		

	}

}
