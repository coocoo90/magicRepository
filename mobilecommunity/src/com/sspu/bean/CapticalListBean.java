package com.sspu.bean;

import java.util.ArrayList;

/**
 * 
 * @author zhangyanyi
 * @disc 主页listview的bean（假数据！！！）
 */

public class CapticalListBean {

	public ArrayList<Store> stores;

	public CapticalListBean() {
		stores=new ArrayList<CapticalListBean.Store>();
		stores.add(new Store("http://img.yinwan.bangqu.com/2014/09/12/1410492071298"));
		stores.add(new Store("http://img.yinwan.bangqu.com/2014/09/26/1411718879609"));
		stores.add(new Store("http://img.yinwan.bangqu.com/2014/10/13/1413169154686"));
	}
	
	public class Store {
		public String PictureUrl;
		
		public Store(String PictureUrl) {
			this.PictureUrl=PictureUrl;
		}
	}
}
