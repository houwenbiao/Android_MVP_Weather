package com.gree.hwb.mvc_weather.tool;

import android.content.Context;

/**
 * Created by Administrator on 2016/09/03.
 */
public class VolleyRequest
{
	private static RequestQueue mRequestQueue;

	private VolleyRequest()
	{
	}

	/**
	 * @param context ApplicationContext
	 */
	public static void buildRequestQueue(Context context)
	{
		mRequestQueue = Volley.newRequestQueue(context);
		//... do something
	}

	public static VolleyRequest newInstance()
	{
		if(mRequestQueue == null)
		{
			throw new NullPointerException("Call buildRequestQueue method first.");
		}
		//...
		return new VolleyRequest();
	}

	/**
	 * @param url
	 * @param clazz
	 * @param listener
	 * @param errorListener
	 * @return
	 */
	public <T> GsonRequest<T> newGsonRequest(String url, Class<T> clazz, Response.Listener<T> listener, Response.ErrorListener errorListener)
	{
		GsonRequest<T> request = new GsonRequest<T>(url, clazz, listener, errorListener);
		mRequestQueue.add(request);
		return request;
	}
}

