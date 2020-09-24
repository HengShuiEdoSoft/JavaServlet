package com.hsedo.onepiece.pojo;

import java.util.Date;

/**
 * @author  作者:CC
 * @Date	时间: 2020年9月24日 下午5:27:07
 * 类说明
 *  广告实体类   15个字段
 */
public class Edo_Adverts {
	
	int	 ID;
	String	Title;
	String	Img;
	String	Url;
	int	 Hit;
	int	 TypeID;
	int	 AdState;
	Date StartTime;
	Date EndTime;
	int	 Sort;
	String	Data1;
	String	Data2;
	String	Data3;
	String	Data4;
	String	Data5;
	public Edo_Adverts() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Edo_Adverts(int iD, String title, String img, String url, int hit, int typeID, int adState, Date startTime,
			Date endTime, int sort, String data1, String data2, String data3, String data4, String data5) {
		super();
		ID = iD;
		Title = title;
		Img = img;
		Url = url;
		Hit = hit;
		TypeID = typeID;
		AdState = adState;
		StartTime = startTime;
		EndTime = endTime;
		Sort = sort;
		Data1 = data1;
		Data2 = data2;
		Data3 = data3;
		Data4 = data4;
		Data5 = data5;
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}
	public String getImg() {
		return Img;
	}
	public void setImg(String img) {
		Img = img;
	}
	public String getUrl() {
		return Url;
	}
	public void setUrl(String url) {
		Url = url;
	}
	public int getHit() {
		return Hit;
	}
	public void setHit(int hit) {
		Hit = hit;
	}
	public int getTypeID() {
		return TypeID;
	}
	public void setTypeID(int typeID) {
		TypeID = typeID;
	}
	public int getAdState() {
		return AdState;
	}
	public void setAdState(int adState) {
		AdState = adState;
	}
	public Date getStartTime() {
		return StartTime;
	}
	public void setStartTime(Date startTime) {
		StartTime = startTime;
	}
	public Date getEndTime() {
		return EndTime;
	}
	public void setEndTime(Date endTime) {
		EndTime = endTime;
	}
	public int getSort() {
		return Sort;
	}
	public void setSort(int sort) {
		Sort = sort;
	}
	public String getData1() {
		return Data1;
	}
	public void setData1(String data1) {
		Data1 = data1;
	}
	public String getData2() {
		return Data2;
	}
	public void setData2(String data2) {
		Data2 = data2;
	}
	public String getData3() {
		return Data3;
	}
	public void setData3(String data3) {
		Data3 = data3;
	}
	public String getData4() {
		return Data4;
	}
	public void setData4(String data4) {
		Data4 = data4;
	}
	public String getData5() {
		return Data5;
	}
	public void setData5(String data5) {
		Data5 = data5;
	}
	
	
	
	

}
