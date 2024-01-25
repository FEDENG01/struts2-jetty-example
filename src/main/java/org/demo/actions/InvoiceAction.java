package org.demo.actions;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ActionContext;
import org.demo.actions.beans.InvoiceBean;
import java.util.Date;
import java.util.Map;

public class InvoiceAction extends ActionSupport  {

    InvoiceBean invoiceBean;

    @Override
    public String execute() throws Exception {
        System.out.println("execute!!");

        // accede a los datos del formulario
        String subject = invoiceBean.getSubject();
        Date dateFrom = invoiceBean.getDateFrom();
        Date dateTo = invoiceBean.getDateTo();
        Integer importeBruto = invoiceBean.getImporteBruto();
        // Calcula el importe total con el 21% de IVA
        double importeTotalConIVA = importeBruto * 1.21;

        Map<String, Object> session = ActionContext.getContext().getSession();
        session.put("subject", subject);
        session.put("dateFrom", dateFrom);
        session.put("dateTo", dateTo);
        session.put("importeBruto", importeBruto);
        session.put("importeTotalConIVA", importeTotalConIVA);


        return SUCCESS;
    }

    public InvoiceBean getInvoiceBean() {
        return invoiceBean;
    }

    public void setInvoiceBean(InvoiceBean invoiceBean) {
        this.invoiceBean = invoiceBean;
    }
    @Override
    public void validate() {
        if (invoiceBean.getSubject().isEmpty()) {
            addFieldError("invoiceBean.subject", "El concepto es obligatorio.");
        }
        if (invoiceBean.getDateFrom() == null) {
            addFieldError("invoiceBean.dateFrom", "La fecha inicial es obligatoria.");
        }
        if (invoiceBean.getDateTo() == null) {
            addFieldError("invoiceBean.dateTo", "La fecha final es obligatoria.");
        }
        if (invoiceBean.getImporteBruto() == null) {
            addFieldError("invoiceBean.importeBruto", "El importe bruto es obligatorio.");
        }


    }
}
