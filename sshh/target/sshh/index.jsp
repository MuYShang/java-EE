<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%-- 引入struts2 的标签库--%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<body>
<%-- 获取值栈中的user对象的uname的值--%>
用户名： <s:property value="user.uname"></s:property>

</body>
</html>
