<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
        <title>Registration</title>
        <link href="<c:url value="/resources/css/style.css"/>" type="text/css" rel="stylesheet">
    </head>
    <body>
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7/jquery.js"></script>
    <script>
        $(document).ready(function () {
            function isEmail(email) {
                var regex = /^([a-zA-Z0-9_.+-])+\@(([a-zA-Z0-9-])+\.)+([a-zA-Z0-9]{2,4})+$/;
                return regex.test(email);
            }
            $('#login_button').click(function(){
                var url = "http://localhost:8081/";
                $(location).attr('href',url);
            });
            function error(error_text) {
                $('.ERROR').each(function () {
                    $(this).html(error_text);
                    $(this).show();
                });
            }
            $('#registration_button').click(function(){
                $(location).attr('href',url);
                var userID = $("#user_ID").val();
                var password1 = $("#password_input1").val();
                var password2 = $("#password_input2").val();
                var email=$("#email_input").val();
                if(userID.length > 0&&password1.length>0&&password2.length>0&&email.length>0){
                    if (password1===password2) {
                        if (isEmail(email)) {
                            var url = "http://localhost:8081/registration?userID=" + userID + "&password=" + password1+ "&email=" + email;
                            $(location).attr('href', url);
                        } else error("Email address is incorrect!");
                    }
                    else error("Password confirmation doesn't match password!");
                }
                else error("All fields are required!");
            });
        });
    </script>

    <div class="wrapper">
        <div class="registration">
            <span>Registration</span>
            <div class="error">
                <span id="error"> </span>
            </div>
            <div class="input_area">

                <div class="row">
                    <span>UserID:</span>
                    <input class="field" id="user_ID" name="UserID">
                </div>
                <div class="row">
                    <span>Password:</span>
                    <input type="password" class="field" id="password_input1" name="password">
                </div>
                <div class="row">
                    <span>Repeat password:</span>
                    <input type="password" class="field" id="password_input2" name="password_confirmation">
                </div>
                <div class="row">
                    <span>E-mail:</span>
                    <input class="field" id="email_input" name="e-mail">
                </div>
                <div class="button">
                    <span><input class="reg_buttom" id="registration_button" type="submit" value="Registration"></span>
                </div>
                <div class="button">
                    <span><input class="reg_buttom" id="login_button" type="submit" value="Login"></span>
                </div>
            </div>
        </div>
    </div>
    </body>
</html>

