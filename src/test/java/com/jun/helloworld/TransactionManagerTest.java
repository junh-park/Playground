package com.jun.helloworld;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.jun.env.DatabaseProduct;
import com.jun.env.TransactionManagerSetup;


public class TransactionManagerTest {
	
	static public TransactionManagerSetup TM;
	
	@Parameters({"database", "connectionURL"})
	@BeforeSuite
	public void beforeSuite(@Optional String database, @Optional String connectionURL) throws Exception {
		TM = new TransactionManagerSetup(DatabaseProduct.H2, connectionURL);
	}
	
	@AfterSuite(alwaysRun = true)
	public void afterSuite() throws Exception {
		if (TM != null) TM.stop();
	}
}
