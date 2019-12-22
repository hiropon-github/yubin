<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="jp.yubin.YubinCsvData" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%
	//List<YubinCsvData> yubinData = (ArrayList<YubinCsvData>)session.getAttribute("yubinData");
	boolean isSuccess = (boolean)session.getAttribute("isSuccess");

	//System.out.println("[SelectPrefectures.jsp]In");
	//System.out.println("[SelectPrefectures.jsp]PrefecturesCode = " + yubinData.get(0).getPrefecturesCode());
	//System.out.println("[SelectPrefectures.jsp]isSuccess = " + isSuccess);

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
<script type="text/javascript">
	csvReadCheck("<%=isSuccess%>");
</script>

	<div class="yubintop">
		<span class="yubinmain">郵便番号検索</span><span class="yubinsub">（都道府県選択画面）</span>
	</div>
	<div class="boxall">
		<div class="boxContainer">
			<div class="box">
				<form method="post" name="hokkaido" action="/yubin/City">
	    		<input type="hidden" name="prefecturesCode" value="01">
	    		<a href="javascript:hokkaido.submit()">北海道</a>
				</form>
			</div>
		</div>
		<div class="boxContainer">
			<div class="box">
				<form method="post" name="aomori" action="/yubin/City">
	    		<input type="hidden" name="prefecturesCode" value="02">
	    		<a href="javascript:aomori.submit()">青森</a>
				</form>
			</div>
			<div class="box">
				<form method="post" name="iwate" action="/yubin/City">
	    		<input type="hidden" name="prefecturesCode" value="03">
	    		<a href="javascript:iwate.submit()">岩手</a>
				</form>
			</div>
			<div class="box">
				<form method="post" name="miyagi" action="/yubin/City">
	    		<input type="hidden" name="prefecturesCode" value="04">
	    		<a href="javascript:miyagi.submit()">宮城</a>
				</form>
			</div>
			<div class="box">
				<form method="post" name="akita" action="/yubin/City">
	    		<input type="hidden" name="prefecturesCode" value="05">
	    		<a href="javascript:akita.submit()">秋田</a>
				</form>
			</div>
			<div class="box">
				<form method="post" name="yamagata" action="/yubin/City">
	    		<input type="hidden" name="prefecturesCode" value="06">
	    		<a href="javascript:yamagata.submit()">山形</a>
				</form>
			</div>
			<div class="box">
				<form method="post" name="fukushima" action="/yubin/City">
	    		<input type="hidden" name="prefecturesCode" value="07">
	    		<a href="javascript:fukushima.submit()">福島</a>
				</form>
			</div>
		</div>

		<div class="boxContainer">
			<div class="box">
				<form method="post" name="tokyo" action="/yubin/City">
	    		<input type="hidden" name="prefecturesCode" value="13">
	    		<a href="javascript:tokyo.submit()">東京</a>
				</form>
			</div>
			<div class="box">
				<form method="post" name="ibaraki" action="/yubin/City">
	    		<input type="hidden" name="prefecturesCode" value="08">
	    		<a href="javascript:ibaraki.submit()">茨城</a>
				</form>
			</div>
			<div class="box">
				<form method="post" name="kanagawa" action="/yubin/City">
	    		<input type="hidden" name="prefecturesCode" value="14">
	    		<a href="javascript:kanagawa.submit()">神奈川</a>
				</form>
			</div>
			<div class="box">
				<form method="post" name="tochigi" action="/yubin/City">
	    		<input type="hidden" name="prefecturesCode" value="09">
	    		<a href="javascript:tochigi.submit()">栃木</a>
				</form>
			</div>
			<div class="box">
				<form method="post" name="chiba" action="/yubin/City">
	    		<input type="hidden" name="prefecturesCode" value="12">
	    		<a href="javascript:chiba.submit()">千葉</a>
				</form>
			</div>
			<div class="box">
				<form method="post" name="gumma" action="/yubin/City">
	    		<input type="hidden" name="prefecturesCode" value="10">
	    		<a href="javascript:gumma.submit()">群馬</a>
				</form>
			</div>
			<div class="box">
				<form method="post" name="yamanashi" action="/yubin/City">
	    		<input type="hidden" name="prefecturesCode" value="19">
	    		<a href="javascript:yamanashi.submit()">山梨</a>
				</form>
			</div>
			<div class="box">
				<form method="post" name="saitama" action="/yubin/City">
	    		<input type="hidden" name="prefecturesCode" value="11">
	    		<a href="javascript:saitama.submit()">埼玉</a>
				</form>
			</div>
		</div>

		<div class="boxContainer">
			<div class="box">
				<form method="post" name="niigata" action="/yubin/City">
	    		<input type="hidden" name="prefecturesCode" value="15">
	    		<a href="javascript:niigata.submit()">新潟</a>
				</form>
			</div>
			<div class="box">
				<form method="post" name="nagano" action="/yubin/City">
	    		<input type="hidden" name="prefecturesCode" value="20">
	    		<a href="javascript:nagano.submit()">長野</a>
				</form>
			</div>
			<div class="box">
				<form method="post" name="toyama" action="/yubin/City">
	    		<input type="hidden" name="prefecturesCode" value="16">
	    		<a href="javascript:toyama.submit()">富山</a>
				</form>
			</div>
			<div class="box">
				<form method="post" name="ishikawa" action="/yubin/City">
	    		<input type="hidden" name="prefecturesCode" value="17">
	    		<a href="javascript:ishikawa.submit()">石川</a>
				</form>
			</div>
			<div class="box">
				<form method="post" name="fukui" action="/yubin/City">
	    		<input type="hidden" name="prefecturesCode" value="18">
	    		<a href="javascript:fukui.submit()">福井</a>
				</form>
			</div>
		</div>

		<div class="boxContainer">
			<div class="box">
				<form method="post" name="shizuoka" action="/yubin/City">
	    		<input type="hidden" name="prefecturesCode" value="22">
	    		<a href="javascript:shizuoka.submit()">静岡</a>
				</form>
			</div>
			<div class="box">
				<form method="post" name="gifu" action="/yubin/City">
	    		<input type="hidden" name="prefecturesCode" value="21">
	    		<a href="javascript:gifu.submit()">岐阜</a>
				</form>
			</div>
			<div class="box">
				<form method="post" name="aichi" action="/yubin/City">
	    		<input type="hidden" name="prefecturesCode" value="23">
	    		<a href="javascript:aichi.submit()">愛知</a>
				</form>
			</div>
			<div class="box">
				<form method="post" name="mie" action="/yubin/City">
	    		<input type="hidden" name="prefecturesCode" value="24">
	    		<a href="javascript:mie.submit()">三重</a>
				</form>
			</div>
		</div>

		<div class="boxContainer">
			<div class="box">
				<form method="post" name="shiga" action="/yubin/City">
	    		<input type="hidden" name="prefecturesCode" value="25">
	    		<a href="javascript:shiga.submit()">滋賀</a>
				</form>
			</div>
			<div class="box">
				<form method="post" name="kyoto" action="/yubin/City">
	    		<input type="hidden" name="prefecturesCode" value="26">
	    		<a href="javascript:kyoto.submit()">京都</a>
				</form>
			</div>
			<div class="box">
				<form method="post" name="hyogo" action="/yubin/City">
	    		<input type="hidden" name="prefecturesCode" value="28">
	    		<a href="javascript:hyogo.submit()">兵庫</a>
				</form>
			</div>
			<div class="box">
				<form method="post" name="osaka" action="/yubin/City">
	    		<input type="hidden" name="prefecturesCode" value="27">
	    		<a href="javascript:osaka.submit()">大阪</a>
				</form>
			</div>
			<div class="box">
				<form method="post" name="nara" action="/yubin/City">
	    		<input type="hidden" name="prefecturesCode" value="29">
	    		<a href="javascript:nara.submit()">奈良</a>
				</form>
			</div>
			<div class="box">
				<form method="post" name="wakayama" action="/yubin/City">
	    		<input type="hidden" name="prefecturesCode" value="30">
	    		<a href="javascript:wakayama.submit()">和歌山</a>
				</form>
			</div>
		</div>

		<div class="boxContainer">
			<div class="box">
				<form method="post" name="tottori" action="/yubin/City">
	    		<input type="hidden" name="prefecturesCode" value="31">
	    		<a href="javascript:tottori.submit()">鳥取</a>
				</form>
			</div>
			<div class="box">
				<form method="post" name="shimane" action="/yubin/City">
	    		<input type="hidden" name="prefecturesCode" value="32">
	    		<a href="javascript:shimane.submit()">島根</a>
				</form>
			</div>
			<div class="box">
				<form method="post" name="okayama" action="/yubin/City">
	    		<input type="hidden" name="prefecturesCode" value="33">
	    		<a href="javascript:okayama.submit()">岡山</a>
				</form>
			</div>
			<div class="box">
				<form method="post" name="hiroshima" action="/yubin/City">
	    		<input type="hidden" name="prefecturesCode" value="34">
	    		<a href="javascript:hiroshima.submit()">広島</a>
				</form>
			</div>
			<div class="box">
				<form method="post" name="yamaguchi" action="/yubin/City">
	    		<input type="hidden" name="prefecturesCode" value="35">
	    		<a href="javascript:yamaguchi.submit()">山口</a>
				</form>
			</div>
		</div>

		<div class="boxContainer">
			<div class="box">
				<form method="post" name="kagawa" action="/yubin/City">
	    		<input type="hidden" name="prefecturesCode" value="37">
	    		<a href="javascript:kagawa.submit()">香川</a>
				</form>
			</div>
			<div class="box">
				<form method="post" name="ehime" action="/yubin/City">
	    		<input type="hidden" name="prefecturesCode" value="38">
	    		<a href="javascript:ehime.submit()">愛媛</a>
				</form>
			</div>
			<div class="box">
				<form method="post" name="tokushima" action="/yubin/City">
	    		<input type="hidden" name="prefecturesCode" value="36">
	    		<a href="javascript:tokushima.submit()">徳島</a>
				</form>
			</div>
			<div class="box">
				<form method="post" name="kochi" action="/yubin/City">
	    		<input type="hidden" name="prefecturesCode" value="39">
	    		<a href="javascript:kochi.submit()">高知</a>
				</form>
			</div>
		</div>

		<div class="boxContainer">
			<div class="box">
				<form method="post" name="fukuoka" action="/yubin/City">
	    		<input type="hidden" name="prefecturesCode" value="40">
	    		<a href="javascript:fukuoka.submit()">福岡</a>
				</form>
			</div>
			<div class="box">
				<form method="post" name="saga" action="/yubin/City">
	    		<input type="hidden" name="prefecturesCode" value="41">
	    		<a href="javascript:saga.submit()">佐賀</a>
				</form>
			</div>
			<div class="box">
				<form method="post" name="nagasaki" action="/yubin/City">
	    		<input type="hidden" name="prefecturesCode" value="42">
	    		<a href="javascript:nagasaki.submit()">長崎</a>
				</form>
			</div>
			<div class="box">
				<form method="post" name="kumamoto" action="/yubin/City">
	    		<input type="hidden" name="prefecturesCode" value="43">
	    		<a href="javascript:kumamoto.submit()">熊本</a>
				</form>
			</div>
			<div class="box">
				<form method="post" name="oita" action="/yubin/City">
	    		<input type="hidden" name="prefecturesCode" value="44">
	    		<a href="javascript:oita.submit()">大分</a>
				</form>
			</div>
			<div class="box">
				<form method="post" name="miyazaki" action="/yubin/City">
	    		<input type="hidden" name="prefecturesCode" value="45">
	    		<a href="javascript:miyazaki.submit()">宮崎</a>
				</form>
			</div>
			<div class="box">
				<form method="post" name="kagoshima" action="/yubin/City">
	    		<input type="hidden" name="prefecturesCode" value="46">
	    		<a href="javascript:kagoshima.submit()">鹿児島</a>
				</form>
			</div>
		</div>

		<div class="boxContainer">
			<div class="box">
				<form method="post" name="okinawa" action="/yubin/City">
	    		<input type="hidden" name="prefecturesCode" value="47">
	    		<a href="javascript:okinawa.submit()">沖縄</a>
				</form>
			</div>
		</div>

	</div>
</body>
</html>