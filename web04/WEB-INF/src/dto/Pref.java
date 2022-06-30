package dto;

public class Pref {
	
	/*---フィールド---*/
	private String code;				//コード
	private String region;			//地域
	private String prefname;		//都道府県名
	private String prefcapital;		//県庁所在地
	private int area;				//面積
	
	/*---コンストラクタ---*/
	public Pref(String code, String region, String prefname, String prefcapital, int area ) {
		this.code = code;
		this.region = region;
		this.prefname = prefname;
		this.prefcapital = prefcapital;
		this.area = area;
	}
	
	/*---アクセサ---*/
	public String getCode() {
		return this.code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getRegion() {
		return this.region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public String getPrefName() {
		return this.prefname;
	}
	public void setPrefName(String prefname) {
		this.prefname = prefname;
	}
	public String getPrefCapital() {
		return this.prefcapital;
	}
	public void setPrefCapital(String prefCapital) {
		this.prefcapital = prefCapital;
	}
	public int getArea() {
		return this.area;
	}
	public void setArea(int area) {
		this.area = area;
	}
	
	

}
