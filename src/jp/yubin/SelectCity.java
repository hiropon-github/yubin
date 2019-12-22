package jp.yubin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class City
 */
@WebServlet("/City")
public class SelectCity extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectCity() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());

		//DEBUG
		//System.out.println("SelectCity.java doGet!");

		//RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/city.jsp");
		//dispatcher.forward(request, response);


	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);

		//DEBUG
		//System.out.println("[SelectCity.java]doPostIn!");

		request.setCharacterEncoding("UTF-8");

		String prefecturesCode = request.getParameter("prefecturesCode");

		//DEBUG
		//System.out.println("[SelectCity.java]value = " + prefecturesCode);

		HttpSession session = request.getSession();
		List<YubinCsvData> yubinData = (ArrayList<YubinCsvData>)session.getAttribute("yubinData");

		//セレクトボックス用の市区町村名を取得
		ArrayList<ArrayList<String>>  a_gyo = searchCity(prefecturesCode, (ArrayList<YubinCsvData>)session.getAttribute("yubinData"), "ｱｲｳｴｵ");
		ArrayList<ArrayList<String>> ka_gyo = searchCity(prefecturesCode, (ArrayList<YubinCsvData>)session.getAttribute("yubinData"), "ｶｷｸｹｺ");
		ArrayList<ArrayList<String>> sa_gyo = searchCity(prefecturesCode, (ArrayList<YubinCsvData>)session.getAttribute("yubinData"), "ｻｼｽｾｿ");
		ArrayList<ArrayList<String>> ta_gyo = searchCity(prefecturesCode, (ArrayList<YubinCsvData>)session.getAttribute("yubinData"), "ﾀﾁﾂﾃﾄ");
		ArrayList<ArrayList<String>> na_gyo = searchCity(prefecturesCode, (ArrayList<YubinCsvData>)session.getAttribute("yubinData"), "ﾅﾆﾇﾈﾉ");
		ArrayList<ArrayList<String>> ha_gyo = searchCity(prefecturesCode, (ArrayList<YubinCsvData>)session.getAttribute("yubinData"), "ﾊﾋﾌﾍﾎ");
		ArrayList<ArrayList<String>> ma_gyo = searchCity(prefecturesCode, (ArrayList<YubinCsvData>)session.getAttribute("yubinData"), "ﾏﾐﾑﾒﾓ");
		ArrayList<ArrayList<String>> ya_gyo = searchCity(prefecturesCode, (ArrayList<YubinCsvData>)session.getAttribute("yubinData"), "ﾔﾕﾖ");
		ArrayList<ArrayList<String>> ra_gyo = searchCity(prefecturesCode, (ArrayList<YubinCsvData>)session.getAttribute("yubinData"), "ﾗﾘﾙﾚﾛ");
		ArrayList<ArrayList<String>> wa_gyo = searchCity(prefecturesCode, (ArrayList<YubinCsvData>)session.getAttribute("yubinData"), "ﾜｦﾝ");
		session.setAttribute("a_gyo", a_gyo);
		session.setAttribute("ka_gyo", ka_gyo);
		session.setAttribute("sa_gyo", sa_gyo);
		session.setAttribute("ta_gyo", ta_gyo);
		session.setAttribute("na_gyo", na_gyo);
		session.setAttribute("ha_gyo", ha_gyo);
		session.setAttribute("ma_gyo", ma_gyo);
		session.setAttribute("ya_gyo", ya_gyo);
		session.setAttribute("ra_gyo", ra_gyo);
		session.setAttribute("wa_gyo", wa_gyo);
		session.setAttribute("prefecturesCode", prefecturesCode);

		//DEBUG
		//for(int i = 0; i < a_gyo.get(1).size(); i++)
		//{
		//	System.out.println(a_gyo.get(1).get(i));
		//}

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/SelectCity.jsp");
		dispatcher.forward(request, response);

	}

	protected ArrayList<ArrayList<String>> searchCity(String prefecturesCode, List<YubinCsvData> yubinData, String kanaIndex)
	{
		//DEBUG
		//System.out.println("[SelectCity.java]searchCityIn!");
		//System.out.println("[SelectCity.java]value = " + prefecturesCode);
		//System.out.println("[SelectCity.java]PrefecturesCode = " + yubinData.get(0).getPrefecturesCode());
		//System.out.println("[SelectCity.java]kanaIndex = " + kanaIndex);

		ArrayList<String> cityName = new ArrayList<String>();
		ArrayList<String> cityCode = null;

		for(int i = 0; i < yubinData.size(); i++)
		{
			//郵便番号が一致しているか
			if(yubinData.get(i).getPrefecturesCode().equals(prefecturesCode))
			{
				//各行の文字分ループ
				for(int j = 0; j < kanaIndex.length(); j++)
				{
					//カナの先頭が一致していたら
					if(yubinData.get(i).getCityNameKana().substring(0, 1).equals(kanaIndex.substring(j, j + 1)))
					{

						if(cityCode == null)
						{
							//1回のみのインスタンス化
							cityCode = new ArrayList<String>();
							cityCode.add(yubinData.get(i).getCityCode());
							cityName.add(yubinData.get(i).getCityName());

							//DEBUG
							//System.out.println(cityCode.get(0));
							//System.out.println(cityName.get(0));
							//System.out.println("cityCodeSize = " + cityCode.size());
						}
						else
						{
							//重複している市区町村があったら飛ばす。同一の市区町村を格納するのは1個で良い。
							if(!(cityCode.contains(yubinData.get(i).getCityCode())))
							{
								cityCode.add(yubinData.get(i).getCityCode());
								cityName.add(yubinData.get(i).getCityName());

								//DEBUG
								//System.out.println("[SelectCity.java]CityName = " + yubinData.get(i).getCityName());
								//System.out.println("[SelectCity.java]CityCode = " + yubinData.get(i).getCityCode());
							}
						}
					}
				}
			}
		}

		//戻り値用の市区町村コードと市区町村名を格納するリスト
		ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
		result.add(cityCode);
		result.add(cityName);

		return result;
	}

}
