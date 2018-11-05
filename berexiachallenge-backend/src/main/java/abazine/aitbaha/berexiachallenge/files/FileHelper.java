package abazine.aitbaha.berexiachallenge.files;

import java.io.File;
import java.util.LinkedList;
import java.util.List;

public class FileHelper {


    public static List<String> listFilesInFolder(String dir){
        File folder = new File(dir);
        File[] listOfFiles = folder.listFiles();
        List<String> listOfFilesNames= new LinkedList<>();

        for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].isFile()) {
                listOfFilesNames.add(listOfFiles[i].getName());
            }
        }

        return listOfFilesNames;
    }


    public static List<String> getFileHeader(String filepath){

        IFileReader reader = null;

        if(filepath.endsWith(".csv")){

            reader = new CSVFileReader(filepath);

        }else if (filepath.endsWith(".xlsx")){

            reader = new XlsxFileReader(filepath);
        }


        return reader.getHeader();
    }


}
