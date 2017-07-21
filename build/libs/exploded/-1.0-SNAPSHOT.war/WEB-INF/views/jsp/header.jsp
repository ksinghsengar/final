<%@ page import="com.model.User" %>
<div class="col-md-12 well well-sm">

    <div class="col-md-4">
        <h3><a href="/">Link Sharing</a> </h3>
    </div>

        <div class="input-group pull-right" >
                    <span class="input-group addon">
                    <span class="glyphicon glyphicon-search"></span></span>
            <input type="search" class="form-control search pull-right col-md-2" placeholder="Search"  />
        </div>

    <div class="append" style="display: none;">

        <i class="fa fa-comment " aria-hidden="true"></i>
        <i class="fa fa-envelope" aria-hidden="true"></i>
        <span class="glyphicon glyphicon-link"></span>
        <i class="fa fa-file-o "></i>
        <i class="fa fa-user " aria-hidden="true"></i>

        <%--<i class="fa fa-caret-down" aria-hidden="true"></i>--%>
        <div class="dropdown">
            <button class="btn btn-primary dropdown-toggle" type="button" data-toggle="dropdown">
                <span class="caret"></span></button>
            <ul class="dropdown-menu">
                <li><a href="#">Profile</a></li>
                <li><a href="#">Users</a></li>
                <li><a href="#">Topics</a></li>
                <li><a href="#">Posts</a></li>
                <li><a href="/logout">Logout</a></li>
            </ul>
        </div>

    </div>
</div>


