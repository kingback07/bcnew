package puretoy;

import java.util.*;

/**
 * Created by kingb on 2018/3/22.
 */
public class createfilter {

    public static void main(String[] args){

        int x=6;

        System.out.println(creFil(x));

        String fieldName="Account:Billing City";
        List<String> citys=new ArrayList<String>();
        citys.add("恩施");
        citys.add("黄石");
        citys.add("十堰");
        citys.add("武汉");
        citys.add("咸宁");
        citys.add("宜昌");

        System.out.println(mkCityFil(fieldName,citys));

    }

    public static String creFil(int count){
        String result="1";
        if(count==1){
            return result;
        }else{
            for(int i=2;i<=count;i++){
                result+=" OR "+i;
            }
        }
        return result;
    }

    public static String mkCityFil(String fieldName,List<String> citys){
        String result="";

        for(String city:citys){
            String metaStr=String.format(" OR (%s contains %s)",fieldName,city);
            result+=metaStr;
        }
        result=result.substring(2,result.length());
        return result;
    }

}
