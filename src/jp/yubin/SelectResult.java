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
 * Servlet implementation class SelectResult
 */
@WebServlet("/Result")
public class SelectResult extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectResult() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("[SelectResult.java]doPostIn!");
		request.setCharacterEncoding("UTF-8");

		String townCode = request.getParameter("townCode");

		HttpSession session = request.getSession();
		String prefecturesCode = (String)session.getAttribute("prefecturesCode");
		String cityCode = (String)session.getAttribute("cityCode");

		System.out.println("[SelectResult.java]prefecturesCode = " + prefecturesCode);
		System.out.println("[SelectResult.java]cityCode = " + cityCode);
		System.out.println("[SelectResult.java]townCode = " + townCode);

		//検索結果データを取得
		YubinCsvData resultYubinData = searchResult(prefecturesCode, cityCode, townCode, (ArrayList<YubinCsvData>)session.getAttribute("yubinData"));
		session.setAttribute("resultYubinData", resultYubinData);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/SelectResult.jsp");
		dispatcher.forward(request, response);
		//doGet(request, response);
	}

	protected YubinCsvData searchResult(String prefecturesCode, String cityCode, String townCode, List<YubinCsvData> yubinData)
	{
		System.out.println("[SelectTownArea.java]searchTownIn!");
		System.out.println("[SelectTownArea.java]prefecturesCode = " + prefecturesCode);
		System.out.println("[SelectTownArea.java]cityCode = " + cityCode);
		System.out.println("[SelectTownArea.java]townCode = " + townCode);
		System.out.println("[SelectTownArea.java]PrefecturesCode = " + yubinData.get(0).getPrefecturesCode());

		YubinCsvData resultYubinData = null;

		for(int i = 0; i < yubinData.size(); i++)
		{
			//yubinData(i)にある都道府県と市区町村がprefecturesCodeとcityCodeと等しい場合
			if(yubinData.get(i).getPrefecturesCode().equals(prefecturesCode) && yubinData.get(i).getCityCode().equals(cityCode) && yubinData.get(i).getTownAreaCode().equals(townCode))
			{
				resultYubinData = new YubinCsvData();
				resultYubinData.setPrefecturesCode(yubinData.get(i).getPrefecturesCode());
				resultYubinData.setCityCode(yubinData.get(i).getCityCode());
				resultYubinData.setTownAreaCode(yubinData.get(i).getTownAreaCode());
				resultYubinData.setPostalCode(yubinData.get(i).getPostalCode());
				resultYubinData.setPrefecturesName(yubinData.get(i).getPrefecturesName());
				resultYubinData.setCityName(yubinData.get(i).getCityName());
				resultYubinData.setTownAreaName(yubinData.get(i).getTownAreaName());
				resultYubinData.setPrefecturesNameKana(yubinData.get(i).getPrefecturesNameKana());
				resultYubinData.setCityNameKana(yubinData.get(i).getCityNameKana());
				resultYubinData.setTownAreaNameKana(yubinData.get(i).getTownAreaNameKana());
			}
		}

		return resultYubinData;
	}

}