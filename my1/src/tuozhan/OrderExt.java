package tuozhan;

import pojo.Orders;

public class OrderExt extends Orders {
    private String username;
    private String sex;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "OrderExt{" +
                "username='" + username + '\'' +
                ", sex='" + sex + '\'' +
                '}';
    }
}
