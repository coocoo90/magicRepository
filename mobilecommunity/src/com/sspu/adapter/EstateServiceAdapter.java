package com.sspu.adapter;

import java.util.ArrayList;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.sspu.bean.EstateService;
import com.sspu.mobilecommunity.R;

/**
 * 
 * @author zhangyanyi
 * @disc 物业界面两个gridview的适配器
 *
 */
public class EstateServiceAdapter extends BaseAdapter {

	private ArrayList<EstateService> estateServices;
	private Context context;
	
	
	
	public EstateServiceAdapter(ArrayList<EstateService> estateServices, Context context) {
		super();
		this.estateServices = estateServices;
		this.context = context;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return estateServices.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		
		EstateService estateService=estateServices.get(position);
		convertView=View.inflate(context, R.layout.service_item, null);
		
		ImageView estate_service_img=(ImageView) convertView.findViewById(R.id.estate_service_img);
		TextView estate_service_txt=(TextView) convertView.findViewById(R.id.estate_service_txt);
		
		estate_service_img.setImageResource(estateService.picture);
		estate_service_txt.setText(estateService.discribe);
		estate_service_txt.setTextColor(context.getResources().getColor(R.color.darker_gray));
		
		return convertView;
	}

}
