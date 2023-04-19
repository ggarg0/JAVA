package Core.Static;

class Static {
    private int count;
    private static int number = 10;

    Static(int count) {
        this.count = count;
    }

    public static void display() {
        System.out.println("number in display: " + number);
		number = 100;
    }

    public void show() {
        System.out.println("count in show: " + count);
        System.out.println("number in show: " + number);
		number = 200;
		count = 11;
    }

	public void showAgain() {
		System.out.println("count in showAgain: " + count);
		System.out.println("number in showAgain: " + number);
	}

    public static void main(String arg[]) {
        Static.display();
        Static s1 = new Static(100);
        s1.show();
		s1.show();
        Static s2 = new Static(1000);
        s2.showAgain();
    }
}