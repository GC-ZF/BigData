package JAVA_Advance;

/**
 * 策略模式：定义了一系列的算法，将每一种算法封装起来并可以相互替换使用，测类模式让算法独立于使用它的客户应用而独立变化
 * OO设计原则：
 * 1.面向接口编程（面向抽象编程）
 * 2.封装变化
 * 3.多组合，少继承
 * 把可变的行为抽象出来，这样的好处是这些行为可以真正使用时相互替换
 */
public class java062接口应用之策略设计模式 {
    public static void main(String[] args) {
        BaseService user = new UserService();
        user.setISave(new FileSave());
//        user.setISave(new NetSave());
        user.add("user");
    }
}

//abstract class BaseService {
//    public abstract void save(String data);
//}

interface ISave {
    void save(String data);
}

//class UserService extends BaseService {
//    public void save(String data) {
//        System.out.println("把数据保存到文件中"+data);
//    }
//}
//把可变的行为抽象出来，定义一系列的算法
//保存到文件
class FileSave implements ISave {
    public void save(String data) {
        System.out.println("正在把数据保存到文件中..." + data);
    }
}

//保存到网络
class NetSave implements ISave {
    public void save(String data) {
        System.out.println("把数据保存到网络上..." + data);
    }
}

abstract class BaseService {
    private ISave iSave;

    public void setISave(ISave iSave) {
        this.iSave = iSave;
    }

    public void add(String data) {
        System.out.println("检查数据合法性");
        iSave.save(data);
        System.out.println("数据保存完毕");
    }
}

class UserService extends BaseService {

}
