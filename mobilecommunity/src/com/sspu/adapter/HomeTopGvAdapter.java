package com.sspu.adapter;

import java.util.ArrayList;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.lidroid.xutils.BitmapUtils;
import com.sspu.bean.Home;
import com.sspu.mobilecommunity.R;

public class HomeTopGvAdapter extends BaseAdapter {

	private ArrayList<Home> homes;
	private Context context;

	public HomeTopGvAdapter(ArrayList<Home> homes, Context context) {
		super();
		this.homes = homes;
		this.context = context;
		
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return homes.size();
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
		Home home=homes.get(position);
		convertView=View.inflate(context, R.layout.home_item, null);
		ImageView capital_home_item_img=(ImageView) convertView.findViewById(R.id.capital_home_item_img);
		TextView capital_home_item_toptxt=(TextView) convertView.findViewById(R.id.capital_home_item_toptxt);
		capital_home_item_toptxt.setTextColor(Color.parseColor(home.color));
		TextView capital_home_item_bottomtxt=(TextView) convertView.findViewById(R.id.capital_home_item_bottomtxt);
		capital_home_item_toptxt.setText(home.title);
		capital_home_item_bottomtxt.setText(home.content);
		
		BitmapUtils bitmapUtils = new BitmapUtils(context);
		
		bitmapUtils.display(capital_home_item_img, home.img);
		
		return convertView;
	}

}
