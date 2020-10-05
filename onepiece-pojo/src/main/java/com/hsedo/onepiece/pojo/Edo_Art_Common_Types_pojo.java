package com.hsedo.onepiece.pojo;

/**
 * @author  作者:CC
 * @Date	时间: 2020年9月19日 下午3:14:12
 * 类说明
 * 分类管理表
 */
public class Edo_Art_Common_Types_pojo {
	int  ID;
	String	TypeName;
	int	State;
	int	ParentID;    //有没有父类,有父类的话父类ID
	int	SortID;
	int Layer;		//属于第几及分类  一般都是0开始
	int	Haschild; 
	String	Path;
	String	TypeMaster;
	String	Img;
	int	IsSystem;
	int	PageType;
	String TempList;
	String	TempIndex;
	String	TempShow;
	int	PageSize;
	String	Catalog;
	public Edo_Art_Common_Types_pojo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Edo_Art_Common_Types_pojo(int iD, String typeName, int state, int parentID, int sortID, int layer,
			int haschild, String path, String typeMaster, String img, int isSystem, int pageType, String tempList,
			String tempIndex, String tempShow, int pageSize, String catalog) {
		super();
		ID = iD;
		TypeName = typeName;
		State = state;
		ParentID = parentID;
		SortID = sortID;
		Layer = layer;
		Haschild = haschild;
		Path = path;
		TypeMaster = typeMaster;
		Img = img;
		IsSystem = isSystem;
		PageType = pageType;
		TempList = tempList;
		TempIndex = tempIndex;
		TempShow = tempShow;
		PageSize = pageSize;
		Catalog = catalog;
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getTypeName() {
		return TypeName;
	}
	public void setTypeName(String typeName) {
		TypeName = typeName;
	}
	public int getState() {
		return State;
	}
	public void setState(int state) {
		State = state;
	}
	public int getParentID() {
		return ParentID;
	}
	public void setParentID(int parentID) {
		ParentID = parentID;
	}
	public int getSortID() {
		return SortID;
	}
	public void setSortID(int sortID) {
		SortID = sortID;
	}
	public int getLayer() {
		return Layer;
	}
	public void setLayer(int layer) {
		Layer = layer;
	}
	public int getHaschild() {
		return Haschild;
	}
	public void setHaschild(int haschild) {
		Haschild = haschild;
	}
	public String getPath() {
		return Path;
	}
	public void setPath(String path) {
		Path = path;
	}
	public String getTypeMaster() {
		return TypeMaster;
	}
	public void setTypeMaster(String typeMaster) {
		TypeMaster = typeMaster;
	}
	public String getImg() {
		return Img;
	}
	public void setImg(String img) {
		Img = img;
	}
	public int getIsSystem() {
		return IsSystem;
	}
	public void setIsSystem(int isSystem) {
		IsSystem = isSystem;
	}
	public int getPageType() {
		return PageType;
	}
	public void setPageType(int pageType) {
		PageType = pageType;
	}
	public String getTempList() {
		return TempList;
	}
	public void setTempList(String tempList) {
		TempList = tempList;
	}
	public String getTempIndex() {
		return TempIndex;
	}
	public void setTempIndex(String tempIndex) {
		TempIndex = tempIndex;
	}
	public String getTempShow() {
		return TempShow;
	}
	public void setTempShow(String tempShow) {
		TempShow = tempShow;
	}
	public int getPageSize() {
		return PageSize;
	}
	public void setPageSize(int pageSize) {
		PageSize = pageSize;
	}
	public String getCatalog() {
		return Catalog;
	}
	public void setCatalog(String catalog) {
		Catalog = catalog;
	}
	
	
}
