<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="<c:url value="/resources/css/style.css"/>" type="text/css" rel="stylesheet">
    <title>Title</title>
</head>
<body>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7/jquery.js"></script>
<script>
    $(document).ready(function () {

        function hasError() {
            $('.error').each(function () {
                var error1=$(this);
                console.log(error1.text);
                var l=error1.text.length
                console.log(l);
                if (l>1){console.log(123);
                    error1.show();}
            });}
        hasError();
        function error(error_text) {
            $('.ERROR').each(function () {
                $(this).html(error_text);
                $(this).show();
            });
        }
        $('#login_button').click(function(){
            var userID = $("#login_input").val();
            var password = $("#password_input").val();
            if(userID.length > 0&&password.length>0){
                var url = "http://localhost:8081/loading?userID="+userID+"&password="+password;
                $(location).attr('href',url);
            }
            else error("Enter UserID and Password");
        });
        $('#registration_button').click(function(){
            var url = "http://localhost:8081/registration";
            $(location).attr('href',url);
        });
    });
</script>
<div class="wrapper">
    <div class="registration">

        <span>Login</span>
        <div class="error">
            ${errorText}
            <%--<span id="error"> </span>--%>
        </div>
        <div class="input_area">

            <div class="row">
                <span>Login:</span>
                <input class="field" id="login_input" name="login">
            </div>
            <div class="row">
                <span>Password:</span>
                <input type="password" class="field" id="password_input" name="password">
            </div>
            <div class="button">
                <span><input class="reg_buttom" id="login_button" type="submit" value="Login"></span>
            </div>
            <div class="button">
                <span><input class="reg_buttom" id="registration_button" type="submit" value="Registration"></span>
            </div>
        </div>
    </div>
</div>
</body>
</html>

