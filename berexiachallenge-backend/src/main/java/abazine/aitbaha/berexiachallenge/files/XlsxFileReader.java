package abazine.aitbaha.berexiachallenge.files;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class XlsxFileReader implements IFileReader{

    private String filepath;


    @Override
    public List<String> getHeader() {
        return this.readHeader();
    }


    private List<String> readHeader(){
        List<String> columns = new LinkedList<>();
        try (
                XSSFWorkbook workbook = new XSSFWorkbook(new FileInputStream(new File(filepath)));
                ){

            XSSFSheet sheet = workbook.getSheetAt(0);

            Iterator<Row> rowIt = sheet.iterator();

            if(rowIt.hasNext()){
                Row row = rowIt.next();


                Iterator<Cell> cellIterator = row.cellIterator();

                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();
                    columns.add(cell.toString());
                }


            }




        }catch (Exception e) {
            e.printStackTrace();
        }
        return columns;
    }
}
