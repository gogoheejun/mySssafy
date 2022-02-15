import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MeetingRoomGreedyTest {

	static class Meeting implements Comparable<Meeting>{ //나중에 제출할라면 한파일에 제출해야해서 이너클래스
		int start, end;
		public Meeting(int start, int end) {
			this.start = start;
			this.end = end;
		}
		
		@Override
		public int compareTo(Meeting o) {
			return this.end != o.end? this.end - o.end :this.start - o.start; 
		}
		
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int count = sc.nextInt();
		Meeting[] meetings = new Meeting[count];
		for(int i=0; i<count; i++) {
			meetings[i] = new Meeting(sc.nextInt(), sc.nextInt());
		}
		List<Meeting> result = getSchedule(meetings);
		
		StringBuilder sb = new StringBuilder();
		sb.append(result.size()).append("\n");
		
		//모아서 출력해라. 이렇게 하는게 좋음.
		for(Meeting meeting : result) {
			sb.append(meeting.start).append(" ").append(meeting.end).append("\n");
		}
		System.out.println(sb.toString());
	}
	
	public static List<Meeting> getSchedule(Meeting[] meetings){
		ArrayList<Meeting> result = new ArrayList<Meeting>();
		Arrays.sort(meetings);
		result.add(meetings[0]);//첫회의 추가(종료시간 가장 빠른회의)
		
		for(int i=0, size = meetings.length; i<size; i++) {
			if(result.get(result.size()-1).end <= meetings[i].start) {
				result.add(meetings[i]);
			}
		}
		return result;
		
	}

}
