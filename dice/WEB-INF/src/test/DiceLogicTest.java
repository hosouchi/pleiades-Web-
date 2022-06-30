//DiceLogicをテストするクラス
package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import model.Dice;
import model.DiceLogic;

//Java実践編の12章を参考にする
public class DiceLogicTest {

	@Test
	public void executeTest() {
		
		//サイコロたくさん振る
		List<Dice> dices1 = DiceLogic.execute();
		
		//最後のサイコロの出目は全て1であるはずだ
		Dice lastDice = dices1.get(dices1.size()-1);
		
		assertEquals(1, lastDice.getDice1());
		assertEquals(1, lastDice.getDice2());
		assertEquals(1, lastDice.getDice3());
	}
}
