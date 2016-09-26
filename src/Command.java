
public class Command {
	private Catalog cat;
	
	public Command(Catalog _cat){
		cat = _cat;
		
	}
	
	public void execute(String command){
		String[] commandParts = command.split(" ");
		System.out.println(commandParts[0]);
		String[] mainCommandPart = commandParts[0].split(":");
		
	}
	
}
