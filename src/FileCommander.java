import java.util.Scanner;


public class FileCommander {

	public static final String MAIN_PATH = "C:/Users/Daniel/Desktop"; 
	//public static final String MAIN_PATH = "C:/"; 
	
	public static void main(String[] args) throws InterruptedException, Exception {
		
		Catalog dir = new Catalog(MAIN_PATH);
		
		dir.hasParent();
		
		Scanner readCommand = new Scanner(System.in);
		System.out.println(dir.getPath());
		dir.showCatalogs();
		
		while(readCommand.hasNextLine()){
			
			String sCommand = readCommand.nextLine();
			
			if(sCommand.substring(0, 1).equals(":")){
				Command command = new Command(dir);
				command.execute(sCommand);
				//:run file 
				//:show files
				//:move file to path
				//:copy file to path
				//:change name
				//:select from A to B 
				//:order by

				//command.run(File f);
				//command.show(String name);
				//command.move(File/Files f, String path)
				//command.copy(File/Files f, String path)
				//command.changeName(File f, string newName)
			}
			else{
				try{
					dir.checkAndChangeCatalog(sCommand);
				}
				catch(Exception e){
					System.out.println(e);
					System.out.println(dir.getPath());
					dir.showCatalogs();
					continue;
				}
				
				System.out.println(dir.getPath());
				dir.showCatalogs();
			}

			//dir[depth].showFiles();
		}
		readCommand.close();
		
		/*String[] pathParts= MAIN_PATH.split("/");
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
		System.out.println(dir[depth].getPath());
		dir[depth].showCatalogs();
		
		while(readCommand.hasNextLine()){
			
			String command = readCommand.nextLine();
			
			if(command.substring(0, 1).equals(":")){
				
					
			}
			else{
				if(command.equals(".")){
					if(depth>0){
						depth--;
						//System.out.println(depth);
					}
				}
				if(command.equals("..")){
					if(depth>0){
						depth--;
						//System.out.println(depth);
					}
				}
				else{
					
					try{
						dir[depth+1] = new Catalog(dir[depth].getPath()+command+"/");
					}
					catch(IOException e){
						System.out.println(e);
						System.out.println(dir[depth].getPath());
						dir[depth].showCatalogs();
						continue;
					}
					depth++;
				}
				
				System.out.println(dir[depth].getPath());
				dir[depth].showCatalogs();
			}

			//dir[depth].showFiles();
		}
		readCommand.close();*/
	}

}
