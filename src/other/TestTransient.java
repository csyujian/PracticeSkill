package other;

import java.io.*;

/**
 * @author yvzhu
 * @version 1.0
 * @date 2020/10/4 14:16
 */

class UserInfo implements Serializable {
    private static final long serialVersionUID = 996890129747019948L;
    private String name;
    private transient static String psw = "123";

    public UserInfo(String name, String psw) {
        this.name = name;
        //this.psw = psw;
    }

    @Override
    public String toString() {
        return "name=" + name + ", psw=" + psw;
    }
}

public class TestTransient {
    public static void main(String[] args) {
        UserInfo userInfo = new UserInfo("����", "123456");
        System.out.println(userInfo);
        try {
            // ���л���������Ϊtransient������û�б����л�
            ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream(
                    "UserInfo.out"));
            o.writeObject(userInfo);
            o.close();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        try {
            // ���¶�ȡ����
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(
                    "UserInfo.out"));
            UserInfo readUserInfo = (UserInfo) in.readObject();
            //��ȡ��psw������Ϊnull
            System.out.println(readUserInfo.toString());
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }
}