package IoPropertiesTest;

import java.io.*;
import java.util.Properties;

public class IoProperties {
    public static void main(String[] args) {
        //Io+Properties联合使用
        //非常好的设计理念：
        //      以后经常改变的数据，可以单独写到一个文件里，使用程序动态读取。
        //      将来修改数据只需要修改文件内容,
        //      java代码不需要改动，也不用重新编译，
        //      服务器也不用重启就可以拿到动态信息。

        //类似以上机制的这种文件被称为配置文件。
        //并且当配置文件中的格式是：
        //          key=value
        //          key=value
        //      的时候，我们把这种配置文件叫属性配置文件

        //java规定中有要求：属性配置文件建议以.properties结尾。但也不是必须的。
        //这种以.properties结尾的文件，在java中被称为：属性配置文件
        //其中Properties是专门存放属性配置文件内容的一个类


        //Properties是一个Map集合，key和value都是String类型

        //要将一个Users.properties文件加载到properties对象中
        FileReader fileReader=null;
        Properties properties=new Properties();
        try {
            fileReader=new FileReader("D:\\java\\IDEACommunity-Project\\javaSE\\HelloWorld\\src\\IoPropertiesTest\\Users.properties");
            //调用Properties中的load方法将文件中的数据加载到Properties对象中，其中=左边为key值，=右边为value值
            properties.load(fileReader);
            System.out.println(properties.get("210148678"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(fileReader!=null){
                try {
                    fileReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
