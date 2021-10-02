package Practice.Thread;

public class ThreadPractice
{
    public static void main(String[] args)
    {
        ThreadEx1_1 t1 = new ThreadEx1_1();
        Runnable r = new ThreadEx1_2();
        Thread t2 = new Thread(r);
        // 1. Thread클래스의 생성자의 매개변수로 Runnable인터페이스를 구현하여 제공해야한다.
        // 2. Runnable인터페이스를 매개변수로 받음으로써 따로 run()를 오버라이딩할 필요X 왜냐하면 runnable에 있으니까!!


        //쓰레드를 생성했다고해서 자동으로 실행되는것이 아니라 start()메소드를 호출해야한 쓰레드가 실행된다.
        // ※ 한번 실행이 종료된 쓰레드는 다시 실행할 수 없다.
        t1.start();
        t2.start();
        //t1.start(); 오류
        t1 = new ThreadEx1_1();
        t1.start();
        //이렇게 해줘야 다시 실행된다.
    }
}

class ThreadEx1_1 extends Thread
{
    @Override
    public void run()
    {
        for(int i=0; i < 5; i++)
        {
            System.out.println(getName()); // getName()은 Thread에서 제공하는 메소드.
        }
    }


}

class ThreadEx1_2 implements Runnable // Runnable은 오로지 run()만 정의되어 있는 간단한 인터페이스 이다.
{
    @Override
    public void run()
    {
        for(int i=0; i<5; i++)
        {
            /*
            여기에서 왜 getName만 하면 될껄 Thread.currentThread().getName() 하냐면,
            멤버라고는 run()밖에 없기 때문에 Thread클래스의 getName()을 호출하려면
            Thread.currentThread().getName()와 같이 해야한다.
            */

            // Thread.currentThread() // 현재 실행중인 Thread를 반환하는 메소드.
            System.out.println("Thread.currentThread().getName() : " + Thread.currentThread().getName());
            System.out.println("Thread.currentThread() : " + Thread.currentThread());
        }
    }


}

class MyThread extends Thread
{
    public void run() {/*작업내용*/}
}

class MyTread2 implements Runnable
{
    public void run(){/*작업내용*/}
}
