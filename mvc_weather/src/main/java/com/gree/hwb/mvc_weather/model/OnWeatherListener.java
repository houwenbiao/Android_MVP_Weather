package com.gree.hwb.mvc_weather.model;

import com.gree.hwb.mvc_weather.bean.Weather;

/**
 * 得到网络请求接口
 * Created by Administrator on 2016/09/03.
 */
public interface OnWeatherListener
{
	//数据请求成功返回Weather实体类
	void onSuccess(Weather weather);
	void onError();
}
