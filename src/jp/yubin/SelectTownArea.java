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
 * Servlet implementation class Town
 */
@WebServlet("/Town")
public class SelectTownArea extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectTownArea() {
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
		//System.out.println("Town.java doGet!");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//DEBUG
		//System.out.println("[SelectTownArea.java]doPostIn!");

		request.setCharacterEncoding("UTF-8");

		String cityCode = request.getParameter("cityCode");

		HttpSession session = request.getSession();
		String prefecturesCode = (String)session.getAttribute("prefecturesCode");

		//DEBUG
		//System.out.println("[SelectTownArea.java]prefecturesCode = " + prefecturesCode);
		//System.out.println("[SelectTownArea.java]cityCode = " + cityCode);

		//セレクトボックス用の町域名を取得
		ArrayList<ArrayList<String>>  a_gyo = searchTown(prefecturesCode, cityCode, (ArrayList<YubinCsvData>)session.getAttribute("yubinData"), "ｱｲｳｴｵ");
		ArrayList<ArrayList<String>> ka_gyo = searchTown(prefecturesCode, cityCode, (ArrayList<YubinCsvData>)session.getAttribute("yubinData"), "ｶｷｸｹｺ");
		ArrayList<ArrayList<String>> sa_gyo = searchTown(prefecturesCode, cityCode, (ArrayList<YubinCsvData>)session.getAttribute("yubinData"), "ｻｼｽｾｿ");
		ArrayList<ArrayList<String>> ta_gyo = searchTown(prefecturesCode, cityCode, (ArrayList<YubinCsvData>)session.getAttribute("yubinData"), "ﾀﾁﾂﾃﾄ");
		ArrayList<ArrayList<String>> na_gyo = searchTown(prefecturesCode, cityCode, (ArrayList<YubinCsvData>)session.getAttribute("yubinData"), "ﾅﾆﾇﾈﾉ");
		ArrayList<ArrayList<String>> ha_gyo = searchTown(prefecturesCode, cityCode, (ArrayList<YubinCsvData>)session.getAttribute("yubinData"), "ﾊﾋﾌﾍﾎ");
		ArrayList<ArrayList<String>> ma_gyo = searchTown(prefecturesCode, cityCode, (ArrayList<YubinCsvData>)session.getAttribute("yubinData"), "ﾏﾐﾑﾒﾓ");
		ArrayList<ArrayList<String>> ya_gyo = searchTown(prefecturesCode, cityCode, (ArrayList<YubinCsvData>)session.getAttribute("yubinData"), "ﾔﾕﾖ");
		ArrayList<ArrayList<String>> ra_gyo = searchTown(prefecturesCode, cityCode, (ArrayList<YubinCsvData>)session.getAttribute("yubinData"), "ﾗﾘﾙﾚﾛ");
		ArrayList<ArrayList<String>> wa_gyo = searchTown(prefecturesCode, cityCode, (ArrayList<YubinCsvData>)session.getAttribute("yubinData"), "ﾜｦﾝ");
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
		session.setAttribute("cityCode", cityCode);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/SelectTownArea.jsp");
		dispatcher.forward(request, response);
		//doGet(request, response);
	}

	protected ArrayList<ArrayList<String>> searchTown(String prefecturesCode, String cityCode, List<YubinCsvData> yubinData, String kanaIndex)
	{
		//DEBUG
		//System.out.println("[SelectTownArea.java]searchTownIn!");
		//System.out.println("[SelectTownArea.java]value = " + prefecturesCode);
		//System.out.println("[SelectTownArea.java]cityode = " + cityCode);
		//System.out.println("[SelectTownArea.java]PrefecturesCode = " + yubinData.get(0).getPrefecturesCode());
		//System.out.println("[SelectTownArea.java]kanaIndex = " + kanaIndex);

		ArrayList<String> townName = new ArrayList<String>();
		ArrayList<String> townCode = new ArrayList<String>();;
		int cityCodeCnt = 0;
		boolean isDup = false;

		for(int i = 0; i < yubinData.size(); i++)
		{
			//yubinData(i)にある都道府県と市区町村がprefecturesCodeとcityCodeと等しい場合
			if(yubinData.get(i).getPrefecturesCode().equals(prefecturesCode) && yubinData.get(i).getCityCode().equals(cityCode))
			{
				for(int j = 0; j < kanaIndex.length(); j++)
				{
					if(yubinData.get(i).getTownAreaNameKana().substring(0, 1).equals(kanaIndex.substring(j, j + 1)))
					{

						townCode.add(yubinData.get(i).getTownAreaCode());
						townName.add(yubinData.get(i).getTownAreaName());

						//DEBUG
						//System.out.println(townCode.get(0));
						//System.out.println(townName.get(0));
						//System.out.println("townAreaCodeSize = " + townCode.size());
					}
				}

			}
		}

		//DEBUG
		//System.out.println("[SelectTownArea.java]townCode size = " + townCode.size());

		//戻り値用の町域コードと町域名を格納するリスト
		ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
		result.add(townCode);
		result.add(townName);

		return result;
	}

}
