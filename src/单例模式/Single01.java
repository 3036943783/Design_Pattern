package 单例模式;
/*
* 静态内部类方式
* */
public class Single01 {

    private Single01(){}
    public static class Single{
        private static Single01 INSTANCE = new Single01();
    }
    public static Single01 getInstance(){
        return Single.INSTANCE;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(()->{
                System.out.println(Single01.getInstance().hashCode());
            }).start();
        }
    }
}
