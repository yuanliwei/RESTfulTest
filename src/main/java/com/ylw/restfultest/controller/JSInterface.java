package com.ylw.restfultest.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ylw.restfultest.MainApp;

public class JSInterface {
	private static Log log = LogFactory.getLog(JSInterface.class);

	public void log(String msg) {
		log.debug("Console : " + msg);
	}

	public void edit() {
	}

	public void hideEdit(boolean save) {
	}
}
