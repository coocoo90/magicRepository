package com.sspu.fragment;

import java.util.ArrayList;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.UiThread;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import com.sspu.adapter.WelcomePageAdapter;
import com.sspu.application.MyApplication;
import com.sspu.mobilecommunity.MainActivity_;
import com.sspu.mobilecommunity.R;
import com.sspu.utils.DensityUtil;

@EFragment(R.layout.welcome_page)
public class WelcomeFragment extends Fragment {

	public ViewPager welcome_pager;

	public LinearLayout welcome_dots;

	public Button welcome_btn;

	private ArrayList<View> dotList;

	private Integer[] picture = { R.drawable.wel_1, R.drawable.wel_2, R.drawable.wel_3, R.drawable.wel_4 };

	private WelcomePageAdapter welcomePageAdapter;

	// 视图加载之后调用

	@Override
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.welcome_page, container, false);
		return view;
	}

//	@Click(R.id.welcome_btn)
//	void transferToMainActivity(){
//		
//		System.out.println("切换activity");
//		
//	}
	
	@Override
	public void onActivityCreated(@Nullable Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);

		welcome_pager=(ViewPager) getView().findViewById(R.id.welcome_pager);
		welcome_dots=(LinearLayout) getView().findViewById(R.id.welcome_dots);
		welcome_btn=(Button) getView().findViewById(R.id.welcome_btn);
		
		welcome_btn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				Intent intent=new Intent(getActivity(), MainActivity_.class);
				startActivity(intent);
				getActivity().finish();
			}
		});
		
		dotList = new ArrayList<View>();

		for (int i = 0; i < picture.length; i++) {
			LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(DensityUtil.dip2px(getActivity(), 6), DensityUtil.dip2px(getActivity(), 6));
			params.setMargins(5, 0, 5, 0);
			View m = new View(getActivity());
			if (i == 0) {
				m.setBackgroundResource(R.drawable.dot_focus);
			} else {
				m.setBackgroundResource(R.drawable.dot_normal);
			}
			m.setLayoutParams(params);
			welcome_dots.addView(m);
			dotList.add(m);
		}

		if (welcomePageAdapter == null) {
			welcomePageAdapter = new WelcomePageAdapter(getActivity(), picture);
			welcome_pager.setAdapter(welcomePageAdapter);
		} else {
			welcomePageAdapter.notifyDataSetChanged();
		}

		welcome_pager.setOnPageChangeListener(new OnPageChangeListener() {

			int oldPosition = 0;

			@Override
			public void onPageSelected(int position) {

				System.out.println("oldposition=" + oldPosition);

				if (position == 3) {
					welcome_dots.setVisibility(View.GONE);
					welcome_btn.setVisibility(View.VISIBLE);
				}

				if (oldPosition == 3) {
					welcome_dots.setVisibility(View.VISIBLE);
					welcome_btn.setVisibility(View.GONE);
				}

				if (dotList != null && dotList.size() > 0) {
					dotList.get(position).setBackgroundResource(R.drawable.dot_focus);
					dotList.get(oldPosition).setBackgroundResource(R.drawable.dot_normal);
				}
				oldPosition = position;

			}

			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onPageScrollStateChanged(int arg0) {
				// TODO Auto-generated method stub

			}
		});

	}

	@AfterViews
	void afterView() {

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
