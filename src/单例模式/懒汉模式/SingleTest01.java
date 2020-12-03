package 单例模式.懒汉模式;
/*
* 懒汉式:用到时创建对象
* 线程不安全
* */
public class SingleTest01 {
    private static  SingleTest01 INSTANCE;

    private SingleTest01(){

    }
    /*
    * 加锁保证线程安全,但效率降低
    * */
    synchronized public  static  SingleTest01 getInstance(){

        if (INSTANCE == null){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            INSTANCE = new SingleTest01();
        }
        return INSTANCE;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(()->{
                System.out.println(SingleTest01.getInstance().hashCode());
            }).start();
        }
    }
}
