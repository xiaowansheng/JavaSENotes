package ReflectTest;

/**
 * 可变长度参数
 *      int... args 这就是可变长度参数
 *      语法：类型...    (注意一定是3个点)
 *
 *      （1）可变长度参数要求参数个数是：0~n个
 *      （2）可变长度参数在参数列表中必须是最后一个，且可变长度参数只能有一个
 *      （3）可变长度参数可以当作一个数组看待（也可以传数组）
 */
public class ArgsTest {
    public static void main(String[] args) {
        m1(1);
        m1(1,2);
        m1(1,2,3,4,5,6);
        //错误
        //m1("ahah");
        m2("a","s","c");

        m3(100,"a","b","c");
        m3(200,"s","s");
        
        m4(1,2,3,4,5,6,7,8,9);

    }

    public static void m1(int... args){
        System.out.println("m1被调用");
    }

    public static void m2(String... args){
        System.out.println("m2被调用");
    }

    public static void m3(int i,String... args){
        System.out.println("m3被调用");
    }

    public static void m4(int... args){
        int sum=0;
        for(int e:args){
            sum+=e;
        }
        System.out.println("sum="+sum);
    }
}
