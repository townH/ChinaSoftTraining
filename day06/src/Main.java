import service.MainService;
import service.RegisterService;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello world!");
        new RegisterService().register("dfjffjd","fkdslf");
//        new RegisterService().register("dfjffjdk","fkdslf");


        new MainService().homePage();
    }
}