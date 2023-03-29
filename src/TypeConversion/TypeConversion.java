package TypeConversion;

public class TypeConversion {
    public static void main(String[] args) {
        int a=1;
        Integer b=a;
        Integer c=Integer.valueOf(a);
        String d=String.valueOf(c);
        String m=String.valueOf(a);
        String e="123";
        Integer f=Integer.valueOf(e);
        Integer g=Integer.valueOf(e);
        int h=Integer.parseInt(e);


        double z=1.23;
        Double x=z;
        System.out.println(x);
        Double v=Double.valueOf(z);
        double n=Double.parseDouble("1.222");
        System.out.println(n);

    }
}
