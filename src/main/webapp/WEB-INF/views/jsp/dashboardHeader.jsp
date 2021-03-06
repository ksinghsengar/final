<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: krishan
  Date: 7/16/2017
  Time: 9:00 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script src="${pageContext.request.contextPath}/resources/js/Modal.js"></script>
    <title>Topic</title>
</head>
<body>


<div id="topicModal" class="modal fade" role="dialog">
    <div class="modal-dialog">

        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title">Modal Header</h4>
            </div>
            <div class="modal-body">
                <form method="post" id = "topicForm" action="javascript:void(0)">
                    <div class="form-group">
                        <label>Topic Name</label>
                        <input type="text" id="topicName" class="form-control col-md-5" name="name"  placeholder="Enter topic name" required>
                    </div>
                    <div class="form-group">
                        <label>Visibility</label>
                        <select id="topicvisibility" class="form-control" name="visibility">
                            <option>PUBLIC</option>
                            <option>PRIVATE</option>
                        </select>
                    </div>

                </form>
            </div>
            <div class="modal-footer">
                <button id="submitForm" type="button" class="btn btn-primary" data-dismiss="modal">Submit</button>
                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
            </div>
        </div>

    </div>
</div>





<!-- Modal -->
<div id="envelopeModal" class="modal fade" role="dialog">
    <div class="modal-dialog">

        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title">Modal Header</h4>
            </div>
            <div class="modal-body">
                <form method="post" id = "inviteForm" action="javascript:void(0)">
                    <div class="form-group">
                        <label>Email*</label>
                        <input type="text" id="email" class="form-control col-md-5" name="email"  placeholder="Enter topic name" required>
                    </div>
                    <div class="form-group">
                        <label>Topic*</label>
                        <select id="topic" class="form-control" name="topic">
                           <%-- <option>PUBLIC</option>
                            <option>PRIVATE</option>--%>
                        </select>
                    </div>

                </form>

            </div>
            <div class="modal-footer">
                <button id="sendInvite" type="button" class="btn btn-primary" data-dismiss="modal">Invite</button>
                <button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
            </div>
        </div>

    </div>
</div>



<!-- Modal -->
<div id="linkModal" class="modal fade" role="dialog">
    <div class="modal-dialog">

        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title">Modal Header</h4>
            </div>
            <div class="modal-body">
                <form method="post" id = "shareLink" action="javascript:void(0)">
                    <div class="form-group">
                        <label>Link</label>
                        <input type="url" id="link" class="form-control col-md-5" name="url"  placeholder="Enter topic name" required>
                    </div>
                    <div class="form-group">
                        <label>Description</label>
                        <textarea name="description" id="description" cols="30" rows="10" class="form-control col-md-5" placeholder="Enter Link Description" required></textarea>
                    </div>
                    <div class="form-group">
                        <label>Topic</label>
                        <select id="linkTopic" class="form-control" name="topic">
                            <%--<c:forEach></c:forEach>--%>
                        </select>
                    </div>

                </form>


            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-primary" id="submitLink" data-dismiss="modal">Share</button>
                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
            </div>
        </div>

    </div>
</div>


<!-- Modal -->
<div id="fileModal" class="modal fade" role="dialog">
    <div class="modal-dialog">

        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title">Modal Header</h4>
            </div>
            <div class="modal-body">
                <form method="post" id = "shareDocument" action="javascript:void(0)">
                    <div class="form-group">
                        <label>Document</label>
                        <input type="file" id="document" class="form-control col-md-5" name="filePath" required>
                    </div>
                    <div class="form-group">
                        <label>Description</label>
                        <textarea name="description" id="documentDescription" cols="30" rows="10" class="form-control col-md-5" placeholder="Description" required></textarea>
                    </div>
                    <div class="form-group">
                        <label>Topic</label>
                        <select id="documentTopic" class="form-control" name="topic">
                            <%-- <option>PUBLIC</option>
                             <option>PRIVATE</option>--%>
                        </select>
                    </div>

                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-primary" id="submitDocument" data-dismiss="modal">Share</button>
                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
            </div>
        </div>

    </div>
</div>

<div>

</div>
<%--<div class ="dashboard-menu">--%>
<%--<ul style="display: none;" class="list-horizontal">--%>
    <%--<li><a href="#">Profile</a></li>--%>
    <%--<li><a href="#">Users</a></li>--%>
    <%--<li><a href="#">Topics</a></li>--%>
    <%--<li><a href="#">Posts</a></li>--%>
    <%--<li><a href="/logout">Logout</a></li>--%>
<%--</ul>--%>
<%--</div>--%>

</body>
</html>
