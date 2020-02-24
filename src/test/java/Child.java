/**
 * @Author: Administrator
 * @Description:
 * @Date: Created in 2020-01-17 13:13
 * @Modified By:
 */
public class Child extends Father {
    String field = "child";

    public void hello() {
        System.out.println("child");
    }


    public static void main(String[] args) {
        Father father = new Child();
        System.out.println(father.field);
        father.hello();
    }
}
