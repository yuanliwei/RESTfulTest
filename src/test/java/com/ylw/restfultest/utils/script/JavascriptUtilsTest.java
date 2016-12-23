package com.ylw.restfultest.utils.script;

import static org.junit.Assert.assertTrue;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class JavascriptUtilsTest {
	private static Log log = LogFactory.getLog(JavascriptUtilsTest.class);

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetInvokeStringArray() {
		Invoke invoke = JavascriptUtils.getInvoke("test.js");
		String result = invoke.exec("start", "123", 456);
		log.debug(result);
		assertTrue(!"error!".equals(result));		
	}

}
