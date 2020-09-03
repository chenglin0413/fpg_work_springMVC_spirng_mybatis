 <%@page import="javax.naming.InitialContext"%>
 <%@page import="javax.naming.Context"%>
 <%@page import="javax.sql.DataSource"%>
 <%@page import="java.sql.Connection" %>
 <%@page import="java.sql.*" %>
 <%@ page language="java" contentType="text/html; charset=utf-8"
     pageEncoding="utf-8"%>
<%
/*
	Context initContext = new InitialContext();     //上转型，也可以不用上转型
	DataSource ds = (DataSource)initContext.lookup("java:/comp/env/jdbc/abkDB");
	Connection con=ds.getConnection();
	PreparedStatement pstmt =null;
	ResultSet rs =null;
	pstmt = con.prepareStatement("SELECT XUID from adrbook");
	rs = pstmt.executeQuery();
    while(rs.next()){
    	out.print("XUID : "+rs.getString("XUID"));
    }*/

%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=BIG5">
 <head>
        <title>SO question 4112686</title>
        <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
        <script>
        $(document).on("click", "#somebutton", function() {
        	var data = {
        		    action: "getlist"
        		};
        	$.ajax({
    		    type: "POST",
    		    url: "TestServlet",
    		    contentType: "application/json", // NOT dataType!
    		    data: JSON.stringify(data),
    		    success: function(responseJson) {
    		    	var $table = $("<table>").appendTo($("#somediv")); // Create HTML <table> element and append it to HTML DOM element with ID "somediv".
                    $.each(responseJson, function(index, adrbook) {    // Iterate over the JSON array.
                        $("<tr>").appendTo($table)                     // Create HTML <tr> element, set its text content with currently iterated item and append it to the <table>.
                            .append($("<td>").text(adrbook.xuid))        // Create HTML <td> element, set its text content with id of currently iterated product and append it to the <tr>.
                            .append($("<td>").text(adrbook.name))      // Create HTML <td> element, set its text content with name of currently iterated product and append it to the <tr>.
                            .append($("<td>").text(adrbook.tel))    // Create HTML <td> element, set its text content with price of currently iterated product and append it to the <tr>.
                            .append($("<td>").text(adrbook.type))
                            .append($("<td>").text(adrbook.type_index))
                            .append($("<td>").text(adrbook.notes))
                            .append($("<td>").text(adrbook.timestamp));
                    });
    		    }
    		});


        });
        </script>
    </head>
    <body>
       <button id="somebutton">press here</button>
        <div id="somediv"></div>
        <select id="someselect"></select>
    </body>
</html>