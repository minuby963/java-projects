import java.io.IOException;
import java.util.Scanner;
public class FileCommander {
	public static final String MAIN_PATH = "C:/"; 
	
	public static void main(String[] args) throws InterruptedException, IOException {
		
		Catalog[] dir = new Catalog[20]; 
		
		int depth=0;
		/*
		while(dir[depth].getPath().equals(MAIN_PATH)){
			depth++;
			dir[depth] = new Catalog(dir[depth-1].getPath()+"/"+command);
		}*/
		dir[depth] = new Catalog(MAIN_PATH);
		dir[depth].showCatalogs();
		Scanner readCommand = new Scanner(System.in);
		
		while(readCommand.hasNextLine()){
			
			String command = readCommand.nextLine();
			System.out.println(command);
			if(command.equals("..")){
				depth--;
				System.out.println(depth);
			}
			else{
				depth++;
				dir[depth] = new Catalog(dir[depth-1].getPath()+"/"+command);
			}
			
			
			dir[depth].showCatalogs();

			//dir[depth].showFiles();
		}
		readCommand.close();
	}

}
