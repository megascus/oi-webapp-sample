<%@page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>顧客<c:out value="${bean.viewTitle}" /></title>
	

<style type="text/css">

body {
	font-family: "trebuchet ms", sans-serif;
	color: #555555;
	/* font-size: 11pt; */
	font-size: 12px;
}

table {
	margin-bottom: 1.5em;
	border: 1px solid #c0c0c0;
	border-collapse: collapse;
	border-spacing: 0;
}

table th {
	text-align: left;
	font-weight: bold;
	/* padding: 0.5em; */
	padding: 3px;
	background-color: #eee;
	border: 1px solid #ddd;
}

table td {
	/* padding: 0.5em; */
	padding: 3px;
}

#header {
	height: 95px;
	height: 60px;
	background-image: url('images/logo.png');
	background-position: bottom left;
	background-repeat: no-repeat;
}

</style>

</head>




<body>

<div id="header"></div>

<h1>顧客<c:out value="${bean.viewTitle}" /></h1>

<c:out value="${bean.actionMessage}" /><br />
<c:forEach var="error" items="${bean.errors}" varStatus="status">
	<c:out value="${error}" /><br />
</c:forEach>

<br />

<form name="form" method="post" action="welcome?model=CustomerEdit">
<input type="hidden" name="customerId" value="<c:out value="${bean.mstCustomer.customerId}" />" />

<fieldset style="width: 600px">
	<legend><c:out value="${viewTitle}" />内容</legend>
	<table style="border: 0px">
		<tr>
			<td>顧客ID：</td>
			<td>
				<c:out value="${bean.mstCustomer.customerId}" />
			</td>
		</tr>
		<tr>
			<td>氏名：</td>
			<td><input type="text" name="fullname" value="<c:out value="${bean.mstCustomer.fullname}" />" maxlength="256" size="20" /></td>
		</tr>
		<tr>
			<td>氏名(カナ)：</td>
			<td><input type="text" name="fullnameKana" value="<c:out value="${bean.mstCustomer.fullnameKana}" />" maxlength="256" size="20" /></td>
		</tr>
		<tr>
			<td>メールアドレス：</td>
			<td><input type="text" name="mailAddress" value="<c:out value="${bean.mstCustomer.mailAddress}" />" maxlength="256" size="50" /></td>
		</tr>
		<tr>
			<td>郵便番号：</td>
			<td><input type="text" name="zipCode1" value="<c:out value="${bean.mstCustomer.zipCode1}" />" maxlength="3" size="3" />-<input type="text" name="zipCode2" value="<c:out value="${bean.mstCustomer.zipCode2}" />" maxlength="4" size="4" /></td>
		</tr>
		<tr>
			<td>都道府県：</td>
			<td><input type="text" name="todofuken" value="<c:out value="${bean.mstCustomer.todofuken}" />" maxlength="8" size="8" /></td>
		</tr>
		<tr>
			<td>住所１(市区郡町村)：</td>
			<td><input type="text" name="address1" value="<c:out value="${bean.mstCustomer.address1}" />" maxlength="256" size="50" /></td>
		</tr>
		<tr>
			<td>住所２(番地号・建物名)：</td>
			<td><input type="text" name="address2" value="<c:out value="${bean.mstCustomer.address2}" />" maxlength="256" size="50" /></td>
		</tr>
		<tr>
			<td>電話番号：</td>
			<td>
				<input type="text" name="tel1" value="<c:out value="${bean.mstCustomer.tel1}" />" maxlength="4" size="4" />-
				<input type="text" name="tel2" value="<c:out value="${bean.mstCustomer.tel2}" />" maxlength="4" size="4" />-
				<input type="text" name="tel3" value="<c:out value="${bean.mstCustomer.tel3}" />" maxlength="4" size="4" />
			</td>
		</tr>
	</table>
	<input type="submit" name="edit" value="<c:out value="${bean.viewTitle}" />" />
</fieldset>

</form>
</body>
</html>