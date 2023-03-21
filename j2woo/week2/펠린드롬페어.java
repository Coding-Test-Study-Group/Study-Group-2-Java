package j2woo.week2;
import java.util.*;
public class 펠린드롬페어 {
    public static void main(String[] args){
        String [] exam1={"bat","tab","cat"};
        ArrayList<int []> result=solution(exam1);
        for(int [] i: result){
            System.out.println(i[0]+" "+i[1]);
        }

    }
    public static ArrayList<int[]> solution(String[] inputs){
        int len=inputs.length; // inputs 배열 크기
        ArrayList<int[]> results= new ArrayList<>();
        for(int i=0; i<len-1; i++){ // inputs 앞에서 하나씩 뒤에 string이랑 비교
            for(int j=i+1; j<len; j++){
                String check=inputs[i]+inputs[j]; // inputs[i] + inputs[j]
                if(checkP(check)) results.add(new int[]{i,j});

                check=inputs[j]+inputs[i];// inputs[j] + inputs[i] 왼쪽 오른쪽 바꿔서도 비교
                if(checkP(check)) results.add(new int[]{j,i});
            }
        }
        return results;
    }
    // words[i] + words[j] = ck, ck 문자열이 팰린드롬 가능한지 체크하는 메소드
    public static boolean checkP(String ck){
        int len=ck.length();
        String str1=null;
        String str2=ck.substring(len/2);
        if(len%2==0){
            str1=ck.substring(0,len/2);
        }else str1=ck.substring(0,len/2+1);
        // str2 뒤집으려고
        StringBuffer sb=new StringBuffer();
        sb.append(str2);
        str2=sb.reverse().toString();
        System.out.println("str1  "+str1+"   str2  "+str2);
        if(!str1.equals(str2)) return false;
        return true;
    }
}
