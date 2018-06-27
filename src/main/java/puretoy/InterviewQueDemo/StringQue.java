package puretoy.InterviewQueDemo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kingb on 2018/6/22.
 * 假设字符串中包含空格和字符，如何倒置
 */
public class StringQue {

    public static void main(String[] args){
        String s1="   I  Love  java    ";
        String rs=reverseStr(s1);
        System.out.println(rs);
    }

    public static String reverseStr(String srcStr){

        char[] chars= srcStr.toCharArray();
        List<String> subStrList=new ArrayList<String>();
        String tempStr="";
        for(int i=0;i<chars.length-1;){
          if(chars[i]!=' '){
              tempStr+=chars[i];
              for(int j=i+1;j<chars.length;j++){
                  if(chars[j]==' '){
                      subStrList.add(tempStr);
                      i=j;
                      tempStr="";
                      break;
                  }
                  tempStr+=chars[j];
                  if(j==chars.length-1){
                      i=j;
                      subStrList.add(tempStr);
                  }
              }
          }else{
              tempStr+=chars[i];
              for(int j=i+1;j<chars.length;j++){
                  if(chars[j]!=' '){
                      subStrList.add(tempStr);
                      i=j;
                      tempStr="";
                      break;
                  }
                  tempStr+=chars[j];
                  if(j==chars.length-1){
                      i=j;
                      subStrList.add(tempStr);
                  }
              }
          }
        }

        //subStrList倒序拼装成String
        String resStr="";
        for(int x=subStrList.size()-1;x>=0;x--){
            resStr+=subStrList.get(x);
        }
        return resStr;
    }

}
