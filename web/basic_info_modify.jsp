<%--
  Created by IntelliJ IDEA.
  User: zkp15
  Date: 2023/3/23
  Time: 12:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>修改品牌</title>
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
    <meta http-equiv="Cache-Control" content="no-siteapp" />
    <link href="assets/css/bootstrap.min.css" rel="stylesheet" />
    <link rel="stylesheet" href="css/style.css"/>
    <link rel="stylesheet" href="assets/css/ace.min.css" />
    <link rel="stylesheet" href="assets/css/font-awesome.min.css" />
    <link href="Widget/icheck/icheck.css" rel="stylesheet" type="text/css" />
    <script src="js/jquery-1.9.1.min.js"></script>
    <script src="assets/js/bootstrap.min.js"></script>
    <script src="assets/js/typeahead-bs2.min.js"></script>
    <script src="assets/layer/layer.js" type="text/javascript"></script>
    <script type="text/javascript" src="Widget/swfupload/swfupload.js"></script>
    <script type="text/javascript" src="Widget/swfupload/swfupload.queue.js"></script>
    <script type="text/javascript" src="Widget/swfupload/swfupload.speed.js"></script>
    <script type="text/javascript" src="Widget/swfupload/handlers.js"></script>
</head>

<body>
<div class=" clearfix">
    <form action="BasicInfoUpdateServlet" method="post">
        <div id="add_brand" class="clearfix">
            <div class="left_add" style="width: 100%;">
                <div class="title_name" style="width: 100%;">修改类目</div>
                <ul class="add_conent">
                    <li class=" clearfix">
                        <label class="label_name"><i>*</i>类目编号：</label>
                        <input name="basicInfoId" type="hidden" value="${basicInfo.basicInfoId}"/> ${basicInfo.basicInfoId}
                    </li>
                    <li class=" clearfix">
                        <label class="label_name"><i>*</i>类目名称：</label>
                        <input name="basicInfoName" type="text" class="add_text" style="width:600px" value="${basicInfo.basicInfoName}"/>
                    </li>
                    <li class=" clearfix">
                        <label class="label_name"><i>*</i>显示状态：</label>
                        <c:if test="${basicInfo.basicInfoStatus == 1}">
                            <label><input name="basicInfoStatus" value="1" type="radio" class="ace" checked="checked"><span class="lbl">显示</span></label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            <label><input name="basicInfoStatus" value="0" type="radio" class="ace"><span class="lbl">不显示</span></label>
                        </c:if>
                        <c:if test="${basicInfo.basicInfoStatus == 0}">
                            <label><input name="basicInfoStatus" value="1" type="radio" class="ace" ><span class="lbl">显示</span></label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            <label><input name="basicInfoStatus" value="0" type="radio" class="ace" checked="checked"><span class="lbl">不显示</span></label>
                        </c:if>
                    </li>
                </ul>
            </div>
            <div class="button_brand">
                <input type="submit" class="btn btn-warning" value="保存"/>
                <input type="reset" value="取消" class="btn btn-warning"/>
            </div>
        </div>
    </form>
</div>
</body>
</html>
<script type="text/javascript">
    $(document).ready(function(){
        $(".left_add").height($(window).height()-60);
        $(".select").height($(window).height()-195);
        $("#select_style").height($(window).height()-220);
        //当文档窗口发生改变时 触发
        $(window).resize(function(){
            $(".left_add").height($(window).height()-60);
            $(".select").height($(window).height()-195);
            $("#select_style").height($(window).height()-220);
        });
    })
    function checkLength(which) {
        var maxChars = 500;
        if(which.value.length > maxChars){
            layer.open({
                icon:2,
                title:'提示框',
                content:'您出入的字数超多限制!',
            });
            // 超过限制的字数了就将 文本框中的内容按规定的字数 截取
            which.value = which.value.substring(0,maxChars);
            return false;
        }else{
            var curr = maxChars - which.value.length; // 减去 当前输入的
            document.getElementById("sy").innerHTML = curr.toString();
            return true;
        }
    }

</script>