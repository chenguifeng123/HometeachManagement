package com.hometeach.excel;

import com.hometeach.util.Utils;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddressList;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public abstract class BasicExcelHelper implements ExcelHelper{

    protected abstract Workbook getBook(InputStream fis) throws Exception;
    protected abstract Workbook getBook() throws Exception;
    protected abstract DataValidation getValidation4Range(Sheet sheet, CellRangeAddressList ranges, String[] validationList);
    protected abstract DataValidation getValidation4Formula(Sheet sheet, CellRangeAddressList ranges, String strFormula);
    protected abstract short getDataFormat(Workbook book, String formatDetail);

    public static final byte[] XLS_MAGIC = new byte[]{(byte)0xD0,(byte)0xCF,(byte)0x11,(byte)0xE0};
    public static final byte[] XLSX_MAGIC = new byte[]{(byte)0x50,(byte)0x4B,(byte)0x03,(byte)0x04};

    public static ExcelHelper getRealHelper(String fullName){
        return fullName.matches("^.*\\.xlsx$") ?  new XlsxExcelHelper() : new XlsExcelHelper();
    }

    // 根据名称读取XML内容,返回json字符串
    public String readExcel(String fullPathName)throws Exception{
        InputStream fis = null;
        Map<String, List<List<String>>> excelContent = new HashMap();
        try {
            fis = new FileInputStream(fullPathName);
            Workbook book = getBook(fis);
            for (int sheetIndex = 0; sheetIndex < book.getNumberOfSheets(); sheetIndex++) {
                List<List<String>> content = new ArrayList();
                Sheet sheet = book.getSheetAt(sheetIndex);
                for (int rowIndex = 0; rowIndex < sheet.getPhysicalNumberOfRows(); rowIndex++) {
                    List<String> rowLst = new ArrayList<String>();
                    Row row = sheet.getRow(rowIndex);
                    for (int colIndex = 0; colIndex < row.getPhysicalNumberOfCells(); colIndex++) {
                        Cell cell = row.getCell(colIndex);
                        rowLst.add( cell == null ? "" : Utils.convertCell2StringValue(cell));
                    }
                    content.add(rowLst);
                }
                excelContent.put(sheet.getSheetName(), content);
            }
        } finally {
            try {
               if(fis != null) fis.close();
            } catch (Exception e) {}
        }
        return "";
        //return RdkUtil.toJsonString(excelContent);
    }


}
