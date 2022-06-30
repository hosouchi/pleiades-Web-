package model;

import java.util.List;

public class PostMutterLogic {

	//つぶやきリストの一番最初へ、最新のつぶやきを追加する
	
	public void execute(Mutter mutter,List<Mutter> mutterList) {
		
		//今まで使ってきたadd()だと、一番後ろにデータが登録されてしまう
		mutterList.add(0,mutter);
	}
}
