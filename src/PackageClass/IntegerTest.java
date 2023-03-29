package PackageClass;

public class IntegerTest {
    public static void main(String[] args) {
        Integer integer=new Integer(123);
        System.out.println(integer);
        System.out.println(Integer.MAX_VALUE);

        Integer s=12;
        Integer x=12;
        System.out.println("s=x ?"+(s==x));//true

        Integer c=1000;
        Integer d=1000;
        System.out.println("c=d ?"+(c==d));//false

        Integer a=new Integer(12);
        Integer b=new Integer(12);
        System.out.println("a=b ?"+(a==b));//false
    }
}
