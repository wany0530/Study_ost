package Practice.Thread;

//start()와 run()의 차이.
public class ThreadRunAndStart
{
    //1. run()을 호출하면 생성된 쓰레드를 실행시키는것이 아니라 단순히 클래스에 선언된 메서드를 호출하는 것 일뿐이다.
    //2. start()는 새로운 쓰레드가 작업을 실행하는데 필요한 호출스택(call stack)을 생성
    //   run()을 호출해서, 생성된 호출 스택에 run()이 첫번째로 올라가게 한다.
    //   쓰레드가 종료되면 작업에 사용된 호출 스택은 소멸된다.

    public static void main(String[] args) throws Exception
    {
        ThreadEx2_1 t1 = new ThreadEx2_1();
        t1.start();
    }
}

class ThreadEx2_1 extends Thread
{
    @Override
    public void run()
    {
        throwException();
    }

    public void throwException()
    {
        try
        {
            throw new Exception();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}