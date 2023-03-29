package Practice;

public class StringTest{
    public static void main(String[] args) {
        //String
        String a="b";
        changeString(a);
        System.out.println("String="+a);
        //new String
        String st=new String("b");
        changeString(st);
        System.out.println("new String="+st);
        //StringBuffer
        StringBuffer sb=new StringBuffer(100);
        sb.append("b");
        changeStringBuffer(sb);
        System.out.println("StringBuffer="+sb);
        //StringBuilder
        StringBuilder sbd=new StringBuilder(100);
        sbd.append("b");
        changeStringBuilder(sbd);
        System.out.println("StringBuilder="+sbd);
    }

    public static void changeString(String a){
        a+="aaa";
    }

    public static void changeStringBuffer(StringBuffer a){
        a.append("aaa");
    }

    public static void changeStringBuilder(StringBuilder a){
        a.append("aaa");
    }
}
