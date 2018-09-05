public class Singleton {
    private static Singleton singleton;


    private Singleton(){
        System.out.println("initialize Singleton object");
    }

    public static Singleton getInstance(){
        if (singleton == null){
            singleton =  new Singleton();
        }

        return singleton;
    }
}
