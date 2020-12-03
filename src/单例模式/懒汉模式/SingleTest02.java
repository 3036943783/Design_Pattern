package 单例模式.懒汉模式;

public class SingleTest02 {
    private static volatile SingleTest02 INSTANCE;

    private SingleTest02(){

    }
  public  static  SingleTest02 getInstance() {
      if (INSTANCE == null) {
          synchronized (SingleTest02.class) {
              if (INSTANCE == null) {
                  try {
                      Thread.sleep(1000);
                  } catch (InterruptedException e) {
                      e.printStackTrace();
                  }
                  INSTANCE = new SingleTest02();
              }
          }
      }
      return INSTANCE;
  }
    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(()->{
                System.out.println(SingleTest02.getInstance().hashCode());
            }).start();
        }
    }
}
