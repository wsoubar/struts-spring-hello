package br.com.wsoubar.hello.jasperreports;

import net.sf.jasperreports.engine.*;
import java.util.*;

public class JasperExample {
    public static void main(String[] args) throws Exception {
        // Compila o relatório .jrxml
        JasperReport report = JasperCompileManager.compileReport("relatorios/exemplo.jrxml");

        // Parâmetros (pode vir de uma Action do Struts)
        Map<String, Object> params = new HashMap<>();
        params.put("TITULO", "Relatório de Teste");

        // Fonte de dados vazia ou JDBC
        JRDataSource dataSource = new JREmptyDataSource();

        // Gera o PDF
        JasperPrint print = JasperFillManager.fillReport(report, params, dataSource);
        JasperExportManager.exportReportToPdfFile(print, "saida.pdf");

        System.out.println("PDF gerado com sucesso!");
    }
}
