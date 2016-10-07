import java.util.Scanner;


public class FileCommander {

//	public static final String MAIN_PATH = "C:/Users/Daniel/Desktop"; 
	//public static final String MAIN_PATH = "C:/"; 
	
	public static void main(String[] args) throws InterruptedException, Exception {
		
		Catalog dir = new Catalog();//MAIN_PATH);
				
		Scanner readCommand = new Scanner(System.in);
		
		System.out.println(dir.getPath());
		dir.showCatalogs();

		
		boolean check = false;
		
		
		System.out.println("readCommand1: " + readCommand.hasNextLine());
		while(readCommand.hasNext()){		
						
			System.out.println("readCommand1: " + readCommand.hasNextLine());
			String sCommand;
			if(check){
				sCommand = readCommand.next();
			}
			else{
				sCommand = readCommand.nextLine();
				
			}
			if(sCommand.substring(0, 1).equals(":")){
				if(sCommand.substring(1).equals("exit")){
					break;
				}
				Command command = new Command(dir);
				try{
					command.execute(sCommand);
					System.out.println("exit");
					System.out.println("readCommand2: " + readCommand.hasNextLine());
					check=true;
					continue;
				}
				catch(Exception e){
					System.out.println(e);
					System.out.println(dir.getPath());
					dir.showCatalogs();
					continue;
				}
				//:exit --
				//:run program --
				//:show files --
				//:change name
				//:move file to path
				//:copy file to path

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
			}
//			System.out.println(dir.getPath());
//			dir.showCatalogs();

		}
		System.out.println("End of main while");
		readCommand.close();
	
	}

}
