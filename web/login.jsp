<%--
  Created by IntelliJ IDEA.
  User: zkp15
  Date: 2023/3/15
  Time: 21:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <link href="assets/css/bootstrap.min.css" rel="stylesheet"/>
    <link rel="stylesheet" href="assets/css/ace.min.css"/>
    <link rel="stylesheet" href="assets/css/ace-rtl.min.css"/>
    <link rel="stylesheet" href="assets/css/ace-skins.min.css"/>
    <link rel="stylesheet" href="css/style.css"/>
    <script src="assets/js/ace-extra.min.js"></script>
    <script src="js/jquery-1.9.1.min.js"></script>
    <script src="assets/layer/layer.js" type="text/javascript"></script>
    <title>登录</title>
</head>

<body class="login-layout Reg_log_style" style="background: url(images/login_bg.png);">
<div class="logintop">
    <span>欢迎后台管理界面平台</span>
    <ul>
        <li><a href="#">返回首页</a></li>
        <li><a href="#">帮助</a></li>
        <li><a href="#">关于</a></li>
    </ul>
</div>
<div class="loginbody">
    <div class="login-container">
        <div class="center"></div>
        <div class="space-6"></div>

        <div class="position-relative">
            <div id="login-box" class="login-box widget-box no-border visible" style="margin-top: 50px;">
                <div class="widget-body">
                    <div class="widget-main">
                        <h4 class="header blue lighter bigger">
                            <i class="icon-coffee green"></i>
                            管理员登录 ${tips}
                        </h4>

                        <div class="login_icon"><img src="images/login.png"/></div>

                        <form class="" id="form1" action="ManagerLoginServlet" method="post">
                            <fieldset>
                                <ul>
                                    <li class="frame_style form_error">
                                        <label class="user_icon"></label>
                                        <input name="loginName" title="用户名" type="text" id="username"/><i>用户名</i>
                                    </li>
                                    <li class="frame_style form_error">
                                        <label class="password_icon"></label>
                                        <input name="loginPwd" title="密码" type="password" id="userpwd"/><i>密码</i>
                                    </li>
                                    <li class="frame_style form_error">
                                        <label class="Codes_icon"></label>
                                        <input name="loginCode" title="验证码" type="text" id="Codes_text"/><i>验证码</i>
                                        <div class="Codes_region"><img src="CheckCodeServlet" width="100%"
                                                                       height="100%" id="checkImg"></div>
                                    </li>
                                </ul>
                                <div class="space"></div>

                                <div class="clearfix">
                                    <label class="inline">
                                        <input type="checkbox" class="ace">
                                        <span class="lbl">保存密码</span>
                                    </label>

                                    <button type="submit" class="width-35 pull-right btn btn-sm btn-primary"
                                            id="login_btn">
                                        <i class="icon-key"></i>
                                        登录
                                    </button>
                                </div>

                                <div class="space-4"></div>
                            </fieldset>
                        </form>

                        <div class="social-or-login center">
                            <span class="bigger-110">通知</span>
                        </div>

                        <div class="social-login center">
                            请使用IE8及以上版本的浏览器...
                        </div>
                    </div><!-- /widget-main -->

                    <div class="toolbar clearfix"></div>
                </div><!-- /widget-body -->
            </div><!-- /login-box -->
        </div><!-- /position-relative -->
    </div>
</div>
<div class="loginbm">版权所有 2023</div>
<strong></strong>
</body>
</html>
<script>
    $('#form1').on('submit', function () {
        var num = 0;
        var str = "";
        $("input[type$='text'],input[type$='password']").each(function (n) {
            if ($(this).val() == "") {

                layer.alert(str += "" + $(this).attr("title") + "不能为空！\r\n", {
                    title: '提示框',
                    icon: 0,
                });
                num++;
                return false;
            }
        });
        if (num > 0) {
            return false;
        } else {
            // layer.alert('登录成功！', {
            //     title: '提示框',
            //     icon: 1,
            // });
            // location.href = "index.jsp";
            // layer.close(index);
            return true;
        }

    });
    $('#checkImg').click(function () {
        $('#checkImg').attr("src","CheckCodeServlet?m="+Math.random());
    });
    $(document).ready(function () {
        $("input[type='text'],input[type='password']").blur(function () {
            var $el = $(this);
            var $parent = $el.parent();
            $parent.attr('class', 'frame_style').removeClass(' form_error');
            if ($el.val() == '') {
                $parent.attr('class', 'frame_style').addClass(' form_error');
            }
        });
        $("input[type='text'],input[type='password']").focus(function () {
            var $el = $(this);
            var $parent = $el.parent();
            $parent.attr('class', 'frame_style').removeClass(' form_errors');
            if ($el.val() == '') {
                $parent.attr('class', 'frame_style').addClass(' form_errors');
            } else {
                $parent.attr('class', 'frame_style').removeClass(' form_errors');
            }
        });
    })

</script>
