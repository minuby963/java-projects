import java.io.File;

public class Catalog {

	public static final String MAIN_PATH = "C:/Users/Daniel/Desktop";
	
	private File[] catList;
	private File[] fileList;
	private String path;
	
	public Catalog(String _path) throws Exception{
		changeCatalog(_path);
	}
	public void checkAndChangeCatalog(String command) throws Exception{
		if(command.equals(".")){
			changeCatalog(MAIN_PATH);	
		}
		else if(command.equals("..")){
			changeToParent();
		}
		else{
			String newPath;
			if(hasParent()){
				newPath = getPath()+"/"+command;
			}
			else{
				newPath = getPath()+command;
			}
				
			changeCatalog(newPath);
			
		}
	}
	
	public void changeCatalog(String _path) throws Exception{
		path = _path;
		//System.out.println(path);
		File dir = new File(path);		
		if( !dir.isDirectory() ){
			throw new Exception("File should be directory.");	
		}
		else{
			int i=0;
			int j=0;
			for(File f : dir.listFiles()){
				if(f.isDirectory())
					i++;
				else
					j++;
			}
				
			if(i>0)
				catList = new File[i];
			if(j>0)
				fileList = new File[j];

			//System.out.println("i: "+i+", j: "+j);
			i=0;
			j=0;
			for(File f : dir.listFiles()){
				if(f.isDirectory()){
					catList[i] = f;
					i++;
				}
				else{
					fileList[j] = f;
					j++;
				}
			}		
		}			
	}
	
	public void showFiles(){
		if(fileList!=null){
			for(File file : fileList){
	            System.out.println(file.getName());
			}
		}
	}
	
	public void showCatalogs(){
		if(catList!=null){
			for(File cat : catList){
            	System.out.println("- "+cat.getName());
			}
		}
	}
	
	public String getPath(){
		return path;
	}
	public String getParentPath() throws Exception {
		if(!this.hasParent()){
			throw new Exception("Directory has not parent directory.");
		}
		
		
		String[] pathParts= path.split("/");
		String parentPath=pathParts[0]+"/";
		
		for(int i=1;i<pathParts.length-1;i++){

			if(i==1){
				parentPath = parentPath + pathParts[i];
			}
			else {
				parentPath = parentPath + "/" + pathParts[i];
			}

		}
		//System.out.print(parentPath);
		return parentPath;
	}
	public void changeToParent() throws Exception{
		
		changeCatalog(this.getParentPath());
		
	}
	public boolean hasParent(){
		String[] pathParts = path.split("/");
		if(pathParts.length == 1){
			return false;
		}
		else{
			return true;
		}
	}
	
}
