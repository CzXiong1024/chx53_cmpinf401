
public class Lab10 {

	public static void main(String[] args) {
		System.out.println("Test for Taks1 (method of sumOfDigits):");
		int x = -12345;
		int output = sumOfDigits(x);
		System.out.println("Output for num "+x+" is: "+output);
		System.out.println("==============================================");
		System.out.println("Test for Taks2 (method of printArrayElements):");
		int[] a = {1,2,3,4,5,6,7,8,9};
		System.out.println("Output for task2:");
		printArrayElements(a,0);
		System.out.println("==============================================");
		System.out.println("Test for Taks3 (method of printCombos):");
		int[] b = {2,3,5,7,10};
		printCombos(b,"",0,3);
	}
	
	//method for task 1
	public static int sumOfDigits(int x) {
		if(x<0) {
			x = -1*x;
		}
		if(x<10) {
			return x;
		}
		return x%10+sumOfDigits(x/10);
	}
	
	//method for task 2
	public static void printArrayElements(int[] a, int index) {
		System.out.println(a[index]);
		if(index == a.length-1) {
			return;
		}
		printArrayElements(a,index+1);
	}
	
	//method for task 3
	public static void printCombos(int[] a, String out, int startIndex, int k) {
		if( k == 0) {
			System.out.println(out);
		}else {
			for(int i = startIndex; i <= a.length-k; i++) {
				out += a[i] + " ";
				printCombos(a,out,i+1,k-1);
				out = out.substring(0,out.length()-2);
			}
		}
		
	}
}
