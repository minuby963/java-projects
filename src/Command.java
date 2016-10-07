import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Command {
	private Catalog dir;
	
	public Command(Catalog _dir) throws Exception{
		dir = new Catalog(_dir);
	}
	
	public void execute(String command) throws Exception{
		String[] commandParts = command.split(" ");
		String mainCommand = commandParts[0].substring(1);
		if(commandParts.length<=1){
			throw new Exception("Not enough arguments.");
		}
		String parameters = commandParts[1];
		for(int i=2;i<commandParts.length;i++){
			parameters = parameters + " " + commandParts[i];
		}
		
		switch(mainCommand.toLowerCase()){
			case "show":
				this.show(parameters);
				break;
			case "runprogram": 
				this.runProgram(parameters);
				break;
			case "run-program": 
				this.runProgram(parameters);
				System.out.println("ccc");
				break;
			case "rename": 
				this.rename(parameters);
				break;
			default:
				throw new Exception("Unrecognized command: "+mainCommand);		
		}
	}
	
	public void show(String name) throws Exception{
		if(name.toLowerCase().equals("files")){
			dir.showFiles();
		}
		else if(name.toLowerCase().equals("catalogs")){
			//dir.showCatalogs(); //   ---   IN MAIN   ---   //
		}
		else{
			throw new Exception(":show : Unrecognized name: "+name);
		}
	}
	
	public void runProgram(String name) throws IOException{
		String path = dir.getPath() + "/" + name;
		//System.out.println(path);
		Runtime.getRuntime().exec(path);
	}
	
	public void rename(String name) throws Exception{
		String path = dir.getPath() + "/" + name;
		System.out.println(path);
		
		File file = new File(path);
		if (file.exists()){
			Scanner readNewCommand = new Scanner(System.in);
			
			System.out.println("Enter new file name1:");
//			int i=0;
			while(readNewCommand.hasNextLine()){
				System.out.println("readNewCommand: " + readNewCommand.hasNextLine());
				
//				i++;
				String newName = readNewCommand.nextLine();
				
				File newFile = new File(dir.getPath() + "/" + newName);
				if(newFile.exists()){
					System.out.println("File: "+newName+" alredy exists.");
					System.out.println("Enter new file name:");
					continue;
				}
				else{
					
					readNewCommand.close();
					System.out.println("readNewCommand closed");
					boolean success = file.renameTo(newFile);
					if (!success) {
					   throw new Exception("File can not be renamed.");
					}
					break;
				}
			}
			System.out.println("end of while");
		}
		else{
			throw new Exception("File do not exists.");
		}

		
	
	}

}
