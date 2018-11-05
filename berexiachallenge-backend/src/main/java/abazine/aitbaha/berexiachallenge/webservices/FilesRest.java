package abazine.aitbaha.berexiachallenge.webservices;


import abazine.aitbaha.berexiachallenge.files.FileHelper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.util.LinkedList;
import java.util.List;

@RestController
public class FilesRest {

    @Value("${filesdir:/Users/mac/IdeaProjects/berexiachallenge/uploadedfiles}")
    private String FILES_DIR  ;

    @GetMapping("/files")
    public List<String> getFiles() {
        return FileHelper.listFilesInFolder(FILES_DIR);
    }

    @GetMapping("/fileheader/{filename}")
    public List<String> getFileHeader(@PathVariable String filename){
        return FileHelper.getFileHeader(FILES_DIR+File.separator+filename);
    }


}
