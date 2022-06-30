//3つのサイコロが全て1になるまでのリスト作成クラス

package model;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DiceLogic{
	
	//1がでるまでのサイコロの状態をリストで返す
	public static List<Dice> execute(){
		int dice1;
		int dice2;
		int dice3;
		
		//diceインスタンスを格納するListを作成する
		List<Dice> dices = new ArrayList<Dice>();
		
		do {
			//サイコロを3回振る
			dice1 = new Random().nextInt(6)+1;
			dice2 = new Random().nextInt(6)+1;
			dice3 = new Random().nextInt(6)+1;
			
			//各サイコロの状態を表すDiceインスタンスを生成
			Dice dice = new Dice(dice1,dice2,dice3);
			
			//diceインスタンスをリストへ加える
			dices.add(dice);
					
		}while(dice1 != 1 || dice2 != 1 || dice3 != 1);	//各出目が1以外だったらループ
		
		return dices;
	}
}
