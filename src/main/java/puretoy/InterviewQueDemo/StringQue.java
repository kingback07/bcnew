package puretoy.InterviewQueDemo;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by kingb on 2018/6/22.
 * 假设字符串中包含空格和字符，如何倒置
 * 昨天遇到的面试题，当时面一下午思维已然混沌
 * 回来之后依稀记得此题则代码实现
 */
public class StringQue {

    public static void main(String[] args){
        String s1="   I  Love  java";
        String rs=reverseStr(s1);
        System.out.println(rs);
        String rs2=reverseStr4Rex(s1);
        System.out.println("使用正则拆分方式的结果:"+rs2);
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


    /**
     * 使用正则表达式分解字符串
     * 今天看到在很多的内存数据处理中，正则表达式的使用还是很广泛的
     * 回想之前遇到的这个面试题，似乎可以直接使用正则做拆分，简化了代码和循环复杂度
     * @param srcStr
     * @return
     */
    public static String reverseStr4Rex(String srcStr){
        Pattern PATH_TAB=Pattern.compile("(\\s*)(\\w*)");
        Matcher matcher=PATH_TAB.matcher(srcStr);
        List<String> resList=new ArrayList<String>();
        while(matcher.find()){
            //System.out.println("GROUP1 is: "+matcher.group(1)+"++++GOURP2 is: "+matcher.group(2));
            //对空格不做任何处理，对字符串执行反转处理[注释]
            resList.add(matcher.group(1));
            String realStr=matcher.group(2);
            //StringBuilder sb=new StringBuilder(realStr);
            //realStr=sb.reverse().toString();
            resList.add(realStr);
        }
        if(resList.size()>0){
            String result="";
            for(int i=resList.size()-1;i>=0;i--){
                result+=resList.get(i);
            }
            return result;
        }
        return null;
    }
}
