package 单例模式;
/*
* 枚举单例
* 无构造方法无法被反序列化
* */
public enum Single02 {
    INSTANCE;

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(()->{
                System.out.println(Single02.INSTANCE.hashCode());
            }).start();
        }
    }
}
