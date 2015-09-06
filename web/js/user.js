/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


icp.updatepw = function () {
    if ($("#Pwd").val() === $("#rPwd").val()) {
        var form = {
            "user_password": $("#Pwd").val()
        };

        $.post("UpdatePassword", form, function (data) {
            console.log(data);
            $('#closepwd').trigger("click");
        });
    }else{
        alert("password and retype password is not match");
    }
}

icp.updateem = function () {
    if ($("#nEmail").val() === $("#nEmail2").val()) {
        var form = {
        "user_email": $("#nEmail").val()
        };

        $.post("UpdateEmail", form, function (data) {
        console.log(data);
        $('#closeacc').trigger("click");
        $('#mail').html(form['user_email']);
        });
    }else{
        alert("email and retype email is not match");
    
    }
}