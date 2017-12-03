import java.lang.ref.WeakReference;

/**
 * <p>Title: Test</p>
 * <p>Description: </p>
 * <p>Create Time: 2017/11/29 下午2:53</p>
 * <p>Copyright: © 2017年 java. All rights reserved.</p>
 *
 * @author 阳君
 * @version 1.0
 */
public class Test {
    private int a = 3;
    private static Integer b = 5;
    private String c = "YJ";
    private Test test;

    public static void main(String[] args) throws Exception {
        Test test = new Test();
        WeakReference<Test> wTest = new WeakReference<Test>(test);
        new Thread(() -> {
            System.gc();
            Test sTest = wTest.get();
            if (sTest != null) {
                System.out.println(sTest);
//                System.out.println(test);
            }
            if (false) {
                new Thread(() -> {
                    System.out.println(test);
                }).start();
            }
        }).start();
    }

    private String test() {
        this.a = this.b;
        return c;
    }

}