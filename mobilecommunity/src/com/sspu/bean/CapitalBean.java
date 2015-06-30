package com.sspu.bean;

import java.util.ArrayList;


import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.EBean.Scope;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
/**
 * 
 * @author zhangyanyi
 * @disc 主页json数据的bean
 */

@EBean(scope=Scope.Singleton)
public class CapitalBean {
	
	//下面这两行@开头的，要写上。括号里的字段是json数据里的名称
    @Expose
    @SerializedName("categories")
	public ArrayList<Category> categories;
    
    @Expose
    @SerializedName("homes")
    public ArrayList<Home> homes;
}
