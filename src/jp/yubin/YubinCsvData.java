package jp.yubin;

import java.io.Serializable;

public class YubinCsvData implements Serializable{
    private String prefecturesCode;                    //都道府県コード
    private String cityCode;                                   //市区町村コード
    private String townAreaCode;                               //町域コード
    private String postalCode;                              //郵便番号
    private String prefecturesName;                 //都道府県名
    private String cityName;                                //市区町村名
    private String townAreaName;                    //町域名
    private String prefecturesNameKana;             //都道府県名カナ
    private String cityNameKana;                    //市区町村名カナ
    private String townAreaNameKana;                //町域名カナ

    public YubinCsvData()
    {

    }

    public void setPrefecturesCode(String prefecturesCode)
    {
            this.prefecturesCode = prefecturesCode;
    }
    public void setCityCode(String cityCode)
    {
            this.cityCode = cityCode;
    }
    public void setTownAreaCode(String townAreaCode)
    {
            this.townAreaCode = townAreaCode;
    }
    public void setPostalCode(String postalCode)
    {
    		if(!(postalCode.contains("-")))
    		{
    			StringBuilder sb = new StringBuilder();
    			sb.append(postalCode);
    			sb.insert(3, "-");
    			postalCode = sb.toString();
    		}
            this.postalCode = postalCode;
    }
    public void setPrefecturesName(String prefecturesName)
    {
            this.prefecturesName = prefecturesName;
    }
    public void setCityName(String cityName)
    {
            this.cityName = cityName;
    }
    public void setTownAreaName(String townAreaName)
    {
            this.townAreaName = townAreaName;
    }
    public void setPrefecturesNameKana(String prefecturesNameKana)
    {
            this.prefecturesNameKana = prefecturesNameKana;
    }
    public void setCityNameKana(String cityNameKana)
    {
            this.cityNameKana = cityNameKana;
    }
    public void setTownAreaNameKana(String townAreaNameKana)
    {
            this.townAreaNameKana = townAreaNameKana;
    }


    public String getPrefecturesCode()
    {
            return this.prefecturesCode;
    }
    public String getCityCode()
    {
            return this.cityCode;
    }
    public String getTownAreaCode()
    {
            return this.townAreaCode;
    }
    public String getPostalCode()
    {
            return this.postalCode;
    }
    public String getPrefecturesName()
    {
            return this.prefecturesName;
    }
    public String getCityName()
    {
            return this.cityName;
    }
    public String getTownAreaName()
    {
            return this.townAreaName;
    }
    public String getPrefecturesNameKana()
    {
            return this.prefecturesNameKana;
    }
    public String getCityNameKana()
    {
            return this.cityNameKana;
    }
    public String getTownAreaNameKana()
    {
            return this.townAreaNameKana;
    }
}