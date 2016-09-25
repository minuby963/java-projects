import java.io.IOException;
import java.util.Scanner;
public class FileCommander {
	public static final String MAIN_PATH = "C:/Users/Daniel/Desktop/"; 
	
	public static void main(String[] args) throws InterruptedException, IOException {
		
		String[] pathParts= MAIN_PATH.split("/");
		Catalog[] dir = new Catalog[20]; 
		pathParts[0]=pathParts[0]+"/";
		int depth=0;
		dir[depth] = new Catalog(pathParts[depth]);
		while(!dir[depth].getPath().equals(MAIN_PATH)){
			depth++;
			String newPath = dir[depth-1].getPath()+pathParts[depth]+"/";
			//System.out.println(newPath);
			dir[depth] = new Catalog(newPath);
			
		}

		Scanner readCommand = new Scanner(System.in);
		
		while(readCommand.hasNextLine()){

			System.out.println(dir[depth].getPath());
			dir[depth].showCatalogs();
			
			String command = readCommand.nextLine();
			//System.out.println(command);
			if(command.equals("..")){
				if(depth<0){
					
				}
				else{
					depth--;
					//System.out.println(depth);
				}
			}
			else{
				depth++;
				dir[depth] = new Catalog(dir[depth-1].getPath()+"/"+command);
			}

			//dir[depth].showFiles();
		}
		readCommand.close();
	}

}
