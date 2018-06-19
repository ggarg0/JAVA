class OverLoadingDemo1 {
		private OverLoadingDemo1(Object o){
			System.out.println("Inside Object");
		}
		private OverLoadingDemo1(String o){
			System.out.println("Inside String");
		}
		private OverLoadingDemo1(Integer s){
			System.out.println("Inside Integer");
		}
		private OverLoadingDemo1(int s){
			System.out.println("Inside int");
		}
		public static void main(String arg[]){
			OverLoadingDemo1 overload2=new OverLoadingDemo1(null);
			//OverLoadingDemo1 overload1=new OverLoadingDemo1(new Object());
			//OverLoadingDemo1 overload=new OverLoadingDemo1(new String("s1"));
			//OverLoadingDemo1 overload4=new OverLoadingDemo1(new StringBuffer("Asa"));
		}
}