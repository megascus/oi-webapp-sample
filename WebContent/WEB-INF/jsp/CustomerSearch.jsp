<%@page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>顧客検索</title>
	

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
<form name="form" method="post" action="welcome?model=CustomerSearch">

<div id="header"></div>

<h1>顧客検索</h1>

<fieldset style="width: 600px">
	<legend>検索条件</legend>
	<table style="border: 0px">
		<tr>
			<td>顧客ID：</td>
			<td><input type="text" name="customerId" value="<c:out value="${bean.searchCondition.customerId}" />" maxlength="8" size="8" /></td>
		</tr>
		<tr>
			<td>氏名：</td>
			<td><input type="text" name="fullname" value="<c:out value="${bean.searchCondition.fullname}" />" maxlength="256" size="20" /></td>
		</tr>
		<tr>
			<td>氏名(カナ)：</td>
			<td><input type="text" name="fullnameKana" value="<c:out value="${bean.searchCondition.fullnameKana}" />" maxlength="256" size="20" /></td>
		</tr>
		<tr>
			<td>メールアドレス：</td>
			<td><input type="text" name="mailAddress" value="<c:out value="${bean.searchCondition.mailAddress}" />" maxlength="256" size="50" /></td>
		</tr>
		<tr>
			<td>郵便番号：</td>
			<td><input type="text" name="zipCode1" value="<c:out value="${bean.searchCondition.zipCode1}" />" maxlength="3" size="3" />-<input type="text" name="zipCode2" value="<c:out value="${bean.searchCondition.zipCode2}" />" maxlength="4" size="4" /></td>
		</tr>
		<tr>
			<td>電話番号：</td>
			<td><input type="text" name="tel1" value="<c:out value="${bean.searchCondition.tel1}" />" maxlength="4" size="4" />-<input type="text" name="tel2" value="<c:out value="${bean.searchCondition.tel2}" />" maxlength="4" size="4" />-<input type="text" name="tel3" value="<c:out value="${bean.searchCondition.tel3}" />" maxlength="4" size="4" /></td>
		</tr>
	</table>
	<input type="submit" name="search" value="検索" />
</fieldset>
<br />
<br />

<table border="1" class="list-table">
	<thead>
		<tr>
			<th nowrap="nowrap">顧客ID</th>
			<th nowrap="nowrap">メールアドレス</th>
			<th nowrap="nowrap">氏名</th>
			<th nowrap="nowrap">郵便番号</th>
			<th nowrap="nowrap">住所</th>
			<th nowrap="nowrap">電話番号</th>
			<th nowrap="nowrap">作成者</th>
			<th nowrap="nowrap">作成日</th>
			<th nowrap="nowrap">更新者</th>
			<th nowrap="nowrap">更新日</th>
			<th nowrap="nowrap">&nbsp;</th>
		</tr>
<c:forEach var="result" items="${bean.result}" varStatus="status">
		<tr>
			<td><c:out value="${result.customerId}" /></td>
			<td><c:out value="${result.mailAddress}" /></td>
			<td><c:out value="${result.fullname}" />(<c:out value="${result.fullnameKana}" />)</td>
			<td>〒<c:out value="${result.zipCode}" /></td>
			<td><c:out value="${result.todofuken}" />&nbsp;<c:out value="${result.address1}" /><c:out value="${result.address2}" /></td>
			<td><c:out value="${result.tel}" /></td>
			<td><c:out value="${result.createTime}" /></td>
			<td><c:out value="${result.createId}" /></td>
			<td><c:out value="${result.updateTime}" /></td>
			<td><c:out value="${result.updateId}" /></td>
			<td>
			 	<a href="welcome?model=CustomerEdit&customerId=<c:out value="${result.customerId}" />">変更</a>
			</td>
		</tr>
</c:forEach>
</table>
</form>
</body>
</html>