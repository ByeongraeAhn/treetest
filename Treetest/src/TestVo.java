
public class TestVo {
	private String 자신아이디;
	private String 부모아이디;
	private String 컨텐츠;
	
	public TestVo(String 자신아이디, String 부모아이디, String 컨텐츠) {
		super();
		this.자신아이디 = 자신아이디;
		this.부모아이디 = 부모아이디;
		this.컨텐츠 = 컨텐츠;
	}
	
	public String get자신아이디() {
		return 자신아이디;
	}
	public void set자신아이디(String 자신아이디) {
		this.자신아이디 = 자신아이디;
	}
	public String get부모아이디() {
		return 부모아이디;
	}
	public void set부모아이디(String 부모아이디) {
		this.부모아이디 = 부모아이디;
	}
	public String get컨텐츠() {
		return 컨텐츠;
	}
	public void set컨텐츠(String 컨텐츠) {
		this.컨텐츠 = 컨텐츠;
	}

	@Override
	public String toString() {
		return "TestVo [부모아이디=" + 부모아이디 + ", 자신아이디=" + 자신아이디 + ", 컨텐츠=" + 컨텐츠 + "]";
	}

}
