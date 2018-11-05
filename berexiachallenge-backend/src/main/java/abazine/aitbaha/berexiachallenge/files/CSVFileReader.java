package abazine.aitbaha.berexiachallenge.files;

import com.opencsv.CSVReader;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CSVFileReader implements IFileReader{

    private String filepath;


    @Override
    public List<String> getHeader() {
        return Arrays.asList(this.readHeader());
    }



    private String[] readHeader(){
        String columns[] = null;
        try (
                CSVReader csvReader = new CSVReader(new InputStreamReader(new FileInputStream(filepath)),';')
        ){

            columns  = csvReader.readNext();


        }catch (Exception e) {
            e.printStackTrace();
        }

        return columns;
    }
}
