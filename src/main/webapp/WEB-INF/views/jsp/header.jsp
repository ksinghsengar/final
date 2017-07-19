<div class="col-md-12 well well-sm">

    <div class="col-md-4">
        <h3><a href="">Link Sharing</a> </h3>
    </div>

        <div class="input-group pull-right" >
                    <span class="input-group addon">
                    <span class="glyphicon glyphicon-search"></span></span>
            <input type="search" class="form-control pull-right col-md-2" placeholder="Search"  />
        </div>

    <div class="append" style="display: none;">
        <i class="fa fa-envelope" aria-hidden="true"></i>
        <i class="fa fa-comment " aria-hidden="true"></i>
        <span class="glyphicon glyphicon-link"></span>
        <i class="fa fa-file-o "></i>
        <i class="fa fa-user " aria-hidden="true"></i>
    </div>
</div>

<script>
    $(".register button").on('click',function(e) {
        var pass = $('input[name = "password"]').val();
        var cpassword = $('input[name = "confirmPassword"]').val();
        if(pass != cpassword) {
            /*$("div.alert-warning").append("Password and Confirm Password do not match.");
             $("div.alert-warning").css("font-size","20px");
             $("div.alert-warning").css("display","inline");*/
            alert("Password and Confirm Password do not match");
            e.preventDefault();
        }
    });





</script>