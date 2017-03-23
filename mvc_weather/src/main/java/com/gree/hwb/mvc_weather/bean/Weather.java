package com.gree.hwb.mvc_weather.bean;

/**
 * 天气实体类，获取天气信息的方法，设置天气信息的方法
 * Created by Administrator on 2016/09/03.
 */
public class Weather
{
	private WeatherInfo weatherinfo;
	public WeatherInfo getWeatherInfo()
	{
		return weatherinfo;
	}
	public void setWeatherinfo(WeatherInfo weatherinfo)
	{
		this.weatherinfo = weatherinfo;
	}
}
