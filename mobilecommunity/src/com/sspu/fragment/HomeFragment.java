package com.sspu.fragment;

import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.FragmentById;
import org.androidannotations.annotations.UiThread;
import org.androidannotations.annotations.ViewById;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;

import com.sspu.adapter.HomeBottomGvAdapter;
import com.sspu.adapter.HomeListviewAdapter;
import com.sspu.adapter.HomeTopGvAdapter;
import com.sspu.application.MyApplication;
import com.sspu.bean.CapitalBean;
import com.sspu.bean.CapticalListBean;
import com.sspu.mobilecommunity.R;
import com.sspu.requestapi.RequestJsonData;

/**
 * 
 * @author zhangyanyi
 * @disc 主页fragment
 */
@EFragment
public class HomeFragment extends Fragment {

	
//	@ViewById(R.id.captical_listview)
	public ListView captical_listview;
	
	private Button captical_btn;
	
	public ImageView captical_top_img;

	public GridView captical_top_gv;
	private HomeTopGvAdapter homeTopGvAdapter;
	
	public GridView captical_bottom_gv;
	private HomeBottomGvAdapter homeBottomGvAdapter;
	private HomeListviewAdapter homeListviewAdapter;
	
	private View homeHeader;
	private View homeFooter;
	
	public String url="http://api191.yinwan.bangqu.com/homepage/list.json";
	@Override
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		 View view = inflater.inflate(R.layout.frag_home, container, false);
		 
//		 homeHeader = inflater.inflate(R.layout.home_list_header, null);
//		 ViewUtils.inject(this, homeHeader);
//		 System.out.println(444);
				 
	     return view;
				
	}

	/**
	 * 填充listview的头和尾然后万恶的findviewbyid！！
	 */
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
    	// TODO Auto-generated method stub
    	super.onActivityCreated(savedInstanceState);
    	
    	captical_listview=(ListView) getView().findViewById(R.id.captical_listview);
    	
    	LayoutInflater inflater = (LayoutInflater) getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		homeHeader =inflater.inflate(R.layout.home_list_header, null);
		 
		homeFooter =inflater.inflate(R.layout.home_list_footer, null);
		
		captical_top_img=(ImageView) homeHeader.findViewById(R.id.captical_top_img);
		captical_top_gv=(GridView) homeHeader.findViewById(R.id.captical_top_gv);
		captical_bottom_gv=(GridView) homeHeader.findViewById(R.id.captical_bottom_gv);
		
		captical_btn=(Button) homeFooter.findViewById(R.id.captical_btn);
    	
    	getData(url);
    }
	
//	@AfterViews
//	void afterView(){
//		getData(url);//请求网路数据
//	}
	
    /**
     * 从网络获取数据
     * @param url
     */
	private void getData(String url) {
		
		new RequestJsonData().getData(url, CapitalBean.class);
		
	}
	
	/**
	 *
	 * @desc activity的生命周期开始的方法，用来注册事件总线bus
	 */
	@Override
	public void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		System.out.println(555);
		
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
	
	//接收总线bus post过来的数据
	/**
	 * 根据bus post过来的数据部，署两个header里两个gridview的数据
	 * @param capital
	 */
	@UiThread
	public void onEvent(CapitalBean capital) {
		
		System.out.println(capital);
		
		if (homeTopGvAdapter == null) {
			homeTopGvAdapter=new HomeTopGvAdapter(capital.homes, getActivity());
			captical_top_gv.setAdapter(homeTopGvAdapter);
		} else {
			homeTopGvAdapter.notifyDataSetChanged();
		}
		
		System.out.println(capital.categories.size());
		
		if (homeBottomGvAdapter == null) {
			homeBottomGvAdapter=new HomeBottomGvAdapter(capital.categories, getActivity());
			captical_bottom_gv.setAdapter(homeBottomGvAdapter);
		} else {
			homeBottomGvAdapter.notifyDataSetChanged();
		}
		
		if (captical_listview.getHeaderViewsCount()<1) {			
			captical_listview.addHeaderView(homeHeader);
		}
		if (captical_listview.getFooterViewsCount()<1) {			
			captical_listview.addFooterView(homeFooter);
		}
		
		
		CapticalListBean capticalListBean=new CapticalListBean();
				
		if (homeListviewAdapter == null) {
			homeListviewAdapter=new HomeListviewAdapter(capticalListBean.stores, getActivity());
			captical_listview.setAdapter(homeListviewAdapter);
		} else {
			homeListviewAdapter.notifyDataSetChanged();
		}
		
	}
}
