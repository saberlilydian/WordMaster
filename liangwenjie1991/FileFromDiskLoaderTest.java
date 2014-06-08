package wordMaster;

import static org.junit.Assert.*;

import org.junit.Test;

public class FileFromDiskLoaderTest {
	
	@Test
	public void testNext() {
		FileFromDiskLoader fileFromDiskLoader=new FileFromDiskLoader("dictionary.txt","settings.txt","a","able",3);
		assertEquals("able   adj.有能力的，能干的",fileFromDiskLoader.next());
		assertEquals("abnormal   adj.反常的，变态的",fileFromDiskLoader.next());
		assertEquals("aboard   adv.船(车)上",fileFromDiskLoader.next());
		assertEquals("完",fileFromDiskLoader.next());
	}

	@Test
	public void testWord() {
		FileFromDiskLoader fileFromDiskLoader=new FileFromDiskLoader("dictionary.txt","settings.txt","a","able",3);
		assertEquals("able",fileFromDiskLoader.word("able   adj.有能力的，能干的"));
		assertEquals("abroad",fileFromDiskLoader.word("abroad   adv.国外，海外"));
	}

	@Test
	public void testMeaning() {
		FileFromDiskLoader fileFromDiskLoader=new FileFromDiskLoader("dictionary.txt","settings.txt","a","able",3);
		assertEquals("  adj.有能力的，能干的",fileFromDiskLoader.meaning("able   adj.有能力的，能干的"));
		assertEquals("  adv.国外，海外",fileFromDiskLoader.meaning("abroad   adv.国外，海外"));
	}

	@Test
	public void testGetIndex() {
		FileFromDiskLoader fileFromDiskLoader=new FileFromDiskLoader("dictionary.txt","settings.txt","a","able",3);
		assertEquals(6,fileFromDiskLoader.getIndex());
		Properties properties=new Properties('a',"settings.txt");
		properties.build(18,5,19,10);
		fileFromDiskLoader=new FileFromDiskLoader("dictionary.txt","settings.txt","a",null,3);
		assertEquals(18,fileFromDiskLoader.getIndex());
	}

	@Test
	public void testGetWordBankNum() {
		FileFromDiskLoader fileFromDiskLoader=new FileFromDiskLoader("dictionary.txt","settings.txt","a","able",3);
		assertEquals(562,fileFromDiskLoader.getWordBankNum("a"));
		fileFromDiskLoader=new FileFromDiskLoader("dictionary.txt","settings.txt","b","but",3);
		assertEquals(397,fileFromDiskLoader.getWordBankNum("b"));
	}

}
