package com.sspu.mobilecommunity;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.UiThread;
import org.androidannotations.annotations.ViewById;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.FrameLayout;

import com.sspu.application.MyApplication;
import com.sspu.fragment.WelcomeFragment;

/**
 * 
 * @author zhangyanyi
 * @disc 引导页
 */
@EActivity(R.layout.welcome_logo)
public class WelcomeActivity extends FragmentActivity {

	@ViewById(R.id.welcome_flash)
	public FrameLayout welcome_flash;

	// 视图加载之后调用
	@AfterViews
	void afterView() {

		//淡入淡出动画
		AlphaAnimation anim = new AlphaAnimation(0.1f, 1.0f);
		anim.setDuration(3000);
		welcome_flash.startAnimation(anim);

		anim.setAnimationListener(new AnimationListener() {

			@Override
			public void onAnimationStart(Animation animation) {

			}

			@Override
			public void onAnimationRepeat(Animation animation) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onAnimationEnd(Animation animation) {
				// 动画执行结束的时候切换fragment去欢迎界面
				Fragment fragment=new WelcomeFragment();        
				getSupportFragmentManager().beginTransaction().replace(R.id.welcome_flash, fragment).commit();
			}
		});
		
	}

	// 接收总线bus post过来的数据
	@UiThread
	public void onEvent(Object e) {

	}

	@Override
	public void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		MyApplication.BUS.register(this);
	}

	/**
	 * 
	 * @desc activity的生命周期结束的方法，用来取消事件总线bus
	 */
	@Override
	public void onStop() {
		// TODO Auto-generated method stub
		super.onStop();
		MyApplication.BUS.unregister(this);
	}

}
