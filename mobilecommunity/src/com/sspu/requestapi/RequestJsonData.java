package com.sspu.requestapi;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.lidroid.xutils.HttpUtils;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.lidroid.xutils.http.client.HttpRequest.HttpMethod;
import com.sspu.application.MyApplication;
/**
 * 
 * @author caikaijie
 * @desc 封装的从网络获取数据并转换成相应的类对象
 */
public class RequestJsonData {

	public RequestJsonData() {
		super();
		
	}
   public <T> void getData(String url,final Class<T> obj){
	   HttpUtils http = new HttpUtils();
	   http.send(HttpMethod.GET, url, new RequestCallBack<String>() {

		@Override
		public void onFailure(HttpException arg0, String arg1) {
			// 获取失败
			
		}

		@Override
		public void onSuccess(ResponseInfo<String> arg0) {
			// 获取成功
			Gson gson= new Gson();		 
			T nObj;
			try {
				nObj= gson.fromJson(arg0.result,obj);
				//通过总线post到activity（哪个activity请求的就发送到哪个activity中的onEvent()）
				MyApplication.BUS.post(nObj);
			} catch (JsonSyntaxException e) {
				// 捕获异常
				MyApplication.BUS.post(e);
			}
		}
		   
	   });
   }
	
}
