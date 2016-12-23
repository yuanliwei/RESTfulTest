package com.ylw.restfultest.model;

import java.text.MessageFormat;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class ListItemData {
	private final StringProperty name;
	String jsData;
	int type = -1;

	public ListItemData(String name, String jsData) {
		super();
		this.name = new SimpleStringProperty(name);
		this.jsData = jsData;
	}

	/**
	 * String result = MessageFormat.format(
	 * "At {1,time} on {1,date}, there was {2} on planet {0,number,integer}.",
	 * planet, new Date(), event);
	 * 
	 * @param name
	 * @param jsData
	 * @param arguments
	 */
	public ListItemData(String name, String jsData, Object... arguments) {
		this.name = new SimpleStringProperty(name);
		this.jsData = MessageFormat.format(jsData, arguments);
	}

	/**
	 * String result = MessageFormat.format(
	 * "At {1,time} on {1,date}, there was {2} on planet {0,number,integer}.",
	 * planet, new Date(), event);
	 * 
	 * @param name
	 * @param jsData
	 * @param arguments
	 */
	public ListItemData(int type, String name, String jsData, Object... arguments) {
		this.type = type;
		this.name = new SimpleStringProperty(name);
		this.jsData = MessageFormat.format(jsData, arguments);
	}

	// Part.T_PAPER_大标题, "T_PAPER_大标题", "addTypeForSel({0})", Part.T_PAPER_大标题
	public ListItemData(int type, String name) {
		this.type = type;
		this.name = new SimpleStringProperty(name);
		this.jsData = MessageFormat.format("addTypeForSel({0})", type);
	}

	// Part.T_PAPER_大标题, "T_PAPER_大标题", "addTypeForSel({0})", Part.T_PAPER_大标题
	public ListItemData(Object type) {
		this.type = 0;
		this.name = new SimpleStringProperty("name");
		this.jsData = MessageFormat.format("addTypeForSel({0})", "value");
	}

	public String getName() {
		return name.get();
	}

	public void setName(String name) {
		this.name.set(name);
	}

	public String getJsData() {
		return jsData;
	}

	public void setJsData(String jsData) {
		this.jsData = jsData;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

}
