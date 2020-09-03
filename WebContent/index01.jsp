 <%@page import="javax.naming.InitialContext"%>
 <%@page import="javax.naming.Context"%>
 <%@page import="javax.sql.DataSource"%>
 <%@page import="java.sql.Connection" %>
 <%@page import="java.sql.*" %>
 <%@ page language="java" contentType="text/html; charset=utf-8"
     pageEncoding="utf-8"%>
<%
	/*Context initContext = new InitialContext();     //上转型，也可以不用上转型
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
        $(document).on("click", "#somebutton", function() { // When HTML DOM "click" event is invoked on element with ID "somebutton", execute the following function...
        	var data = {
        		    foo: "fooValue",
        		    bar: "barValue",
        		    baz: "bazValue"
        		};

        		$.ajax({
        		    type: "POST",
        		    url: "someservlet",
        		    contentType: "application/json", // NOT dataType!
        		    data: JSON.stringify(data),
        		    success: function(response) {
        		        alert("123");
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