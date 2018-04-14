package wz.study.utils.xlsx;

import jxl.Sheet;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

import java.io.File;

public class JxlUtils {

    public static void main(String[] args) {

        try {
            read();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void write() throws Exception {

        File xlsFile = new File("jxl.xls");
        WritableWorkbook workbook = Workbook.createWorkbook(xlsFile);
        WritableSheet sheet = workbook.createSheet("sheet1", 0);
        for (int row = 0; row < 10; row++)
        {
            for (int col = 0; col < 10; col++)
            {
                // 向工作表中添加数据
                sheet.addCell(new Label(col, row, "data" + row + col));
            }
        }
        workbook.write();
        workbook.close();
    }

    public static void read() throws Exception{
        File xlsFile = new File("/Users/wangzhe/Downloads/demo.xls");
        Workbook workbook = Workbook.getWorkbook(xlsFile);
        Sheet[] sheets = workbook.getSheets();
        if (sheets != null)
        {
            for (Sheet sheet : sheets)
            {
                int rows = sheet.getRows();
                int cols = sheet.getColumns();

                for (int row = 0; row < rows; row++)
                {
                    for (int col = 0; col < cols; col++)
                    {
                        System.out.printf("%10s", sheet.getCell(col, row).getContents());
                    }
                    System.out.println();
                }
            }
        }
        workbook.close();
    }
}
