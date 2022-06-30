package model;

public class EvMsgLogic {

	//IPアドレス表示用
	public String like(String ipAddr, String evMsg) {
		String msg = ipAddr + "よいね!<br>" + evMsg;
		return msg;
	}
	
	public String unlike(String ipAddr, String evMsg) {
		String msg = ipAddr + "よくないね<br>" + evMsg;
		return msg;
	}
}
