package Core.Static;

class StaticDemo {
    static int number;
    private int count;

    StaticDemo(int count) {
        System.out.println("Inside Constructor assigning values");
        this.count = count;
    }

    public void display() {
        System.out.println("Inside display => number: " + number + ", count: " + count);
    }

    public static void StaticDisplay() {
        number = 25;
        System.out.println("Inside StaticDisplay =>  number : " + number);
    }

    static {
    	System.out.println("Inside static block : " + number);
        number = 99;
        System.out.println("Inside static block : " + number);
    }

    {
        System.out.println("Inside initialization block : " + number);
    }

    public static void main(String arg[]) {
        System.out.println("Inside start of main : " + number);
        StaticDemo s1 = new StaticDemo(10);
        StaticDemo s2 = new StaticDemo(20);
        s1.display();
        s2.display();
        StaticDisplay();
        s1.display();
        s2.display();
        System.out.println("Inside end of main : " + number);
    }
}