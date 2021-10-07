package bookmall.vo;

public class OrderVo {

	private Long no;
	private String ordNno;
	private int pay;
	private String addr;
	private Long memberNo;
	
	public Long getNo() {
		return no;
	}
	public void setNo(Long no) {
		this.no = no;
	}
	public String getOrdNo() {
		return ordNno;
	}
	public void setOrdNo(String ord_no) {
		this.ordNno = ord_no;
	}
	public int getPay() {
		return pay;
	}
	public void setPay(int pay) {
		this.pay = pay;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public Long getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(Long member_no) {
		this.memberNo = member_no;
	}
	@Override
	public String toString() {
		return "OrderVo [no=" + no + ", ord_no=" + ordNno + ", pay=" + pay + ", addr=" + addr + ", member_no="
				+ memberNo + "]";
	}

}
