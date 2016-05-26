package com.coolweather.app.util;

import android.text.TextUtils;

import com.coolweather.app.db.CoolWeatherDB;
import com.coolweather.app.model.City;
import com.coolweather.app.model.County;
import com.coolweather.app.model.Province;

public class Utility {
	/**
	 * �����ʹ�����������ص�ʡ������
	 */
	public synchronized static boolean handleProvincesResponse(CoolWeatherDB coolweatherDB, String response){
		if(!TextUtils.isEmpty(response)){
			String[] allProvince =response.split(",");
			if(allProvince != null && allProvince.length > 0){
				for(String p : allProvince){
					String[] array = p.split("\\|");
					Province province = new Province();
					province.setProvinceCode(array[0]);
					province.setProvinceName(array[1]);
					//�����������ݴ�ŵ�Province��
					coolweatherDB.saveProvince(province);
				}
				return true;
			}
		  }
		return false;
	}
	
	/**
	 *�����ʹ�����������ص��м�����
	 */
	public synchronized static boolean handleCitiesResponse(CoolWeatherDB coolweatherDB, String response, int provinceId){
		if(!TextUtils.isEmpty(response)){
			String[] allCities =response.split(",");
			if(allCities != null && allCities.length > 0){
				for(String p : allCities){
					String[] array = p.split("\\|");
					City city = new City();
					city.setCityCode(array[0]);
					city.setCityName(array[1]);
					city.setProvinceId(provinceId);
					//�����������ݴ�ŵ�City��
					coolweatherDB.saveCity(city);
				}
				return true;
			}
		  }
		return false;
	}
	
	/**
	 *�����ʹ�����������ص�������
	 */
	public synchronized static boolean handleCountiseResponse(CoolWeatherDB coolweatherDB, String response, int cityId){
		if(!TextUtils.isEmpty(response)){
			String[] allCountise =response.split(",");
			if(allCountise != null && allCountise.length > 0){
				for(String p : allCountise){
					String[] array = p.split("\\|");
					County county = new County();
					county.setCountyCode(array[0]);
					county.setCountyName(array[1]);
					county.setCityId(cityId);
					//�����������ݴ�ŵ�County��
					coolweatherDB.saveCounty(county);
				}
				return true;
			}
		  }
		return false;
	}
		
}
