package com.gree.hwb.android_mvp_weather.presenter;

/**
 * 在Presenter层实现，给Model层回调，更改View层的状态，确保Model层不直接操作View层
 * Created by Administrator on 2016/09/03.
 */
public interface OnWeatherListener
{
	//成功是回调
	void onSuccsee(Weather weather);
	//失败时回调
	void onError();
}
