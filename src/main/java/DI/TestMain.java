package DI;

public class TestMain {
    public static void main(String[] args) {
        Test test = new Test(new DITestImpl2());

        test.show();

    }
}
