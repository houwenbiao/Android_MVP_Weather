package com.gree.hwb.android_mvp_weather.view;

/**
 * Created by Administrator on 2016/09/03.
 */
public interface WeatherView
{
	void showLoading();
	void hideLoading();
	void showError();
	void setWeatherInfo(Weather weather);
}
