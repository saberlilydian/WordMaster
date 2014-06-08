package wordMaster;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

import org.junit.Test;

public class PropertyValueTest {
	File record=new File("record.txt");

	@Test
	public void testGetStatusWhenSetupRecord() {
		
		if (record.exists()) record.delete();
		PropertyValue propertyValue=new PropertyValue("dictionary.txt","record.txt");
		assertEquals(0,propertyValue.getStatus("abandon"));
	}
	
	@Test
	public void testGetStatusWhenRecordAlreadyExists() throws Exception {
		System.gc();
		if (record.exists()) record.delete();
	    PrintWriter output = new PrintWriter(record);
		output.println("abandon   v.Å×Æú£¬·ÅÆú=1");
		output.close();
		record=null;
		PropertyValue propertyValue=new PropertyValue("dictionary.txt","record.txt");
		assertEquals(1,propertyValue.getStatus("abandon"));
	}

	
	@Test
	public void testSetStatus() {
		System.gc();
		if (record.exists()) record.delete();
		PropertyValue propertyValue=new PropertyValue("dictionary.txt","record.txt");
		int[] status={0,1,2};
		String[] word={"abandon","baby","client"};
		propertyValue.setStatus(status, word);
		assertEquals(0,propertyValue.getStatus("abandon"));
		assertEquals(1,propertyValue.getStatus("baby"));
		assertEquals(2,propertyValue.getStatus("client"));
	}
}
