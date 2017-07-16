<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page import="java.util.Calendar" %>
<html>

<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/Style.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

    <title>
        Home
    </title>

</head>

<body>
<div class="container">
    <!-- page header-->
    <div class="col-md-12 well well-sm">

        <div class="col-md-4">
            <h3><a href="">Link Sharing</a> </h3>
        </div>


        <div class=" col-md-offset-6 col-md-2">
            <div class="input-group">
                    <span class="input-group addon">
                    <span class="glyphicon glyphicon-search"></span></span>
                <input type="search" class="form-control" placeholder="Search" />
            </div>
        </div>
    </div>




    <div class="col-md-7">
        <!-- blog1-->
        <div class="panel panel-default">
            <div class="panel-heading">
                Recent shares
            </div>

            <div class="panel-body">

                <div class="col-md-2">
                    <span class="glyphicon glyphicon-user"></span>
                </div>

                <div class="col-md-10">
                    <b class="">Uday Pratap Singh</b>
                    <span class="text-muted">&commat;uday 5 min</span>
                    <a href=# class="grails">Grails</a>
                    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.Nulla quam velt, vulputate eu pharetra nec, mattis ac neque. Duis</p>
                    <a class="fa fa-facebook-square"></a>
                    <a class="fa fa-tumblr"></a>
                    <a class="fa fa-google-plus"></a>
                    <a href=# class="view_post"> view post</a>
                </div>


            </div>
            <div class="panel-body">


                <div class="col-md-2">
                    <span class="glyphicon glyphicon-user"></span>
                </div>

                <div class="col-md-10">
                    <b>Uday Pratap Singh</b>
                    <span class="text-muted">&commat;uday 10 min</span>
                    <a href=# class="grails">Grails</a>
                    <p> Lorem ipsum dolor sit amet, consectetur adipiscing elit.Nulla quam velt, vulputate eu pharetra nec, mattis ac neque. Duis</p>
                    <a class="fa fa-facebook-square"></a>
                    <a class="fa fa-tumblr"></a>
                    <a class="fa fa-google-plus"></a>
                    <a href=# class="view_post"> view post</a>
                </div>


            </div>

        </div>


        <!-- blog2 -->
        <div class="panel panel-default">
            <div class="panel-heading">
                Top Posts
                <div class="dropdown float-lg-right">
                    <button class="btn btn-default dropdown-toggle" type="button" data-toggle="dropdown">Today
                        <span class="caret"></span>
                    </button>
                    <ul class="dropdown-menu">
                        <li><a href="#">Today</a></li>
                        <li><a href="#">1 week</a></li>
                        <li><a href="#">1 month</a></li>
                    </ul>
                </div>
            </div>

            <div class="panel-body">
                <div class="col-md-2">
                    <span class="glyphicon glyphicon-user"></span>
                </div>

                <div class="col-md-10">
                    <b>Uday Pratap Singh</b>
                    <span class="text-muted">&commat;uday 21 Jul 2014</span>
                    <a href=# class="grails">Grails</a>
                    <br/> Lorem ipsum dolor sit amet, consectetur adipiscing elit.Nulla quam velt, vulputate eu pharetra nec, mattis ac neque. Duis<br/>
                    <a class="fa fa-facebook-square"></a>
                    <a class="fa fa-tumblr"></a>
                    <a class="fa fa-google-plus"></a>
                    <a href=# class="view_post"> view post</a>
                </div>
            </div>
        </div>
    </div>


    <div class="col-md-5">
        <!-- login form -->
        <div class="panel panel-default">
            <div class="panel-heading">
                Login
            </div>


            <div class="panel-body">
                <form:form modelAttribute="User" method="post" action="/login">
                    <div class="form-group">
                        <label  class="contol-label col-md-5">Email/Username*</label>
                        <div class="input-group col-md-6">
                            <input type="text" class="form-control"   name="loginUser" required>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="contol-label col-md-5">Password*</label>
                        <div class="input-group col-md-6">
                            <input type="password" class="form-control"  name="loginPassword" required>
                        </div>
                    </div>


                    <div class="form-group">
                        <a href="" class="forgot_password">Forgrot Password</a>
                        <div class="input-group col-md-offset-5 col-md-6">
                            <button type="submit"> Login</button>
                        </div>
                    </div>
                </form:form>
            </div>

        </div>

        <!-- Regstration form -->
        <div class="panel panel-default">
            <div class="panel-heading">
                Register
            </div>


            <div class="panel-body">
                <form:form action="/register" method="POST"  >
                    <div class="form-group">
                        <label class="contol-label col-md-5">First name*</label>
                        <div class="input-group col-md-6">
                            <input type="text" class="form-control" name="firstName" required>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="contol-label col-md-5">Last name*</label>
                        <div class="input-group col-md-6">
                            <input type="text" class="form-control" name="lastName" required>
                        </div>
                    </div>
                    <div class="form-group">
                        <label  class="contol-label col-md-5">Email*</label>
                        <div class="input-group col-md-6">
                            <input type="email" class="form-control" name="email" required>
                        </div>
                    </div>
                    <div class="form-group">
                        <label  class="contol-label col-md-5">Username*</label>
                        <div class="input-group col-md-6">
                            <input type="text" class="form-control"  name="userName" required>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="contol-label col-md-5">Password*</label>
                        <div class="input-group col-md-6">
                            <input type="password" class="form-control"  name="password" required>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="contol-label col-md-5">Confirm Password*</label>
                        <div class="input-group col-md-6">
                            <input type="password" class="form-control"  name="confirmPassword" required>
                        </div>
                    </div>
                    <%--<div class="form-group">
                        <label for="photo" class="contol-label col-md-5">Photo</label>
                        <div class="input-group col-md-3">
                            <input type="file" class="" placeholder="" id="photo" name="photo">
                        </div>
                    </div>--%>

                    <div class="form-group">
                        <div class="input-group col-md-offset-5 col-md-6">
                            <button type="submit"> Register</button>
                        </div>
                    </div>
                </form:form>
            </div>

        </div>

    </div>

</div>
</body>

</html>