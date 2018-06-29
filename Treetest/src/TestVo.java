
public class TestVo {
	private String 자신아이디;
	private String 부모아이디;
	private String 컨텐츠;
	private String 리프유무;
	
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

	public String get리프유무() {
		return 리프유무;
	}

	public void set리프유무(String 리프유무) {
		this.리프유무 = 리프유무;
	}

	@Override
	public String toString() {
		return "TestVo [자신아이디=" + 자신아이디 + ", 부모아이디=" + 부모아이디 + ", 컨텐츠=" + 컨텐츠 + ", 리프유무=" + 리프유무 + "]";
	}


}
