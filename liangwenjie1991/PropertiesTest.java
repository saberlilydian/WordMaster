package wordMaster;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

import org.junit.Test;

public class PropertiesTest {

	@Test
	public void testBuild() throws Exception, FileNotFoundException {
		Properties properties=new Properties('a',"settings.txt");
		char wordBank='a';
		int index = 0,number=0,right=0,wrong=0;
		properties.build(6, 5, 10, 11);
		String encoding="GBK";
        File file=new File("settings.txt");
        if(file.isFile() && file.exists()){ //判断文件是否存在
            InputStreamReader read = new InputStreamReader(new FileInputStream(file),encoding);//考虑到编码格式
            BufferedReader bufferedReader = new BufferedReader(read);
            String lineTxt = null;
            while((lineTxt = bufferedReader.readLine()) != null){
            	 if(lineTxt.startsWith(String.valueOf(wordBank)) && lineTxt.contains("index")){
                 	index = Integer.parseInt(lineTxt.substring(lineTxt.indexOf("=")+1));
                 }else if(lineTxt.startsWith(String.valueOf(wordBank)) && lineTxt.contains("number")){
                	number = Integer.parseInt(lineTxt.substring(lineTxt.indexOf("=")+1));
                 }else if(lineTxt.startsWith(String.valueOf(wordBank)) && lineTxt.contains("right")){
                	right = Integer.parseInt(lineTxt.substring(lineTxt.indexOf("=")+1));
                 }else if(lineTxt.startsWith(String.valueOf(wordBank)) && lineTxt.contains("false")){
                	wrong = Integer.parseInt(lineTxt.substring(lineTxt.indexOf("=")+1));
                 }
            }
            read.close();
        }
        assertEquals(6,index);
        assertEquals(5,number);
        assertEquals(10,right);
        assertEquals(11,wrong);
	}

}
