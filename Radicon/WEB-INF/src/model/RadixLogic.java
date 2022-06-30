package model;

public class RadixLogic {

//	使用例：
//		1.Radix radix = new Radix(10);	//Radixインスタンス生成
//			この時
//				decimalフィールド：10
//				binaryフィールド：null
//				octフィールド：null
//				hexフィールド：null
//	
//		2.RadixLogic.calcRadix(radix);	//これを作成
//			この時
//				decimalフィールド：10
//				binaryフィールド："1010"
//				octフィールド："12"
//				hexフィールド："A"
//
	
	public static void calcRadix(Radix radix) {
		
		int decimal = radix.getDecimal();
		
		radix.setBinary(Integer.toBinaryString(decimal));	//decimalを2進数へ変換
		radix.setOct(Integer.toOctalString(decimal));		//decimalを8進数へ変換
		radix.setHex(Integer.toHexString(decimal));			//decimalを16進数へ変換
		
	}
}

