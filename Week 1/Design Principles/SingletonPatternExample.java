class Logger{
    private static Logger instance;
    private Logger(){
        System.out.println("In Logger Constructor");
    }
    public static Logger getLog(){
        if(instance== null){
            instance = new Logger();
        }
        return instance;
    }   
}
public class SingletonPatternExample {
    public static void main(String[] args) {
        Logger log1 = Logger.getLog();
        Logger log2 = Logger.getLog();
        if (log1==log2) System.out.println("Same Instance");
        else System.out.println("Different instance");
    }
}
