package read;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import dto.Pref;


/*---prefs.csvからデータを読み取り、List<Pref>を返す--*/

public class ReadPrefsFile {
	
	public static ArrayList<Pref> readPrefs(){
		
		try (
			//STEP1:prefs.csvからデータを読み取る
				//絶対パスで指定
			FileReader fr = new FileReader("D:\\pleiades[Web]\\workspace\\Web04\\WEB-INF\\src\\read\\prefs.csv");
		
			//STEP2:ファイルの中身を1行ずつ読み込むためのフィルタ
			BufferedReader br = new BufferedReader(fr);
		){
			
			//STEP3:Prefインスタンスを格納していくArrayListを生成
			ArrayList<Pref> prefs = new ArrayList<>();
			
			//STEP4：ファイルから1行取得し、最終行までループする
			String data = null;
			boolean loop = true;
			
			do {
				//改行までの1行分のデータをStringで返す
				data = br.readLine();
				
				//全ての読み込みが終了したらnullが返ってくる
				if(data == null) {
					System.out.println("ファイルの読み込み終了");
					loop = false;
				}else {
					System.out.println(data);
					
					//STEP5:取得した文字列データをprefインスタンスへ変換
					
					//①dataを「,」で区切る
					String[] words = data.split("[,]");
					
					//②区切ったwordsをprefインスタンス生成
					Pref pref = new Pref(words[0], words[1], words[2], words[3], Integer.parseInt(words[4]));
					
					//STEP6:変換したprefインスタンスをArrayListへ格納
					prefs.add(pref);
				}
			}while(loop);
			
			//STEP7:ループを抜けたら、List（prefs）をリターンする
			return prefs;
			
		}
		catch(IOException e) {
			System.out.println("ファイルの読み込みに失敗しました。");
			return null;
		}
	}
}
