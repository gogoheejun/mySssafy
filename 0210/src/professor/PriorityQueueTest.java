package professor;

import java.util.PriorityQueue;
/**
 * @author kimtaehee
 */
public class PriorityQueueTest {

	public static void main(String[] args) {
		
		PriorityQueue<Integer> pQueue = new PriorityQueue<Integer>(); // 최소힙으로 동작 , 비교구현이 달라지면 최대힙의결과도 될수 있음.
		pQueue.offer(10);
		pQueue.offer(30);
		pQueue.offer(5);
		pQueue.offer(50);
		pQueue.offer(20);
		
		System.out.println(pQueue.poll());
		System.out.println(pQueue.poll());
		System.out.println(pQueue.poll());
		System.out.println(pQueue.poll());
		System.out.println(pQueue.poll());
		
	}

}
