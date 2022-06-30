package ex;

public class Fruit implements java.io.Serializable {
	
	/*--フィールド--*/
	private String name;
	private int price;
	
	/*--コンストラクタ--*/
	public Fruit() {}
	
	public Fruit(String name , int price) {
		this.name = name;
		this.price = price;
	}
	
	/*--アクセサ--*/
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return this.price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

}
