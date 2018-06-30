package library;

import java.util.ArrayList;
import java.util.List;

import vo.TestVo;

public class 병래 {
	
	//모든 노드중 가장 깊은 depth 찾기
	public static List<TestVo> 병래알고리즘(List<TestVo> oldList) {
		
		int finalDepth = 가장깊은depth찾기(oldList);
		
		//병래리즘 적용
		for (int i = 0; i < finalDepth; i++) {
			oldList = 병래리즘(oldList);
		}
		
		return oldList;
	}
	
	//루프 메서드. 트리 depth 만큼 호출. 
	private static List<TestVo> 병래리즘(List<TestVo> oldList) {
		//리프 찾기
		List<TestVo> leafList = 리프찾기(oldList);
		//리프노드이며 그리고 컨텐츠가 없는건 삭제  == 리프노드가 아니거나 혹은 컨텐츠가 있는건 추가(대우)
		List<TestVo> newList = 리프노드이며컨텐츠없는것제거(leafList);
		return newList;
	}
	
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
