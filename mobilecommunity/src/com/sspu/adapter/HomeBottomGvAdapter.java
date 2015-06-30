package com.sspu.adapter;

import java.util.ArrayList;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.lidroid.xutils.BitmapUtils;
import com.sspu.bean.Category;
import com.sspu.mobilecommunity.R;

/**
 * 
 * @author zhangyanyi
 * @disc 主页第二个gridview适配器就是category的适配器
 */
public class HomeBottomGvAdapter extends BaseAdapter {

	private ArrayList<Category> categories;
	private Context context;



	public HomeBottomGvAdapter(ArrayList<Category> categories, Context context) {
		super();
		this.categories = categories;
		this.context = context;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return categories.size();
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
		Category category=categories.get(position);
		convertView=View.inflate(context, R.layout.category_item, null);
		ImageView capital_category_item_img=(ImageView) convertView.findViewById(R.id.capital_category_item_img);
		TextView capital_category_item_txt=(TextView) convertView.findViewById(R.id.capital_category_item_txt);
		capital_category_item_txt.setText(category.name);		
		BitmapUtils bitmapUtils = new BitmapUtils(context);
		
		bitmapUtils.display(capital_category_item_img, category.img);
		
		return convertView;
	}

}
