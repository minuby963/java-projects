import java.io.IOException;

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
		System.out.println(path);
		Runtime.getRuntime().exec(path);
	}

}
