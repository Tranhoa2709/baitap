/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.TableModel;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelExporter {
    
    // Hàm hỗ trợ export excel
    public static void exportToExcels(JTable table) throws IOException {
        TableModel model = table.getModel();
        JFileChooser excelFileChooser = new JFileChooser("C:\\Users\\trung\\Desktop");
        excelFileChooser.setDialogTitle("Save as");
        //filter the file
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Excel Files", "*.xls", "xls", "xlsx", "xlsn");
        excelFileChooser.addChoosableFileFilter(filter);
        excelFileChooser.setFileFilter(filter);
        int excelchooser = excelFileChooser.showSaveDialog(null);

        if (excelchooser == JFileChooser.APPROVE_OPTION) {
            Workbook workbook = new XSSFWorkbook();
            Sheet sheet = workbook.createSheet("J Table Sheet");

            Row row;
            Cell cell;

            try {
                // write the column headers
                row = sheet.createRow(0);
                for (int j = 0; j < model.getColumnCount(); j++) {
                    cell = row.createCell(j);
                    cell.setCellValue(model.getColumnName(j));
                }

                for (int i = 0; i < model.getRowCount(); i++) {

                    row = sheet.createRow(i + 1);

                    for (int j = 0; j < model.getColumnCount(); j++) {
                        cell = row.createCell(j);
                        cell.setCellValue(model.getValueAt(i, j).toString());

                    }

                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }

            FileOutputStream excelFIS;

            try {
                excelFIS = new FileOutputStream(excelFileChooser.getSelectedFile() + ".xlsx");
                workbook.write(excelFIS);

                workbook.close();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(NewWorker.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(NewWorker.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }
private static class NewWorker {

        public NewWorker() {
        }
    }

}
