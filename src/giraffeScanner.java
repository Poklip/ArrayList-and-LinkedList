import java.util.ArrayList;

public class giraffeScanner {
    public static giraffeScanner scanGiraffe;

    public void scanGiraffes(ArrayList<Giraffe> giraffes) {
        for (Giraffe giraffe : giraffes) {
            System.out.println(giraffe.height);
        }
            
    }
}

