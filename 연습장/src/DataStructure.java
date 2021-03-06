
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class DataStructure {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("--------배열");
		int[] numbers = {1,2,3,4,5};
		System.out.println("numbers.toString() : "+numbers.toString());
		System.out.println("Arrays.toString(numbers): "+Arrays.toString(numbers));
		System.out.println("numbers:" + numbers);
		
		System.out.println("--------큐");
		Queue<Integer> qu = new LinkedList<Integer>();
		qu.offer(1);
		qu.offer(2);
		System.out.println(qu);
		
		System.out.println("--------리스트");
		List<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(2);
		System.out.println(list.toString());
		
		System.out.println("--------스택");//스택->벡터->리스트 상속함
		Stack<Integer> stack = new Stack<Integer>();
		stack.add(1);
		stack.add(2);
		System.out.println(stack.toString());
	}

}
