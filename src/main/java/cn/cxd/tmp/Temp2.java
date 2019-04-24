package cn.cxd.tmp;

public class Temp2 {

	public static void main(String[] args) {
		

		StringBuilder sb1 = new StringBuilder();
		for(int i=1; i<11; i++) {
			
			sb1.append(i);
		}
		
		System.out.println(sb1.toString());
		System.out.println(sb1.toString().substring(0,sb1.length()-1));
	}

}
