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

		
		//트리 데이터(그림1)
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
		oldList.add(new TestVo("소분류6","소분류6",""));
		oldList.add(new TestVo("대분류3","root",""));
		oldList.add(new TestVo("중분류5","대분류3","★"));
		
		
		
		
		//변환된 트리 데이터(그림2)
		List<TestVo> newList = new ArrayList<TestVo>();
		newList.add(new TestVo("root","",""));
		newList.add(new TestVo("대분류1","root",""));
		newList.add(new TestVo("중분류1","대분류1",""));
		newList.add(new TestVo("소분류1","중분류1","★"));
		newList.add(new TestVo("대분류3","root",""));
		newList.add(new TestVo("중분류5","대분류3","★"));

	}

}
