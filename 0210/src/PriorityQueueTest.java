import java.util.PriorityQueue;

public class PriorityQueueTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PriorityQueue<Integer> pQueue = new PriorityQueue<>();//최대힙으로 동작
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
