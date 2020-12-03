package 单例模式.饿汉模式;
/*
* 饿汉式:类加载后便实例一个变量
* */
public class SingleTest01 {
    private static final SingleTest01 INSTANCE = new SingleTest01();

    private SingleTest01(){

    }

    public static SingleTest01 getInstance(){
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
