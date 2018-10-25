import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.File;
import java.io.FileOutputStream;

public class Excel {

    public void writeExcel() {

        try {

            XSSFWorkbook workbook = new XSSFWorkbook();
            XSSFSheet sheet = workbook.createSheet(" MALAYSIA TRIVIA ");

            int rowcount = 0;

            for(Info d : Scraper.ListAll()) {

                Row row = sheet.createRow(rowcount++);

                Cell c1 = row.createCell(0);
                c1.setCellValue(d.getCol1());

                Cell c2 = row.createCell(1);
                c2.setCellValue(d.getCol2());

                sheet.autoSizeColumn(0);
                sheet.autoSizeColumn(1);

            }

            FileOutputStream o = new FileOutputStream(new File("C:\\New folder\\Malaysia.xlsx"));
            //FileOutputStream o = new FileOutputStream(new File("Documents:\\Malaysia.xlsx"));
            workbook.write(o);
            workbook.close();
            System.out.println("\nMalaysia.xlsx successfully recorded");

        } catch (Exception e) {
            System.out.println("\nError to record Malaysia.xlsx");

        }
    }



}
