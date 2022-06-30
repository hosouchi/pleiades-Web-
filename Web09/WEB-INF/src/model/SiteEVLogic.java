package model;

public class SiteEVLogic {
		
		//いいねのカウント用
		public void like(SiteEV site) {
			int count = site.getLike();
			site.setLike(count + 1);
		}
		
		//よくないねのカウント用
		public void unlike(SiteEV site) {
			int count = site.getUnlike();
			site.setUnlike(count + 1);
		}
}
