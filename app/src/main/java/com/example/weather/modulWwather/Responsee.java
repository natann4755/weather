package com.example.weather.modulWwather;

import java.util.List;

import com.google.gson.annotations.SerializedName;


public class Responsee {

	@SerializedName("dt")
	private int dt;

	@SerializedName("coord")
	private Coord coord;

	@SerializedName("weather")
	private List<WeatherItem> weather;

	@SerializedName("name")
	private String name;

	@SerializedName("cod")
	private int cod;

	@SerializedName("main")
	private Main main;


	@SerializedName("id")
	private int id;



	@SerializedName("base")
	private String base;

	@SerializedName("wind")
	private Wind wind;

	public void setDt(int dt){
		this.dt = dt;
	}

	public int getDt(){
		return dt;
	}

	public void setCoord(Coord coord){
		this.coord = coord;
	}

	public Coord getCoord(){
		return coord;
	}

	public void setWeather(List<WeatherItem> weather){
		this.weather = weather;
	}

	public List<WeatherItem> getWeather(){
		return weather;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setCod(int cod){
		this.cod = cod;
	}

	public int getCod(){
		return cod;
	}

	public void setMain(Main main){
		this.main = main;
	}

	public Main getMain(){
		return main;
	}


	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}


	public void setBase(String base){
		this.base = base;
	}

	public String getBase(){
		return base;
	}

	public void setWind(Wind wind){
		this.wind = wind;
	}

	public Wind getWind(){
		return wind;
	}

	@Override
 	public String toString(){
		return 
			"Responsee{" +
			"dt = '" + dt + '\'' + 
			",coord = '" + coord + '\'' + 
			",weather = '" + weather + '\'' + 
			",name = '" + name + '\'' + 
			",cod = '" + cod + '\'' + 
			",main = '" + main + '\'' +
			",id = '" + id + '\'' +
			",base = '" + base + '\'' + 
			",wind = '" + wind + '\'' + 
			"}";
		}
}