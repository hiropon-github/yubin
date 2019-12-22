<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="jp.yubin.YubinCsvData" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%
	//List<YubinCsvData> yubinData = (ArrayList<YubinCsvData>)session.getAttribute("yubinData");
	//if(yubinData == null)
	//{
	//	System.out.println("JSP yubinData is NULL!");
	//}
	//else
	//{
	//	System.out.println("[SelectCity.jsp]CityCode = " + yubinData.get(0).getCityCode());
	//}
%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="/yubin/css/styles.css">
<title>郵便番号検索</title>

</head>
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="/yubin/js/common.js" charset="UTF-8"></script>

<body>
	<div class="yubintop">
		<span class="yubinmain">郵便番号検索</span><span class="yubinsub">（市区町村選択画面）</span>
	</div>
	<div class="boxall">
		<div class="boxYubinSelect">
		あ行
		<label for="a_gyo"><input type="radio" name="radio" id="a_gyo" value="a_List"></label>
		<select id="a_List" name="cityCode">
		    <option value="0">-</option>
		    <% ArrayList<ArrayList<String>> a_gyo = (ArrayList<ArrayList<String>>)session.getAttribute("a_gyo"); %>
		    <% for(int i = 0; i < a_gyo.get(1).size(); i++){ %>
		    	<option value="<%=a_gyo.get(0).get(i)%>"><%=a_gyo.get(1).get(i)%></option>
		    <% } %>
		</select>
		</div>
		<div class="boxYubinSelect">
		か行
		<label for="ka_gyo"><input type="radio" name="radio" id="ka_gyo" value="ka_List"></label>
		<select id="ka_List" name="cityCode">
		    <option value="0">-</option>
		    <% ArrayList<ArrayList<String>> ka_gyo = (ArrayList<ArrayList<String>>)session.getAttribute("ka_gyo"); %>
		    <% for(int i = 0; i < ka_gyo.get(1).size(); i++){ %>
		    	<option value="<%=ka_gyo.get(0).get(i)%>"><%=ka_gyo.get(1).get(i)%></option>
		    <% } %>
		</select>
		</div>
		<div class="boxYubinSelect">
		さ行
		<label for="sa_gyo"><input type="radio" name="radio" id="sa_gyo" value="sa_List"></label>
		<select id="sa_List" name="cityCode">
		    <option value="0">-</option>
		    <% ArrayList<ArrayList<String>> sa_gyo = (ArrayList<ArrayList<String>>)session.getAttribute("sa_gyo"); %>
		    <% for(int i = 0; i < sa_gyo.get(1).size(); i++){ %>
		    	<option value="<%=sa_gyo.get(0).get(i)%>"><%=sa_gyo.get(1).get(i)%></option>
		    <% } %>
		</select>
		</div>
		<div class="boxYubinSelect">
		た行
		<label for="ta_gyo"><input type="radio" name="radio" id="ta_gyo" value="ta_List"></label>
		<select id="ta_List" name="cityCode">
		    <option value="0">-</option>
		    <% ArrayList<ArrayList<String>> ta_gyo = (ArrayList<ArrayList<String>>)session.getAttribute("ta_gyo"); %>
		    <% for(int i = 0; i < ta_gyo.get(1).size(); i++){ %>
		    	<option value="<%=ta_gyo.get(0).get(i)%>"><%=ta_gyo.get(1).get(i)%></option>
		    <% } %>
		</select>
		</div>
		<div class="boxYubinSelect">
		な行
		<label for="na_gyo"><input type="radio" name="radio" id="na_gyo" value="na_List"></label>
		<select id="na_List" name="cityCode">
		    <option value="0">-</option>
		    <% ArrayList<ArrayList<String>> na_gyo = (ArrayList<ArrayList<String>>)session.getAttribute("na_gyo"); %>
		    <% for(int i = 0; i < na_gyo.get(1).size(); i++){ %>
		    	<option value="<%=na_gyo.get(0).get(i)%>"><%=na_gyo.get(1).get(i)%></option>
		    <% } %>
		</select>
		</div>
		<div class="boxYubinSelect">
		は行
		<label for="ha_gyo"><input type="radio" name="radio" id="ha_gyo" value="ha_List"></label>
		<select id="ha_List" name="cityCode">
		    <option value="0">-</option>
		    <% ArrayList<ArrayList<String>> ha_gyo = (ArrayList<ArrayList<String>>)session.getAttribute("ha_gyo"); %>
		    <% for(int i = 0; i < ha_gyo.get(1).size(); i++){ %>
		    	<option value="<%=ha_gyo.get(0).get(i)%>"><%=ha_gyo.get(1).get(i)%></option>
		    <% } %>
		</select>
		</div>
		<div class="boxYubinSelect">
		ま行
		<label for="ma_gyo"><input type="radio" name="radio" id="ma_gyo" value="ma_List"></label>
		<select id="ma_List" name="cityCode">
		    <option value="0">-</option>
		    <% ArrayList<ArrayList<String>> ma_gyo = (ArrayList<ArrayList<String>>)session.getAttribute("ma_gyo"); %>
		    <% for(int i = 0; i < ma_gyo.get(1).size(); i++){ %>
		    	<option value="<%=ma_gyo.get(0).get(i)%>"><%=ma_gyo.get(1).get(i)%></option>
		    <% } %>
		</select>
		</div>
		<div class="boxYubinSelect">
		や行
		<label for="ya_gyo"><input type="radio" name="radio" id="ya_gyo" value="ya_List"></label>
		<select id="ya_List" name="cityCode">
		    <option value="0">-</option>
		    <% ArrayList<ArrayList<String>> ya_gyo = (ArrayList<ArrayList<String>>)session.getAttribute("ya_gyo"); %>
		    <% for(int i = 0; i < ya_gyo.get(1).size(); i++){ %>
		    	<option value="<%=ya_gyo.get(0).get(i)%>"><%=ya_gyo.get(1).get(i)%></option>
		    <% } %>
		</select>
		</div>
		<div class="boxYubinSelect">
		ら行
		<label for="ra_gyo"><input type="radio" name="radio" id="ra_gyo" value="ra_List"></label>
		<select id="ra_List" name="cityCode">
		    <option value="0">-</option>
		    <% ArrayList<ArrayList<String>> ra_gyo = (ArrayList<ArrayList<String>>)session.getAttribute("ra_gyo"); %>
		    <% for(int i = 0; i < ra_gyo.get(1).size(); i++){ %>
		    	<option value="<%=ra_gyo.get(0).get(i)%>"><%=ra_gyo.get(1).get(i)%></option>
		    <% } %>
		</select>
		</div>
		<div class="boxYubinSelect">
		わ行
		<label for="wa_gyo"><input type="radio" name="radio" id="wa_gyo" value="wa_List"></label>
		<select id="wa_List" name="cityCode">
		    <option value="0">-</option>
		    <% ArrayList<ArrayList<String>> wa_gyo = (ArrayList<ArrayList<String>>)session.getAttribute("wa_gyo"); %>
		    <% for(int i = 0; i < wa_gyo.get(1).size(); i++){ %>
		    	<option value="<%=wa_gyo.get(0).get(i)%>"><%=wa_gyo.get(1).get(i)%></option>
		    <% } %>
		</select>
		</div>
		<div>
			<form method="post" name="toTown" action="/yubin/Town">
			<input type="hidden" id="cityCode" name="cityCode" value="none">
			<input type="button" name="city" value="町域選択画面へ" onClick="townSubmit()">
	    	</form>
		</div>
	</div>
</body>
</html>