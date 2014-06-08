package wordMaster;

import static org.junit.Assert.*;

import org.junit.Test;

public class FileFromDiskLoaderTest {
	
	@Test
	public void testNext() {
		FileFromDiskLoader fileFromDiskLoader=new FileFromDiskLoader("dictionary.txt","settings.txt","a","able",3);
		assertEquals("able   adj.�������ģ��ܸɵ�",fileFromDiskLoader.next());
		assertEquals("abnormal   adj.�����ģ���̬��",fileFromDiskLoader.next());
		assertEquals("aboard   adv.��(��)��",fileFromDiskLoader.next());
		assertEquals("��",fileFromDiskLoader.next());
	}

	@Test
	public void testWord() {
		FileFromDiskLoader fileFromDiskLoader=new FileFromDiskLoader("dictionary.txt","settings.txt","a","able",3);
		assertEquals("able",fileFromDiskLoader.word("able   adj.�������ģ��ܸɵ�"));
		assertEquals("abroad",fileFromDiskLoader.word("abroad   adv.���⣬����"));
	}

	@Test
	public void testMeaning() {
		FileFromDiskLoader fileFromDiskLoader=new FileFromDiskLoader("dictionary.txt","settings.txt","a","able",3);
		assertEquals("  adj.�������ģ��ܸɵ�",fileFromDiskLoader.meaning("able   adj.�������ģ��ܸɵ�"));
		assertEquals("  adv.���⣬����",fileFromDiskLoader.meaning("abroad   adv.���⣬����"));
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
