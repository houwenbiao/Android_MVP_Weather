package com.gree.hwb.mvc_weather.tool;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import javax.xml.transform.ErrorListener;

/**
 * Created by Administrator on 2016/09/03.
 */
public class GsonRequest<T> extends Request<T> {

	private final Listener<T> mListener;

	private static Gson mGson = new Gson();

	private Class<T> mClass;
	private TypeToken<T> mTypeToken;

	public GsonRequest(int method, String url, Class<T> clazz, Listener<T> listener,
					   ErrorListener errorListener) {
		super(method, url, errorListener);
		mClass = clazz;
		mListener = listener;
	}

	public GsonRequest(int method, String url, TypeToken<T> typeToken, Listener<T> listener,
					   ErrorListener errorListener) {
		super(method, url, errorListener);
		mTypeToken = typeToken;
		mListener = listener;
	}

	public GsonRequest(String url, Class<T> clazz, Listener<T> listener, ErrorListener errorListener) {
		this(Method.GET, url, clazz, listener, errorListener);
	}

	public GsonRequest(String url, TypeToken<T> typeToken, Listener<T> listener, ErrorListener errorListener) {
		super(Method.GET, url, errorListener);
		mTypeToken = typeToken;
		mListener = listener;
	}

	@Override
	protected Response<T> parseNetworkResponse(NetworkResponse response) {
		try {
			String jsonString = new String(response.data, HttpHeaderParser.parseCharset(response.headers));
			if (mTypeToken == null)
				return Response.success(mGson.fromJson(jsonString, mClass),
						HttpHeaderParser.parseCacheHeaders(response));
			else
				return (Response<T>) Response.success(mGson.fromJson(jsonString, mTypeToken.getType()),
						HttpHeaderParser.parseCacheHeaders(response));
		} catch (UnsupportedEncodingException e) {
			return Response.error(new ParseError(e));
		}
	}

	@Override
	protected void deliverResponse(T response) {
		mListener.onResponse(response);
	}

}
