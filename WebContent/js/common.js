//<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>

var radioNo;


$(function(){

        //[初期値設定]ラジオボタンのチェックを外す
        $("input").prop("checked", false);

        //[初期値設定]セレクトボックスの選択を不可に
        $("select").prop("disabled", "disabled");

        //ラジオボタンクリック時処理
        $("input:radio").click(function(){
                //alert('あ行選択');
                radioNo = $(this).val();
                console.log("Click = " + radioNo);

                $("select#" + radioNo).removeProp("disabled");
        });

        //ラジオボタン切り替え時処理
        $("input:radio").change(function(){
                console.log("blur = " + radioNo);
                $("select#" + radioNo).prop("disabled", "disabled");
        });
});

//CSV読み込みチェック
function csvReadCheck(isSuccess){

	if(isSuccess == "false")
	{
		alert("CSVファイルの読み込みに失敗しました。");
	}

}

//選択している市区町村コードを取得し、町域ページへ値を渡す。
function townSubmit(){
	console.log("townSubmitIn");
	var c = document.getElementsByName("radio");
	var radio;
	var isChecked = false;
	var isSelected = false;
	var cityCode = document.getElementById("cityCode");

	//チェック済のラジオボタンを確認
	for(var i = 0; i < c.length; i++)
	{
		if(c[i].checked)
		{
			radio = c[i].value;
			isChecked = true;
			break;
		}
	}

	if(!isChecked)
	{
		alert("ラジオボタンを選択してください。");
		exit;
	}

	var result;
	var s = document.getElementById(radio);

	//選択しているセレクトボックス値の取得
	for(var i = 0; i < s.length; i++)
	{
		if(s[i].selected && s[i].value != "0")
		{
			cityCode.value = s[i].value;
			isSelected = true;
			break;
		}
	}

	if(!isSelected)
	{
		alert("市区町村を選択してください。");
		exit;
	}

	console.log("cityCode = " + cityCode.value);
	document.toTown.submit();
}

//選択している町域コードを取得し、検索結果ページへ値を渡す。
function resultSubmit(){
	console.log("resultSubmitIn");
	var c = document.getElementsByName("radio");
	var radio;
	var isChecked = false;
	var isSelected = false;
	var townCode = document.getElementById("townCode");

	//チェック済のラジオボタンを確認
	for(var i = 0; i < c.length; i++)
	{
		if(c[i].checked)
		{
			radio = c[i].value;
			isChecked = true;
			break;
		}
	}

	if(!isChecked)
	{
		alert("ラジオボタンを選択してください。");
		exit;
	}

	var result;
	var s = document.getElementById(radio);

	//選択しているセレクトボックス値の取得
	for(var i = 0; i < s.length; i++)
	{
		if(s[i].selected && s[i].value != "0")
		{
			townCode.value = s[i].value;
			isSelected = true;
			break;
		}
	}

	if(!isSelected)
	{
		alert("市区町村を選択してください。");
		exit;
	}

	console.log("townCode = " + townCode.value);
	document.toResult.submit();
}