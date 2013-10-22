package logGenerator.logGenerating.logFileRecord;

public enum StatusCode{
	c100(100),
	c101(101),
	c102(102),
	c200(200),
	c201(201),
	c202(202),
	c203(203),
	c204(204),
	c205(205),
	c206(206),
	c207(207),
	c300(300),
	c301(301),
	c302(302),
	c303(303),
	c304(304),
	c305(305),
	c306(306),
	c307(307),
	c400(400),
	c401(401),
	c402(402),
	c403(403),
	c404(404),
	c405(405),
	c406(406),
	c407(407),
	c408(408),
	c409(409),
	C410(410),
	C411(411),
	C412(412),
	C413(413),
	C414(414),
	C415(415),
	C416(416),
	C417(417),
	C418(418),
	C419(419),
	C420(420),
	C421(421),
	C422(422),
	C423(423),
	C424(424),
	C425(425),
	C426(426),
	C449(449),
	C500(500),
	C501(501),
	C502(502),
	C503(503),
	C504(504),
	C505(505),
	C506(506),
	C507(507),
	C508(508),
	C509(509),
	C510(510);
	
	private int code = 0;
	StatusCode(int val) {
		this.code = val;
	}
	
	public int getIntegerCode(){
		return code;
	}
}