package bookmall.vo;

public class OrderBookVo {

	private Long bookNo;
	private Long orderNo;
	private int qty;
	private int price;
	public Long getBookNo() {
		return bookNo;
	}
	public void setBookNo(Long bookNo) {
		this.bookNo = bookNo;
	}
	public Long getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(Long orderNo) {
		this.orderNo = orderNo;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "OrderBookVo [bookNo=" + bookNo + ", orderNo=" + orderNo + ", qty=" + qty + ", price=" + price + "]";
	}
	
	
}
