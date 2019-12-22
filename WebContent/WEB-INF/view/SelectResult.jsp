<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="jp.yubin.YubinCsvData" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.text.Normalizer" %>
<%
	YubinCsvData resultYubinData = (YubinCsvData)session.getAttribute("resultYubinData");

%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="/yubin/css/styles.css">
<title>検索結果画面</title>
</head>
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="/yubin/js/common.js" charset="UTF-8"></script>

<body>
	<div>
	<div class="yubintop">
		<span class="yubinmain">郵便番号検索</span><span class="yubinsub">（検索結果画面）</span>
	</div>
	<div class="boxall">
		<div class="postalcode fnt">
			〒<%=resultYubinData.getPostalCode()%>
		</div>
		<div class="fnt">
			<%=resultYubinData.getPrefecturesName()%>
		</div>
		<div class="fnt">
			<%=resultYubinData.getCityName()%>
		</div>
		<div class="fnt">
			<%=resultYubinData.getTownAreaName()%>
		</div>
		<div class="fnt">
			<%=Normalizer.normalize(resultYubinData.getTownAreaNameKana(), Normalizer.Form.NFKC)%>
		</div>
		<div>
			<form method="post" name="toTop" action="/yubin/Yubin">
			<input type="submit" name="town" value="再検索">
    		</form>
		</div>
	</div>
</body>
</html>