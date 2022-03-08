<%--
  Created by IntelliJ IDEA.
  User: 朱鹏
  Date: 2022/3/8
  Time: 19:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=utf-8"  pageEncoding="utf-8"%>

<html>
<head>
    <style >
    td.right{
        text-align: right;height: 25px;
    }

    </style>
</head>
<body>
<h3>用户注册</h3>
<form action="" method="post"><table>
    <tr> <td class="right">用户名：</td> <td><input type="text" name="uName"/></td></tr>
    <tr> <td class="right">密码：</td><td><input type="password" name="uPwd"/></td></tr>
    <tr><td class="right">确认密码：</td><td> <input type="password" name="uRepwd"/></td> </tr>
    <tr>
        <td class="right">性别：</td>
        <td>
            <input type="radio" name="uSex" value="男" checked="checked"/>男
            <input type="radio" name="uSex" value="女" /> 女
        </td>
    </tr>
    <tr><td class="right">手机号码：</td><td><input type="text" name="uPhone"/></td></tr>
    <tr><td class="right">电子邮箱：</td><td><input type="text" name="uEmail"/></td></tr>
    <tr><td></td><td><input type="submit" value="注册"/><input type="reset" value="重置"></td>  </tr>

</table></form>
</body>
</html>

