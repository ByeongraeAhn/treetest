package library;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import vo.TestVo;

/**
 * @author norimsu
 * @email norimsu@gmail.com
 * Created by norimsu on 2018/06/30.
 */
public class 상현 {
  static List<TestVo> dirtyTree;

  public static List<TestVo> starTreeShaking(List<TestVo> tree) {
    dirtyTree = new ArrayList<TestVo>(tree);
    findStarBranch();
    return shaking();
  }

  private static List<TestVo> shaking() {
    return dirtyTree.parallelStream()
        .filter(leaf -> leaf.get리프유무() == "Y")
        .collect(Collectors.toList());
  }

  private static void findStarBranch() {
    dirtyTree.parallelStream()
        .filter(leaf -> leaf.get컨텐츠() == "★")
        .forEach(leaf -> checkLeaf(leaf));
  }

  private static void checkParent(TestVo leaf) {
    dirtyTree.parallelStream()
        .filter(leaf2 -> leaf2.get자신아이디() == leaf.get부모아이디())
        .forEach(leaf2 -> checkLeaf(leaf2));
  }

  private static void checkLeaf(TestVo leaf) {
    if (leaf.get리프유무() != "Y") {
      leaf.set리프유무("Y");
      checkParent(leaf);
    }
  }

}
