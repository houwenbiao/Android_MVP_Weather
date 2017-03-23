package com.gree.hwb.mvc_weather.model;

/**
 * Created by Administrator on 2016/09/03.
 */
public interface WeatherModel
{
	void getWeather(String cityNum,OnWeatherListener listener);
}
