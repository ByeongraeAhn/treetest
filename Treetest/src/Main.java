import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		
		//요구사항1 : 트리 구조가 표현된 데이터(list)에서 컨텐츠의 값이 ★인 데이터들만 정제하여 새로운 트리구조로 변환한다. (그림1 참조)
		//요구사항 : ★이 들어간 데이터는 최하위 노드(이하 리프)에만 포함될수있다.
		//요구사항 : 최상단 노드는 root로 명칭하며, 반드시 1개이다.
		//요구사항 : root이하의 노드들의 갯수나 depth는 제한이 없다.
		//요구사항 : ★이 들어간 노드의 상위노드는 트리의 포현을 위해 반드시 데이터가 포함되어야 한다.
		//요구사항 : 트리 구조가 표현된 데이터는 샘플과 같이 소팅이 되어있다는 전제이다.

		
		//알고리즘 적용전 데이터 (그림1)
		List<TestVo> oldList = new ArrayList<TestVo>();
		oldList.add(new TestVo("root","",""));
		oldList.add(new TestVo("대분류1","root",""));
		oldList.add(new TestVo("중분류1","대분류1",""));
		oldList.add(new TestVo("소분류1","중분류1","★"));
		oldList.add(new TestVo("소분류2","중분류1",""));
		oldList.add(new TestVo("중분류2","대분류1",""));
		oldList.add(new TestVo("소분류3","중분류2",""));
		oldList.add(new TestVo("대분류2","root",""));
		oldList.add(new TestVo("중분류3","대분류2",""));
		oldList.add(new TestVo("소분류4","중분류3",""));
		oldList.add(new TestVo("중분류4","대분류2",""));
		oldList.add(new TestVo("소분류5","중분류4",""));
		oldList.add(new TestVo("소분류6","중분류4",""));
		oldList.add(new TestVo("대분류3","root",""));
		oldList.add(new TestVo("중분류5","대분류3","★"));
		
		//알고리즘 적용후 데이터 샘플(그림2)
		List<TestVo> newList = new ArrayList<TestVo>();
		newList.add(new TestVo("root","",""));
		newList.add(new TestVo("대분류1","root",""));
		newList.add(new TestVo("중분류1","대분류1",""));
		newList.add(new TestVo("소분류1","중분류1","★"));
		newList.add(new TestVo("대분류3","root",""));
		newList.add(new TestVo("중분류5","대분류3","★"));
		
		
/////////////////////////////////////////////////////////////////////////////////////////////////////
		
		
		//모든 노드중 가장 깊은 depth 찾기
		int finalDepth = 가장깊은depth찾기(oldList);
		
		//병래리즘 적용
		for (int i = 0; i < finalDepth; i++) {
			oldList = 병래리즘(oldList);
		}
		
		//샘플데이터랑 비교해서 확인
		for (int i = 0; i < oldList.size(); i++) {
			if (oldList.get(i).get부모아이디().equals(newList.get(i).get부모아이디()) && oldList.get(i).get자신아이디().equals(newList.get(i).get자신아이디())) {
				System.out.println("같다");
			} else {
				System.out.println("틀리다");
			}
		}

	}

	
	
	
	
	
/////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	
	//모든 노드중 가장 깊은 depth 찾기
	private static int 가장깊은depth찾기(List<TestVo> oldList) {
		int cursorDepth = 0;
		int finalDepth = 0;
		for (int i = oldList.size()-1; i > 0; i--) {
			if (oldList.get(i).get부모아이디().equals(oldList.get(i-1).get자신아이디()) ) {
				cursorDepth += 1;
				if(cursorDepth >= finalDepth) {
					finalDepth = cursorDepth;
				} 
			} else {
				cursorDepth = 0;
			}
		}
		return finalDepth;
	}

	
	//루프 메서드. 트리 depth 만큼 호출. 
	private static List<TestVo> 병래리즘(List<TestVo> oldList) {
		//리프 찾기
		List<TestVo> leafList = 리프찾기(oldList);
		//리프노드이며 그리고 컨텐츠가 없는건 삭제  == 리프노드가 아니거나 혹은 컨텐츠가 있는건 추가(대우)
		List<TestVo> newList = 리프노드이며컨텐츠없는것제거(leafList);
		return newList;
	}
	
	//리프 찾기
	private static List<TestVo> 리프찾기(List<TestVo> oldList) {
		for (int i = 0; i < oldList.size(); i++) {
			if (i < (oldList.size()-1) && !oldList.get(i).get자신아이디().equals(oldList.get(i+1).get부모아이디())) {
				oldList.get(i).set리프유무("Y");
			} else if(i == oldList.size()-1) {
				oldList.get(i).set리프유무("Y");
			} else {
				oldList.get(i).set리프유무("N");
			}
		}
		return oldList;
	}
	
	//리프노드이며 그리고 컨텐츠가 없는건 삭제  == 리프노드가 아니거나 혹은 컨텐츠가 있는건 추가(대우)
	private static List<TestVo> 리프노드이며컨텐츠없는것제거(List<TestVo> leafList) {
		List<TestVo> setList = new ArrayList<TestVo>();
		for (TestVo testVo : leafList) {
			if (testVo.get리프유무().equals("N") || testVo.get컨텐츠().equals("★")) {
				setList.add(testVo);
			}
		}
		return setList; 
	}



}
