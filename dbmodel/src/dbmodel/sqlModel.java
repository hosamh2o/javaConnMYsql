package dbmodel;

public class sqlModel {

	private double discount;
	private double discountTotal;

	public double getDiscount() {
		return discount;
	}

	public String getInsertSql(String qrcode) {
		String sql = "insert into tbqrcode (qrcode) VALUES(" + qrcode + ")";
		return sql;
	}

	public String getSearchSql(String qrCode) {
		String sql = "SELECT * FROM tbQrCode where qrCode=" + qrCode;

		return sql;
	}

	public double getDiscountTotal() {
		return discountTotal;
	}

	void calculDiscount(double total) {
		this.discountTotal = total * 0.9;
		this.discount = total - discountTotal;

	}

}
