<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sx" uri="/struts-dojo-tags" %>
<!DOCTYPE html>
<html>
<head>
  <title><s:text name="hello.message"/></title>
  <s:head/>
  <sx:head/>
</head>

<body>

    <h1>Resumen de factura: </h1>

     <p>Concepto: <s:property value="#session.subject"/></p>
      <p>Fecha desde: <s:property value="#session.dateFrom"/></p>
      <p>Fecha hasta: <s:property value="#session.dateTo"/></p>
      <p>Importe Bruto: <s:property value="#session.importeBruto"/></p>
      <p>Importe Total con IVA (21%): <s:property value="#session.importeTotalConIVA"/></p>

</body>
</html>