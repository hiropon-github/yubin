package jp.yubin;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
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
 * Servlet implementation class Yubin
 */
@WebServlet("/Yubin")
public class SelectPrefectures extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectPrefectures() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		System.out.println("[SelectPrefectures.java]In");

		String view = "/WEB-INF/view/SelectPrefectures.jsp";

		//CSVファイル格納用クラス
		List<YubinCsvData> yubinData = new ArrayList<YubinCsvData>();

		//CSV読み込み成功フラグ
		boolean isSuccess = false;

		//CSV読み込み処理
        try{
                File file = new File("C:\\app\\pleiades\\workspace\\yubin\\data\\zenkoku.csv");
                BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file),"SJIS"));

                String line = br.readLine(); //1行単位の格納変数および先頭行飛ばし。
                String[] data = null;
                int i = 0;
                while((line = br.readLine()) != null)
                {
                		//ダブルクォーテーションを除外したものを格納
                		data = line.substring(1, line.length() - 1).split("\",\"");
                        yubinData.add(new YubinCsvData());
                        yubinData.get(i).setPrefecturesCode(data[0]);
                        yubinData.get(i).setCityCode(data[1]);
                        yubinData.get(i).setTownAreaCode(data[2]);
                        yubinData.get(i).setPostalCode(data[3]);
                        yubinData.get(i).setPrefecturesName(data[4]);
                        yubinData.get(i).setCityName(data[5]);
                        yubinData.get(i).setTownAreaName(data[6]);
                        yubinData.get(i).setPrefecturesNameKana(data[7]);
                        yubinData.get(i).setCityNameKana(data[8]);
                        yubinData.get(i).setTownAreaNameKana(data[9]);
                        i++;
                }

                br.close();
                isSuccess = true;


        }catch(IOException e){
                System.out.println(e);

        }

        HttpSession session = request.getSession();
        session.setAttribute("yubinData", yubinData);
        session.setAttribute("isSuccess", isSuccess);

		RequestDispatcher dispatcher = request.getRequestDispatcher(view);
		dispatcher.forward(request, response);

		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("[SelectPrefectures.java]In");

		String view = "/WEB-INF/view/SelectPrefectures.jsp";

		RequestDispatcher dispatcher = request.getRequestDispatcher(view);
		dispatcher.forward(request, response);
	}
}
