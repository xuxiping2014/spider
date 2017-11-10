package com.xinyunlian.spider.utils;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class ReadExcelUtils {
    public static final String OFFICE_EXCEL_2003_POSTFIX = "xls";
    public static final String OFFICE_EXCEL_2010_POSTFIX = "xlsx";

    public static final String EMPTY = "";
    public static final String POINT = ".";
    public static final String NOT_EXCEL_FILE = " : Not the Excel file!";
    public static final String PROCESSING = "Processing...";
    /**
     * read the Excel file
     * @param path the path of the Excel file
     * @return
     * @throws IOException
     */
    public <T> List<T> readExcel(Class<T> clazz,String path) throws Exception {
        if (path == null || EMPTY.equals(path)) {
            return null;
        } else {
            String postfix = getPostfix(path);
            if (!EMPTY.equals(postfix)) {
                if (OFFICE_EXCEL_2003_POSTFIX.equals(postfix)) {
                    return readXls(clazz,path);
                } else if (OFFICE_EXCEL_2010_POSTFIX.equals(postfix)) {
                    return readXlsx(clazz,path);
                }
            } else {
                System.out.println(path + NOT_EXCEL_FILE);
            }
        }
        return null;
    }

    /**
     * Read the Excel 2010
     * @param path the path of the excel file
     * @return
     * @throws IOException
     */
    public <T> List<T> readXlsx(Class<T> clazz,String path) throws Exception {
        System.out.println(PROCESSING + path);
        InputStream is = new FileInputStream(path);
        XSSFWorkbook xssfWorkbook = new XSSFWorkbook(is);
        //GoodsInfoDto student = null;
        List<T> list = new ArrayList<T>();
        // Read the Sheet
        // for (int numSheet = 0; numSheet < xssfWorkbook.getNumberOfSheets(); numSheet++) {
        XSSFSheet xssfSheet = xssfWorkbook.getSheetAt(0);
        if (xssfSheet == null) {
            return list;
        }
        int rowLength = clazz.getDeclaredFields().length;
        // Read the Row
        for (int rowNum = 1; rowNum <= xssfSheet.getLastRowNum(); rowNum++) {
            XSSFRow xssfRow = xssfSheet.getRow(rowNum);
            if (xssfRow != null) {
                List<String> valueLst = new ArrayList<>();
                T entity =clazz.newInstance();
                for(int colsNum=0;colsNum<rowLength;colsNum++)
                {
                    XSSFCell cell=xssfRow.getCell(colsNum);
                    String cellValue= "";
                    if(cell!=null)
                    {
                        cell.setCellType(HSSFCell.CELL_TYPE_STRING);
                        cellValue =getValue(cell==null?null:cell);
                    }
                    valueLst.add(cellValue);
                }
                BeanRefUtil.setFieldValueByOrder(entity,valueLst);
//
//                XSSFCell no = xssfRow.getCell(0);
//                XSSFCell name = xssfRow.getCell(1);
//                XSSFCell age = xssfRow.getCell(2);
//                XSSFCell score = xssfRow.getCell(3);
//                student.setNo(getValue(no));
//                student.setName(getValue(name));
//                student.setAge(getValue(age));
//                student.setScore(Float.valueOf(getValue(score)));
                list.add(entity);
            }
        }
        //}
        return list;
    }

    /**
     * Read the Excel 2003-2007
     * @param path the path of the Excel
     * @return
     * @throws IOException
     */
    public <T> List<T> readXls(Class<T> clazz,String path) throws Exception {
        InputStream is = new FileInputStream(path);
        HSSFWorkbook hssfWorkbook = new HSSFWorkbook(is);
        List<T> list = new ArrayList<T>();
        // Read the Sheet
        //for (int numSheet = 0; numSheet < hssfWorkbook.getNumberOfSheets(); numSheet++) {
            HSSFSheet hssfSheet = hssfWorkbook.getSheetAt(0);
            if (hssfSheet == null) {
               return list;
            }
            int rowLength = clazz.getDeclaredFields().length;
            // Read the Row
            for (int rowNum = 1; rowNum <= hssfSheet.getLastRowNum(); rowNum++) {
                HSSFRow hssfRow = hssfSheet.getRow(rowNum);
                List<String> valueLst = new ArrayList<>();
                T entity =clazz.newInstance();
                for(int colsNum=0;colsNum<rowLength;colsNum++)
                {
                    HSSFCell cell=hssfRow.getCell(colsNum);
                    String cellValue= "";
                    if(cell!=null)
                    {
                        cell.setCellType(HSSFCell.CELL_TYPE_STRING);
                        cellValue =getValue(cell==null?null:cell);
                    }
                    valueLst.add(cellValue);
                }
                BeanRefUtil.setFieldValueByOrder(entity,valueLst);
//                if (hssfRow != null) {
//                    student = new GoodsInfoDto();
//                    HSSFCell no = hssfRow.getCell(0);
//                    HSSFCell name = hssfRow.getCell(1);
//                    HSSFCell age = hssfRow.getCell(2);
//                    HSSFCell score = hssfRow.getCell(3);
//                    student.setNo(getValue(no));
//                    student.setName(getValue(name));
//                    student.setAge(getValue(age));
//                    student.setScore(Float.valueOf(getValue(score)));
//                    list.add(student);
//                }
                list.add(entity);
            }
        //}
        return list;
    }

    @SuppressWarnings("static-access")
    private String getValue(XSSFCell xssfRow) {
        if(xssfRow==null)
            return "";
        if (xssfRow.getCellType() == xssfRow.CELL_TYPE_BOOLEAN) {
            return String.valueOf(xssfRow.getBooleanCellValue());
        } else if (xssfRow.getCellType() == xssfRow.CELL_TYPE_NUMERIC) {
            return String.valueOf(xssfRow.getNumericCellValue());
        } else {
            return String.valueOf(xssfRow.getStringCellValue());
        }
    }

    @SuppressWarnings("static-access")
    private String getValue(HSSFCell hssfCell) {
        if(hssfCell==null)
            return "";
        if (hssfCell.getCellType() == hssfCell.CELL_TYPE_BOOLEAN) {
            return String.valueOf(hssfCell.getBooleanCellValue());
        } else if (hssfCell.getCellType() == hssfCell.CELL_TYPE_NUMERIC) {
            return String.valueOf(hssfCell.getNumericCellValue());
        } else {
            return String.valueOf(hssfCell.getStringCellValue());
        }
    }
    /**
     * get postfix of the path
     * @param path
     * @return
     */
    public static String getPostfix(String path) {
        if (path == null || EMPTY.equals(path.trim())) {
            return EMPTY;
        }
        if (path.contains(POINT)) {
            return path.substring(path.lastIndexOf(POINT) + 1, path.length());
        }
        return EMPTY;
    }
}
