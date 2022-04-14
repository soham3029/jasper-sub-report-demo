package com.example.subreport.util;

import com.example.subreport.dao.ShoppingCartDAO;
import com.example.subreport.model.ShoppingCart;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ReportService {

    @Autowired
    private ShoppingCartDAO dao;

    public String exportReport(String reportFormat) throws FileNotFoundException, JRException {
        List<ShoppingCart> shoppingCarts = dao.findAll();
        File file = ResourceUtils.getFile("classpath:report.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(shoppingCarts);
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("Created By ", "Soham");
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
        if(reportFormat.equalsIgnoreCase("pdf")){
            JasperExportManager.exportReportToPdfFile(jasperPrint, "C:\\Users\\acer\\OneDrive\\Documents\\Report"+"\\report.pdf");
        }
        else if(reportFormat.equalsIgnoreCase("html")){
            JasperExportManager.exportReportToHtmlFile(jasperPrint, "C:\\Users\\acer\\OneDrive\\Documents\\Report"+"\\report.html");
        }
        return "Report generated";
    }
}
