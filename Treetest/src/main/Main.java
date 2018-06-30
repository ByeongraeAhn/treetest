package main;
import java.util.ArrayList;
import java.util.List;

import library.병래;
import vo.TestVo;

public class Main {

	public static void main(String[] args) {
		
		//요구사항1 : 트리 구조가 표현된 데이터(list)에서 컨텐츠의 값이 ★인 데이터들만 정제하여 새로운 트리구조로 변환한다. (그림1 참조)
		//요구사항2 : ★이 들어간 데이터는 최하위 노드(이하 리프)에만 포함될수있다.
		//요구사항3 : 최상단 노드는 root로 명칭하며, 반드시 1개이다.
		//요구사항4 : root이하의 노드들의 갯수나 depth는 제한이 없다.
		//요구사항5 : ★이 들어간 노드의 상위노드는 트리의 포현을 위해 반드시 데이터가 포함되어야 한다.
		//요구사항6 : 트리 구조가 표현된 데이터는 샘플과 같이 소팅이 되어있다는 전제이다.

		
		//알고리즘 적용전 데이터 (그림1)
		List<TestVo> oldList = new ArrayList<TestVo>();
		oldList.add(new TestVo("root","",""));
		oldList.add(new TestVo("대분류1","root",""));
		oldList.add(new TestVo("중분류1","대분류1",""));
		oldList.add(new TestVo("소분류1","중분류1","★"));
		oldList.add(new TestVo("소분류2","중분류1","★"));
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
		List<TestVo> testList = new ArrayList<TestVo>();
		testList.add(new TestVo("root","",""));
		testList.add(new TestVo("대분류1","root",""));
		testList.add(new TestVo("중분류1","대분류1",""));
		testList.add(new TestVo("소분류1","중분류1","★"));
		testList.add(new TestVo("소분류2","중분류1","★"));
		testList.add(new TestVo("대분류3","root",""));
		testList.add(new TestVo("중분류5","대분류3","★"));
		
		
		
//////////////////////  여기다가 제출~~~  ///////////////////////////////////////////////////////////////////////////////
		List<TestVo> 병래꺼 = 병래.병래알고리즘(oldList);
		//샘플데이터랑 비교해서 확인
		Boolean result = test(testList, 병래꺼);
		System.out.println(result);
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	}

	
	
	
	
	
	
	
	//알고리즘 맞는지 확인하는 메서드
	private static boolean test(List<TestVo> testList, List<TestVo> myList) {
		for (int i = 0; i < myList.size(); i++) {
			if (myList.size()!=testList.size() || !testList.get(i).get자신아이디().equals(myList.get(i).get자신아이디())) {
				return false;
			} 
		}
		return true;
	}


}
