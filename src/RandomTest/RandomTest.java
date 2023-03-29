package RandomTest;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;

public class RandomTest {
    public static int[] RandomFiveNumbers(int count){//count几个随机数,每个随机数不相同，count数不能大于随机数范围！！
        int[] numbers=new int[count];
        Random random=new Random();
        int range=100;//范围,随机数产生的范围0~range-1
        for(int i=0;i<count;i++){
            int x=random.nextInt(range);//随机数产生的范围0~range-1
            for(int j=0;j<i;j++){//判断随机数是否重复
                if(numbers[j]==x){
                    x=random.nextInt(range);
                    j=-1;
                }
            }
            numbers[i]=x;
        }
        return numbers;
    }

    public static void main(String[] args) {
        int[] numbers=RandomFiveNumbers(100);
        for(int i=0;i<numbers.length;i++){
            System.out.print(numbers[i]+" ");
        }
        System.out.println();
        Arrays.sort(numbers);//数组排序
        for(int i=0;i<numbers.length;i++){
            System.out.print(numbers[i]+" ");
        }
    }
}
