import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Command {
	private Catalog dir;
	
	public Command(Catalog _dir){
		dir=_dir;
	}
	
	public void execute(String command) throws Exception{
		String[] commandParts = command.split(" ");
		String mainCommand = commandParts[0].substring(1);
		
		switch(mainCommand.toLowerCase()){
			case "show":
				this.show(commandParts[1]);
				break;
			case "runprogram": 
				this.runProgram(commandParts[1]);
				break;
			case "run-program": 
				this.runProgram(commandParts[1]);
				break;
			case "rename": 
				this.rename(commandParts[1]);
				break;
			default:
				
				throw new Exception("Unrecognized command: "+mainCommand);		
		}
	}
	
	public void show(String name) throws Exception{
		if(name.equals("files")){
			dir.showFiles();
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
		
		// File (or directory) with old name
		File file = new File(path);
		if (file.exists()){
			Scanner readCommand = new Scanner(System.in);
			
			while(readCommand.hasNextLine()){
				
				String newName = readCommand.nextLine();
				File newFile = new File(newName);
				if(newFile.exists()){
					System.out.println("File: "+newName+" alredy exists.");
					continue;
				}
				else{
					
					readCommand.close();
					boolean success = file.renameTo(newFile);
					if (!success) {
					   throw new Exception("File can not be renamed.");
					}
					break;
				}
			}
		}
		else{
			throw new Exception("File do not exists.");
		}

		
	
	}

}
