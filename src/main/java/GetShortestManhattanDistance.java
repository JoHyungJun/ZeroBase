import java.util.*;

public class GetShortestManhattanDistance {
	
	// 좌표값을 콘솔로 입력받는 입력 부
	public static int[][] inputCoordinates() {
		Scanner sc = new Scanner(System.in);
		int[][] coors = new int[11][2];
		
		System.out.print("현재 자신의 위치 좌표값을 입력해주세요. (순서대로 x, y)\n:");
		coors[0][0] = sc.nextInt();
		coors[0][1] = sc.nextInt();
		
		System.out.println("검사할 좌표들을 입력해주세요. (순서대로 x, y)");
		int x = -1; int y = -1;
		for(int i=1; i<=10; i++) {
			System.out.print(":");
			x = sc.nextInt();
			y = sc.nextInt();
			
			if(coors[0][0] == x && coors[0][1] == y) {
				System.out.println("[!] 현재 위치와 같은 좌표를 입력했습니다. 다시 입력해주세요.");
				i--;
				continue;
			}
			
			boolean flag = false;
			for(int j=1; j<=i; j++) {
				if(coors[j][0] == x && coors[j][1] == y) {
					System.out.println("[!] 이전에 입력했던 좌표 중 동일한 좌표가 존재합니다. 다시 입력해주세요.");
					flag = true;
					break;
				}
			}
			if(flag) {
				i--;
				continue;
			}
			
			coors[i][0] = x;
			coors[i][1] = y;
		}
		System.out.println("\n성공적으로 입력이 완료되었습니다.\n");
		
		return coors;
	}
	
		
	// 입력 받은 좌표들로 가장 짧은 거리를 계산하는 계산 부
	public static List<int[]> solution() {
		int[][] coors = inputCoordinates();
		
		List<int[]> list = new LinkedList();
		int minDistance = Integer.MAX_VALUE;
		for(int i=1; i<=10; i++) {
			int dis = Math.abs(coors[0][0] - coors[i][0])
					+ Math.abs(coors[0][1] - coors[i][1]);
			
			if(minDistance >= dis) {
				if(minDistance > dis) {
					list.clear();
					minDistance = dis;
				}
				
				list.add(coors[i]);
			}
		}
		
		return list;
	}
	
	
	// 편의를 위해 계산 결과로 나온 list를 출력하는 출력 부
	public static void printShortestDistance(List<int[]> list) {
		System.out.println("== 가장 가까운 좌표를 출력합니다. ==\n");
		
		for(int[] arr : list)
			System.out.println(Arrays.toString(arr));
		
		System.out.println("\n== 프로그램 종료. ==");
	}
	
	
	public static void main(String[] args) {
		printShortestDistance(solution());
	}

}
