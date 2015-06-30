package com.sspu.adapter;

import com.sspu.mobilecommunity.R;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

/**
 * 
 * @author zhangyanyi
 * @disc 欢迎界面viewgroup 适配器
 */
public class WelcomePageAdapter extends PagerAdapter {

	private Context context;
	private Integer[] picture;

	public WelcomePageAdapter(Context context, Integer[] picture) {
		super();
		this.context = context;
		this.picture = picture;
	}

	@Override
	public int getCount() {
		return picture.length;
	}

	@Override
	public boolean isViewFromObject(View arg0, Object arg1) {
		return arg0 == arg1;
	}

	@Override
	public void destroyItem(ViewGroup container, int position, Object object) {
		// TODO Auto-generated method stub
		((ViewPager) container).removeView((View) object);
	}

	@Override
	public Object instantiateItem(ViewGroup container, int position) {
		View view = View.inflate(context, R.layout.welcome_item, null);

		((ViewPager) container).addView(view);

		RelativeLayout welcom_item_view = (RelativeLayout) view.findViewById(R.id.welcom_item_view);
		welcom_item_view.setBackgroundResource(picture[position]);
		return view;
	}

}
