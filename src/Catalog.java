import java.io.File;
import java.io.IOException;


public class Catalog {
	private File[] catList;
	private File[] fileList;
	private String path;
	
	public Catalog(String _path) throws IOException{
		
		path = _path;
		//System.out.println(path);
		File dir = new File(path);		
		try{	
			if( !dir.isDirectory() ){
				throw new IOException("File should be directory.");	
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
		catch(IOException e){
			System.out.println(e);
		}
			
	}
	
	public void showFiles(){
		if(fileList==null){
			
		}
		else{
			for(File file : fileList){
	            System.out.println(file.getName());
			}
		}
	}
	
	public void showCatalogs(){

		if(catList==null){
			
		}
		else{
			for(File cat : catList){
            	System.out.println("- "+cat.getName());
			}
		}
	}
	
	public String getPath(){
		return path;
	}
	
}
