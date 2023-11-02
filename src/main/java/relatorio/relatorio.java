/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package relatorio;

import java.util.HashMap;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

/**
 *
 * @author paulo
 */
public class relatorio {

    public static void imprimeRelatorio(String relatorioNome, HashMap parametros, List lista) {
        try {
            JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(lista);
            FacesContext facesContext = FacesContext.getCurrentInstance();
            facesContext.responseComplete();
            ServletContext sContext = (ServletContext) facesContext.getExternalContext().getContext();

            JasperPrint jasperPrint
                    = JasperFillManager.fillReport(sContext.getRealPath("/WEB-INF/relatorios/") + relatorioNome + ".jasper",
                            parametros,
                            dataSource);
            byte[] b = JasperExportManager.exportReportToPdf(jasperPrint);

            HttpServletResponse res = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
            res.setContentType("/application/pdf");

            int codigo = (int) (Math.random() * 1000);

            res.setHeader("Content-disposition", "inline;filename=relatorio_" + codigo + ".pdf");

            res.getOutputStream().write(b);
            res.getCharacterEncoding();
            FacesContext.getCurrentInstance().responseComplete();
        } catch (Exception e) {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "Erro ao imprimir relatório: " + e.getMessage(),
                    "");
            FacesContext.getCurrentInstance().addMessage(null, message);
        }

    }
}
