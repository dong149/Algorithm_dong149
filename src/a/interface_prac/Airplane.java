package a.interface_prac;

public class Airplane implements Flyable,Ridable{


    @Override
    public void fly(int num, int dist) {

        System.out.println(num+"번 비행기"+dist+"m 이륙합니다.");
        System.out.println("------------");
    }

    @Override
    public void ride(int num,int dist) {
        System.out.println(num+"번 비행기"+dist+"m 이동합니다.");
        System.out.println("------------");
    }


}
