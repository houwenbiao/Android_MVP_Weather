package com.gree.hwb.android_mvp_weather.model;

/**
 * 天气Model接口
 * Created by Administrator on 2016/09/03.
 */
public interface WeatherModel
{
	void loadWeather(String cityNum,OnWeatherListener listener);
}
