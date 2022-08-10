package Strings;

import java.util.*;

class StringSplitExample {
        public static void main(String[] args) {
                String st1 = "Hello World, again from";
                String str[] = st1.split(" ");
                String token = ",";
                for (int i = 0; i < str.length; i++)
                        System.out.println(str[i]);

                String str1 = "This is String ,split by StringTokenizer,Gaurav ";
				StringTokenizer st = new StringTokenizer(str1," ");

				System.out.println("---- Split by space ------");
				while (st.hasMoreElements())
						System.out.println(st.nextElement());

				System.out.println("---- Split by comma ',' ------");
				StringTokenizer st2 = new StringTokenizer(str1, token);
				while (st2.hasMoreElements())
					System.out.println(st2.nextElement());
        }
}