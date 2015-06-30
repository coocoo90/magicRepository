package com.sspu.application;
import org.androidannotations.annotations.EApplication;
import de.greenrobot.event.EventBus;
import android.app.Application;
/**
 * @author caikaijie
 * @desc 应用程序总入口
 */
@EApplication
public class MyApplication extends Application{

	//定义全局bus总线
	public final static EventBus BUS = new EventBus();
}
