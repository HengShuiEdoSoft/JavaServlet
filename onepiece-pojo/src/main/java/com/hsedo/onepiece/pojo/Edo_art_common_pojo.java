package com.hsedo.onepiece.pojo;

import java.util.Date;


/**
 * @author  作者:CC
 * @Date	时间: 2020年9月16日 下午3:44:19
 * 类说明
 * 共同公共类
 */
public class Edo_art_common_pojo {
	
	int	ID;
	String	Title;
	String	TitleSpell;
	String	TitleWeb;
	String	KeyWords;
	String	Description;
	String	TempShow;
	String	Source;
	String	Body;
	String	Body1;
	String	Body2;
	int	TypeID;
	int	Hit;
	int	Hot;
	String	Url;
	short	IsBest;
	short	IsNew;
	short	IsSlide;
	String	Author;
	String	Img;
	Date	CDate;
	int	UserID;
	int	CheckID;
	short	ArtState;
	String 	Remark;
	String	FileUrl;
	int ArtType;
	public Edo_art_common_pojo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Edo_art_common_pojo(int iD, String title, String titleSpell, String titleWeb, String keyWords,
			String description, String tempShow, String source, String body, String body1, String body2, int typeID,
			int hit, int hot, String url, short isBest, short isNew, short isSlide, String author, String img,
			Date cDate, int userID, int checkID, short artState, String remark, String fileUrl, int artType) {
		super();
		ID = iD;
		Title = title;
		TitleSpell = titleSpell;
		TitleWeb = titleWeb;
		KeyWords = keyWords;
		Description = description;
		TempShow = tempShow;
		Source = source;
		Body = body;
		Body1 = body1;
		Body2 = body2;
		TypeID = typeID;
		Hit = hit;
		Hot = hot;
		Url = url;
		IsBest = isBest;
		IsNew = isNew;
		IsSlide = isSlide;
		Author = author;
		Img = img;
		CDate = cDate;
		UserID = userID;
		CheckID = checkID;
		ArtState = artState;
		Remark = remark;
		FileUrl = fileUrl;
		ArtType = artType;
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
	public String getTitleSpell() {
		return TitleSpell;
	}
	public void setTitleSpell(String titleSpell) {
		TitleSpell = titleSpell;
	}
	public String getTitleWeb() {
		return TitleWeb;
	}
	public void setTitleWeb(String titleWeb) {
		TitleWeb = titleWeb;
	}
	public String getKeyWords() {
		return KeyWords;
	}
	public void setKeyWords(String keyWords) {
		KeyWords = keyWords;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public String getTempShow() {
		return TempShow;
	}
	public void setTempShow(String tempShow) {
		TempShow = tempShow;
	}
	public String getSource() {
		return Source;
	}
	public void setSource(String source) {
		Source = source;
	}
	public String getBody() {
		return Body;
	}
	public void setBody(String body) {
		Body = body;
	}
	public String getBody1() {
		return Body1;
	}
	public void setBody1(String body1) {
		Body1 = body1;
	}
	public String getBody2() {
		return Body2;
	}
	public void setBody2(String body2) {
		Body2 = body2;
	}
	public int getTypeID() {
		return TypeID;
	}
	public void setTypeID(int typeID) {
		TypeID = typeID;
	}
	public int getHit() {
		return Hit;
	}
	public void setHit(int hit) {
		Hit = hit;
	}
	public int getHot() {
		return Hot;
	}
	public void setHot(int hot) {
		Hot = hot;
	}
	public String getUrl() {
		return Url;
	}
	public void setUrl(String url) {
		Url = url;
	}
	public short getIsBest() {
		return IsBest;
	}
	public void setIsBest(short isBest) {
		IsBest = isBest;
	}
	public short getIsNew() {
		return IsNew;
	}
	public void setIsNew(short isNew) {
		IsNew = isNew;
	}
	public short getIsSlide() {
		return IsSlide;
	}
	public void setIsSlide(short isSlide) {
		IsSlide = isSlide;
	}
	public String getAuthor() {
		return Author;
	}
	public void setAuthor(String author) {
		Author = author;
	}
	public String getImg() {
		return Img;
	}
	public void setImg(String img) {
		Img = img;
	}
	public Date getCDate() {
		return CDate;
	}
	public void setCDate(Date cDate) {
		CDate = cDate;
	}
	public int getUserID() {
		return UserID;
	}
	public void setUserID(int userID) {
		UserID = userID;
	}
	public int getCheckID() {
		return CheckID;
	}
	public void setCheckID(int checkID) {
		CheckID = checkID;
	}
	public short getArtState() {
		return ArtState;
	}
	public void setArtState(short artState) {
		ArtState = artState;
	}
	public String getRemark() {
		return Remark;
	}
	public void setRemark(String remark) {
		Remark = remark;
	}
	public String getFileUrl() {
		return FileUrl;
	}
	public void setFileUrl(String fileUrl) {
		FileUrl = fileUrl;
	}
	public int getArtType() {
		return ArtType;
	}
	public void setArtType(int artType) {
		ArtType = artType;
	}
	
	
}
