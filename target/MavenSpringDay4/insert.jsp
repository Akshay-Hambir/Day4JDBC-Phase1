<html>
<body>
<form action="/insert.spring">
<label>Enter ID</label>
<input type="number" name="id"/>

<label>Enter name</label>
<input type="text" name="name"/>

<label>Enter Salary</label>
<input type="text" name="salary"/>

<input type="submit"/>
</form>

<% String status = (String)request.getAttribute("key");
if(status!=null){
if(status.equals("true")){
out.println("<h1> record inserted successfully </h1>");
}
else{
out.println("<h1> record not inserted successfully </h1>");
}
}
%>
</body>
</html>