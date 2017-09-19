package test;

/**
 * Created by shrikanth on 25/7/17.
 */
public class MainClass extends AbstClass implements InterfaceDemo {
    public int getValue(){
        return 10;
    }
    @Override
    public String getName(){
        return "20";
    }
    public static void main(String[] args){
        //MainClass intf = new MainClass();
        InterfaceDemo intf = new MainClass();
        System.out.println(intf.getValue());
        //System.out.println(intf.getName());


    }
}
