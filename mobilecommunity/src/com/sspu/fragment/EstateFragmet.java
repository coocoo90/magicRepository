package com.sspu.fragment;

import java.util.ArrayList;

import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.UiThread;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.sspu.adapter.EstateServiceAdapter;
import com.sspu.application.MyApplication;
import com.sspu.bean.EstateService;
import com.sspu.mobilecommunity.R;

/**
 * 
 * @author zhangyanyi
 * @disc 物业fragment 
 */

@EFragment
public class EstateFragmet extends Fragment {

	public GridView estate_base_service_gv;

	public GridView estate_extra_service_gv;

	private ArrayList<EstateService> estateServices = new ArrayList<EstateService>();
	private ArrayList<EstateService> estateExtraServices = new ArrayList<EstateService>();

	private EstateServiceAdapter estateServiceAdapter;
	private EstateServiceAdapter estateServiceAdapterExtra;

	/**
	 * @author caikaijie (Magic:明明老夫写的！！！ )
	 * @desc 物业
	 */

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.frag_estate, null);

		return view;

	}

	@Override
	public void onActivityCreated(@Nullable Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);

		estate_base_service_gv = (GridView) getView().findViewById(R.id.estate_base_service_gv);
		estate_extra_service_gv = (GridView) getView().findViewById(R.id.estate_extra_service_gv);
		
		initData();
	}

	/**
	 * 加载两个gridview的数据
	 */
	private void initData() {
		
		estateServices.add(new EstateService("物业缴费",R.drawable.btn_company_pay));
		estateServices.add(new EstateService("物业报修",R.drawable.btn_service_pressed));
		estateServices.add(new EstateService("意见反馈",R.drawable.btn_suggestion));
		estateServices.add(new EstateService("访客通行",R.drawable.wuye_19));
		
		if (estateServiceAdapter == null) {
			estateServiceAdapter=new EstateServiceAdapter(estateServices, getActivity());
			estate_base_service_gv.setAdapter(estateServiceAdapter);
		} else {
			estateServiceAdapter.notifyDataSetChanged();
		}
		
		estateExtraServices.add(new EstateService("手机充值",R.drawable.btn_mobile));
		estateExtraServices.add(new EstateService("水电煤",R.drawable.btn_water));
		estateExtraServices.add(new EstateService("加油卡",R.drawable.mine_item_2));
		
		if (estateServiceAdapterExtra == null) {
			estateServiceAdapterExtra=new EstateServiceAdapter(estateExtraServices, getActivity());
			estate_extra_service_gv.setAdapter(estateServiceAdapterExtra);
		} else {
			estateServiceAdapterExtra.notifyDataSetChanged();
		}
		
	}

	@Override
	public void onStart() {
		super.onStart();
		MyApplication.BUS.register(this);
	}

	// activity的生命周期方法
	@Override
	public void onStop() {
		super.onStop();
		MyApplication.BUS.unregister(this);
	}

	@UiThread
	public void onEvent(Object e) {

	}

}
