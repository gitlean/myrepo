package com.isoft.coordinate;

public class MercatorDemo {
	public static void main(String[] args) {
		Point LonLat=new Point();
		LonLat.setX(32.45);
		LonLat.setY(120.44);
		
		Point mercator=CoordinateConversion.lonLatToMercator(LonLat);
		
		System.out.println(mercator.getX()+"\t"+mercator.getY());
	}
}

class Point {
	private double x;
	private double y;

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}
}

class CoordinateConversion {

	/**
	 * 经纬度转墨卡托
	 * 
	 * @param LonLat
	 *            经纬度坐标
	 * @return
	 */
	public static Point lonLatToMercator(Point LonLat) {
		Point mercator = new Point();
		double x = (LonLat.getX() * 20037508.342789 / 180);
		double y = (Math.log(Math.tan((90 + LonLat.getY()) * Math.PI / 360)) / (Math.PI / 180));
		y = (double) (y * 20037508.342789 / 180);
		mercator.setX(x);
		mercator.setY(y);
		return mercator;
	}

	/**
	 * 墨卡托转经纬度
	 * 
	 * @param mercator
	 *            墨卡托坐标
	 * @return
	 */
	public static Point mercatorToLonLat(Point mercator) {
		Point lonlat = new Point();
		double x = (mercator.getX() / 20037508.342789 * 180);
		double y = (mercator.getY() / 20037508.342789 * 180);
		y = (double) (180 / Math.PI * (2 * Math.atan(Math.exp(y * Math.PI / 180)) - Math.PI / 2));
		lonlat.setX(x);
		lonlat.setY(y);
		return lonlat;
	}
}
