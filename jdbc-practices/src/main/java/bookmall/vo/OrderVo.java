package bookmall.vo;

public class OrderVo {

	private Long no;
	private String ord_no;
	private int pay;
	private String addr;
	private Long member_no;
	
	public Long getNo() {
		return no;
	}
	public void setNo(Long no) {
		this.no = no;
	}
	public String getOrd_no() {
		return ord_no;
	}
	public void setOrd_no(String ord_no) {
		this.ord_no = ord_no;
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
	public Long getMember_no() {
		return member_no;
	}
	public void setMember_no(Long member_no) {
		this.member_no = member_no;
	}
	@Override
	public String toString() {
		return "OrderVo [no=" + no + ", ord_no=" + ord_no + ", pay=" + pay + ", addr=" + addr + ", member_no="
				+ member_no + "]";
	}

}
