var process_request = "<img src='loading.gif' with='16' height='16' border='0' align='absmiddle'>正在数据处理ing";
var username_empty = "<span style='COLOR:#ff0000'>  × 用户名不能为空!</span>";
var username_shorter = "<span style='COLOR:#ff0000'> × 用户名长度不能少于 3 个字符。</span>";
var username_longer = "<span style='COLOR:#ff0000'> × 用户名长度不能大于 30个字符。</span>";
var username_invalid = "- 用户名只能是由字母数字以及下划线组成。";
var username_have_register = "<span style='COLOR:#ff0000'> × 用户名已经存在,请重新输入!</span>";
var username_can_register="<span style='COLOR:#006600'> √ 恭喜您！该用户名可以注册!</span>";
var password_empty = "<span style='COLOR:#ff0000'> × 登录密码不能为空。</span>";
var password_shorter_s = "<span style='COLOR:#ff0000'> × 登录密码不能少于 6 个字符。</span>";
var password_shorter_m = "<span style='COLOR:#ff0000'> × 登录密码不能多于 30 个字符。</span>";
var confirm_password_invalid = "<span style='COLOR:#ff0000'> × 两次输入密码不一致!</span>";
var email_empty = "<span style='COLOR:#ff0000'> × 邮箱不能为空！</span>";
var email_invalid = "<span style='COLOR:#ff0000'> × 邮箱格式出错！</span>";
var email_have_register = "<span style='COLOR:#ff0000'> × 该邮箱已被注册！ </span>";
var email_can_register = "<span style='COLOR:#006600'> √ 邮箱可以注册!</span>";
var agreement_no = "<span style='COLOR:#ff0000'> × 您没有接受协议</span>";
var agreement_yes= "<span style='COLOR:#006600'> √ 已经接受协议</span>";
var info_can="<span style='COLOR:#006600'> √ 可以注册!</span>";
var info_right="<span style='COLOR:#006600'> √ 填写正确!</span>";
var name_flag=false;
var email_flag=false;
var password_flag=false;
var accept_flag=false;

$(function () {
    change_submit();
    if (document.getElementById("agreement").checked) {
        alert("Checkbox is checked");
    }
});

function getRootPath() {
    var pathName = window.location.pathname.substring(1);
    var webName = pathName == '' ? '' : pathName.substring(0, pathName.indexOf('/'));
    return window.location.protocol + '//' + window.location.host + '/' + webName + '/';
}


function checkUserName(obj) {
    if (checks(obj.value) == false) {
        showInfo("username_notice", username_invalid);
    }
    else if (obj.value.length < 1) {
        showInfo("username_notice", username_empty);
    }
    else if (obj.value.length <3) {
        showInfo("username_notice", username_shorter);
    }
    else if (obj.value.length >30) {
        showInfo("username_notice", username_longer);
    }
    else {
        var depart=obj.value;

        $.ajax({
            /*    type: "post",
                url :"checkUserName",
                dataType : 'JSON',
                date: 'username=' + username,
                contentType : 'application/x-www-form-urlencoded',
                success:function (json) {
                    if (json.flat) {
                        showInfo("username_notice", username_have_register);
                    } else {
                        showInfo("username_notice", username_can_register);
                        name_flag = true;
                        change_submit();
                        return
                    }
                }*/
            async: false,
            url: "/checkUserName",
            data: "depart=" + depart,
            type: "post",
            dataType: "json",
            success: function (json) {
                alert(json.flag)
                if (json.flag) {
                    showInfo("username_notice", username_have_register);
                } else {
                    showInfo("username_notice", username_can_register);
                    name_flag = true;
                    change_submit();
                    return
                }
            }

        });
    }
    name_flag = false;
    change_submit();
}

function checks(t) {
    szMsg = "[#%&\'\"\\,;:=!^@]"
    for (i = 1; i < szMsg.length + 1; i++) {
        if (t.indexOf(szMsg.substring(i - 1, i)) > -1) {
            return false;
        }
    }
    return true;
}

function checkPassword(password) {
    if (password.value.length < 1) {
        password_flag = false;
        showInfo("password_notice", password_empty);
    }
   else if (password.value.length < 6) {
        password_flag = false;
        showInfo("password_notice", password_shorter_s);
    }
   else if (password.value.length > 30) {
        password_flag = false;
        showInfo("password_notice", password_shorter_m);
    }
    else {
        showInfo("password_notice", info_right);
    }
    change_submit();
}

function checkConformPassword(conform_password) {
     if (conform_password.value.length < 1) {
        showInfo("conform_password_notice", password_empty);
    }
    else if (conform_password.value != $("#password").val()) {
        showInfo("conform_password_notice", confirm_password_invalid);
    }
    else {
        showInfo("conform_password_notice", info_right);
        password_flag = true;
        change_submit();
        return;
    }
    password_flag = false;
    change_submit();

}
function checkIntensity(pwd)
{
    var Mcolor = "#FFF",Lcolor = "#FFF",Hcolor = "#FFF";
    var m=0;

    var Modes = 0;
    for (i=0; i<pwd.length; i++)
    {
        var charType = 0;
        var t = pwd.charCodeAt(i);
        if (t>=48 && t <=57)
        {
            charType = 1;
        }
        else if (t>=65 && t <=90)
        {
            charType = 2;
        }
        else if (t>=97 && t <=122)
            charType = 4;
        else
            charType = 4;
        Modes |= charType;
    }

    for (i=0;i<4;i++)
    {
        if (Modes & 1) m++;
        Modes>>>=1;
    }

    if (pwd.length<=4)
    {
        m = 1;
    }

    switch(m)
    {
        case 1 :
            Lcolor = "2px solid red";
            Mcolor = Hcolor = "2px solid #DADADA";
            break;
        case 2 :
            Mcolor = "2px solid #f90";
            Lcolor = Hcolor = "2px solid #DADADA";
            break;
        case 3 :
            Hcolor = "2px solid #3c0";
            Lcolor = Mcolor = "2px solid #DADADA";
            break;
        case 4 :
            Hcolor = "2px solid #3c0";
            Lcolor = Mcolor = "2px solid #DADADA";
            break;
        default :
            Hcolor = Mcolor = Lcolor = "";
            break;
    }
    document.getElementById("pwd_lower").style.borderBottom  = Lcolor;
    document.getElementById("pwd_middle").style.borderBottom = Mcolor;
    document.getElementById("pwd_high").style.borderBottom   = Hcolor;
}
function checkAgreement(obj) {
    if (document.getElementById("agreement").checked) {
        showInfo("agreement_notice", agreement_yes);
        accept_flag = true;
        change_submit();
    } else {
        showInfo("agreement_notice", agreement_no);

    }
}
function change_submit()
{
    if(name_flag&&password_flag&&accept_flag){
        document.forms['formUser'].elements['Submit1'].disabled = '';
    }
    else
    {
        document.forms['formUser'].elements['Submit1'].disabled = 'disabled';
    }
}
function showInfo(target,Infos){
    document.getElementById(target).innerHTML = Infos;
}
function showclass(target,Infos){
    document.getElementById(target).className = Infos;
}


