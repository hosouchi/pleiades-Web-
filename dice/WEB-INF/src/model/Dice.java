//サイコロ、３個の各出目をあらわすクラス

package model;

import java.io.Serializable;

public class Dice implements Serializable {
	
	/*--フィールド--*/
	private int dice1;	//1~6の出目
	private int dice2;	//1~6の出目
	private int dice3;	//1~6の出目
	
	/*--コンストラクタ--*/
	public Dice() {};
	
	//サイコロを振った後の状態を一括で保存するためのコンストラクタ
	public Dice(int dice1, int dice2, int dice3) {
		this.dice1 = dice1;
		this.dice2 = dice2;
		this.dice3 = dice3;
	}
	
	/*--アクセサ--*/
	public int getDice1() {
		return this.dice1;
	}
	public void setDice1(int dice1) {
		this.dice1 = dice1;
	}
	public int getDice2() {
		return this.dice2;
	}
	public void setDice2(int dice2) {
		this.dice2 = dice2;
	}
	public int getDice3() {
		return this.dice3;
	}
	public void setDice3(int dice3) {
		this.dice3 = dice3;
	}
}
