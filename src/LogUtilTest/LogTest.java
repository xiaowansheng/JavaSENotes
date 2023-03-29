package LogUtilTest;

public class LogTest {
    public static void main(String[] args) {
        LogUtil.log("调用了logUtil方法记录日志。");
        LogUtil.log("调用了System的gc方法，建议启动垃圾回收。");
    }
}
