package com.sspu.adapter;

import java.util.ArrayList;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.lidroid.xutils.BitmapUtils;
import com.sspu.bean.CapticalListBean.Store;
import com.sspu.mobilecommunity.R;

public class HomeListviewAdapter extends BaseAdapter {

	private ArrayList<Store> stores;
	private Context context;

	public HomeListviewAdapter(ArrayList<Store> stores, Context context) {
		super();
		this.stores = stores;
		this.context = context;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return stores.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {

		ViewHolder holder = null;
		Store store = stores.get(position);

		if (convertView == null) {
			holder = new ViewHolder();
			convertView = View.inflate(context, R.layout.capital_list_item, null);
			holder.capital_list_item_img = (ImageView) convertView.findViewById(R.id.capital_list_item_img);
			holder.capital_list_item_title = (TextView) convertView.findViewById(R.id.capital_list_item_title);
			holder.capital_list_item_business_hours = (TextView) convertView.findViewById(R.id.capital_list_item_business_hours);
			holder.capital_list_item_price = (TextView) convertView.findViewById(R.id.capital_list_item_price);
			holder.capital_list_item_distance = (TextView) convertView.findViewById(R.id.capital_list_item_distance);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}
		//
		// holder.title.setText(news.title);
		//
		// if (news.isRead) {
		// holder.title.setTextColor(context.getResources().getColor(R.color.news_item_has_read_textcolor));
		// } else {
		// holder.title.setTextColor(context.getResources().getColor(R.color.news_item_no_read_textcolor));
		// }
		//
		// holder.pub_date.setText(news.pubdate);
		BitmapUtils bitmapUtil = new BitmapUtils(context);
		bitmapUtil.display(holder.capital_list_item_img, store.PictureUrl);

		return convertView;
	}

	class ViewHolder {
		ImageView capital_list_item_img;
		TextView capital_list_item_title;
		TextView capital_list_item_business_hours;
		TextView capital_list_item_price;
		TextView capital_list_item_distance;
	}

}
