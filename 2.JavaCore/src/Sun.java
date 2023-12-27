import java.util.ArrayList;

public class Sun {
    public static void main(String[] args) {
        ArrayList<? super Plant> list = new ArrayList<>();

        list.add(new Flower());

        System.out.println( list.get(0).getClass().getName() );
    }

    private static class Plant {
    }

    private static class Flower extends Plant {
    }
}
