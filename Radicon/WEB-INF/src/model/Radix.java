package model;

//複数のデータを1つにまとめる

import java.io.Serializable;

public class Radix implements Serializable {
	
	/*--フィールド--*/
	private int decimal;		//10進数
	private String binary;		//2進数
	private String oct;			//8進数
	private String hex;			//16進数
	
	/*--コンストラクタ--*/
	public Radix() {}
	public Radix(int decimal) {
		this.setDecimal(decimal);
	}
	
	
	/*--アクセサ--*/
	public int getDecimal() {
		return this.decimal;
	}
	public void setDecimal(int decimal) {
		this.decimal = decimal;
	}
	
	public String getBinary() {
		return this.binary;
	}
	public void setBinary(String binary) {
		this.binary = binary;
	}
	
	public String getOct() {
		return this.oct;
	}
	public void setOct(String oct) {
		this.oct = oct;
	}
	
	public String getHex() {
		return this.hex;
	}
	public void setHex(String hex) {
		this.hex = hex;
	}
	
	

}
