import java.util.*;
public class Pager {
	private long totalCount = -1;
	private long totalPage = -1;
	
	Pager(long totalCount){
		this.totalCount = totalCount;
		this.totalPage = (long)Math.ceil((double)totalCount/10)*10;
	}
	
	public String html(long pageIndex) {
		if(pageIndex <= 0) return "[!] 존재할 수 없는 index입니다. (음수 index 접근.)";
		if(pageIndex*10 > totalPage) return "[!] 잘못된 index 접근입니다. (존재하는 최대 페이지 index보다 더 큰 index에 접근.)";
		
		
		StringBuilder sb = new StringBuilder();
		
		sb.append("<a href='#'>[처음]</a>\n");
		sb.append("<a href='#'>[이전]</a>\n\n");
		
		int startIndex = (int) Math.ceil((double)pageIndex)/10 *10;
		for(int i=1; i<=10; i++) {
			if((startIndex +i)*10 > totalPage) break;
			
			sb.append("<a href='#'");
			
			if(startIndex +i == pageIndex)
				sb.append(" class='on'");
			
			sb.append(">").append(startIndex+i).append("</a>\n");
		}
		
		sb.append("\n<a href='#'>[다음]</a>\n");
		sb.append("<a href='#'>[마지막]</a>\n");
		
		return sb.toString();
	}

	public static void main(String[] args) {
		long totalCount = 10;
		long pageIndex = 10;
		
		Pager pager = new Pager(totalCount);
		System.out.println(pager.html(pageIndex));
	}

}
