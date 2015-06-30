package com.sspu.bean;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * 
 * @author zhangyanyi
 * @disc CapitalBean的对象数组categories的类
 */
public class Category {
	
	@Expose
	@SerializedName("img")
	public String img;
	
	@Expose
	@SerializedName("name")
	public String name;
}
