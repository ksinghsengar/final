<%@ page import="com.model.User" %><%--
  Created by IntelliJ IDEA.
  User: krishan
  Date: 7/16/2017
  Time: 8:59 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="topic.jsp"%>

<html>
<head>
    <title>Title</title>
    <script src="${pageContext.request.contextPath}/resources/js/Script.js"></script>
</head>
<body>
<%= session.getAttribute("message")%>


        <% if(request.getSession(false) != null){
             User user = (User) session.getAttribute("User");
            System.out.println("user in jsp"+user);
             if(user.getPhoto() != null)

        %>
                    <div class="panel-body col-md-5">

                        <div class="col-md-3">
                            <% if(user.getPhoto() != null){%>
                            <img src="/getimage?userName=<%= user.getUserName()%>" alt="">
                            <%}
                            else{%>
                            <span class="glyphicon glyphicon-user"></span>
                            <%}%>
                        </div>

                        <div class="col-md-9">
                            <b class=""><%= user.getFirstName()+" "+user.getLastName()%></b>
                            <span class="text-muted">&commat;<%= user.getUserName()%></span>
                            <span class="text-muted col-md-6">Subscriptions</span>
                            <span class="text-muted col-md-6">Topics</span>
                        </div>
                    </div>



<%}%>

</body>
</html>
