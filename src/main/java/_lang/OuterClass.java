package _lang;

public class OuterClass {
    private int x = 0;
    public int getX() {
        return this.x;
    }

    static class StaticNestedClass {
        private static int x = 2;
        public static int getX() {
            return x;
        }
    }

    class InnerClass {
        private int x = 1;
        public int getX() {
            return this.x;
        }
    }
}
