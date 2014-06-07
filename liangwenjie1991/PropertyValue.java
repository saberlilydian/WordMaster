package wordMaster;

import java.io.*;

public class PropertyValue {
     public static void main(String args[]){
    	 int count[] = new int[26];
    	 for(int i=0;i<26;i++){
    		 count[i] = 0;
    	 }
    	 try {
             String encoding="GBK";
             File file=new File("C:\\Users\\admin\\Documents\\GitHub\\WordMaster\\WordMaster\\src\\dictionary.txt");
             if(file.isFile() && file.exists()){ //�ж��ļ��Ƿ����
                 InputStreamReader read = new InputStreamReader(new FileInputStream(file),encoding);//���ǵ������ʽ
                 BufferedReader bufferedReader = new BufferedReader(read);
                 String lineTxt = null;
                 while((lineTxt = bufferedReader.readLine()) != null){
                     count[lineTxt.charAt(0)-'a']++;
                 }
                 read.close();
     }else{
         System.out.println("�Ҳ���ָ�����ļ�");
     }
     } catch (Exception e) {
         System.out.println("��ȡ�ļ����ݳ���");
         e.printStackTrace();
     }
    	 
    	 for(int i=0;i<26;i++){
    		 char c = (char) ('a'+i);
    		 System.out.println(c + ":"+count[i]);
    	 }
     }
}
