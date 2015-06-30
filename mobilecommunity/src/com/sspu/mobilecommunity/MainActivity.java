package com.sspu.mobilecommunity;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.NoTitle;
import org.androidannotations.annotations.UiThread;
import org.androidannotations.annotations.ViewById;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.sspu.application.MyApplication;
import com.sspu.fragment.CenterFragment_;
import com.sspu.fragment.EstateFragmet;
import com.sspu.fragment.HomeFragment;
import com.sspu.fragment.HubFragment_;
@SuppressWarnings("deprecation")
@EActivity(R.layout.activity_main)
@NoTitle
public class MainActivity extends FragmentActivity {
	
   public static int INT_HOME=1;
   public static int INT_PROPERTY=2;
   public static int INT_HUB=3;
   public static int INT_CENTER=4;
   
   @ViewById(R.id.img_home)
   ImageView img_home;
   @ViewById(R.id.img_property)
   ImageView img_property;
   @ViewById(R.id.img_hub)
   ImageView img_hub;
   @ViewById(R.id.img_center)
   ImageView img_center;
	
   @ViewById(R.id.main_layout_frame)
   FrameLayout main_layout_frame;
   
	//首页点击事件
	@Click(R.id.linearLayout_home)
	void linearLayout_homeOnClick(){
		changeBackground(INT_HOME);
		//在这里替换上你们的fragment，代码如下
		
		System.out.println(1111);
		
		Fragment fragment=new HomeFragment();        
		getSupportFragmentManager().beginTransaction().replace(R.id.main_layout_frame, fragment).commit();
		
	}
	//物业点击事件
	@Click(R.id.linearLayout_proprty)
	void linearLayout_proprtyOnClick(){
		changeBackground(INT_PROPERTY);
         //在这里替换上你们的fragment，代码如下
		
         Fragment fragment=new EstateFragmet();        
         getSupportFragmentManager().beginTransaction().replace(R.id.main_layout_frame, fragment).commit();
		
	}
	//邻里会点击事件
	@Click(R.id.linearLayout_hub)
	void linearLayout_hubOnClick(){
		changeBackground(INT_HUB);
        //在这里替换上你们的fragment，代码如下
		
		
		Fragment fragment=new HubFragment_();
		getSupportFragmentManager().beginTransaction().replace(R.id.main_layout_frame, fragment).commit();
		
        // Fragment fragment=new GoodsDetailWordsFragment();
        // getFragmentManager().beginTransaction().replace(R.id.main_layout_frame, fragment).commit();
		
	}
	//业主中心点击事件
	@Click(R.id.linearLayout_center)
	void linearLayout_centerOnClick(){
		changeBackground(INT_CENTER);
        //在这里替换上你们的fragment，代码如下
		
         Fragment fragment=new CenterFragment_();
         getSupportFragmentManager().beginTransaction().replace(R.id.main_layout_frame, fragment).commit();
		
	}
	//视图加载之后调用
	@AfterViews
	void afterView(){
		Fragment fragment=new HomeFragment();        
		getSupportFragmentManager().beginTransaction().replace(R.id.main_layout_frame, fragment).commit();
	}
	//接收总线bus post过来的数据
	@UiThread
	public void onEvent(Object e){
		
	}
	/**
	 *
	 * @desc activity的生命周期开始的方法，用来注册事件总线bus
	 */
	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		MyApplication.BUS.register(this);
	}
	/**
	 * 
	 * @desc activity的生命周期结束的方法，用来取消事件总线bus
	 */
	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		super.onStop();
		MyApplication.BUS.unregister(this);
	}
	/**
	 * @desc 变换背景
	 * @param str
	 */
	private void changeBackground(int str) {
		// TODO Auto-generated method stub
		switch(str){
		case 1 :
			img_home.setBackgroundResource(R.drawable.btn_tool_home_pressed_red);
			img_property.setBackgroundResource(R.drawable.btn_tool_proprty_dark);
			img_hub.setBackgroundResource(R.drawable.btn_tool_ngb_dark);
			img_center.setBackgroundResource(R.drawable.btn_tool_person_dark);
			break;
		case 2 :
			img_home.setBackgroundResource(R.drawable.btn_tool_home_dark);
			img_property.setBackgroundResource(R.drawable.btn_tool_proprty_pressed_red);
			img_hub.setBackgroundResource(R.drawable.btn_tool_ngb_dark);
			img_center.setBackgroundResource(R.drawable.btn_tool_person_dark);
			break;
		case 3 :
			img_home.setBackgroundResource(R.drawable.btn_tool_home_dark);
			img_property.setBackgroundResource(R.drawable.btn_tool_proprty_dark);
			img_hub.setBackgroundResource(R.drawable.btn_tool_ngb_pressed_red);
			img_center.setBackgroundResource(R.drawable.btn_tool_person_dark);
			break;
		case 4 :
			img_home.setBackgroundResource(R.drawable.btn_tool_home_dark);
			img_property.setBackgroundResource(R.drawable.btn_tool_proprty_dark);
			img_hub.setBackgroundResource(R.drawable.btn_tool_ngb_dark);
			img_center.setBackgroundResource(R.drawable.btn_tool_person_pressed_red);
			break;
		}
	}
}
