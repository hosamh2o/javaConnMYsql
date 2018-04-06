package dbmodel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class theControlModel {

	private dbconnection connObj;
	private sqlModel sqlObj;
	private theViewModel viewObj;
	private Statement stmt = null;
	private String sql = "";
	private ResultSet result = null;
	public theControlModel(dbconnection connObj, sqlModel sqlObj, theViewModel viewObj) {
		this.connObj = connObj;
		this.sqlObj = sqlObj;
		this.viewObj = viewObj;
		this.viewObj.addCalculateListener(new btnListener());
	}class btnListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			int response = viewObj.getComfirm();
			try {
				if (response <= 1 && response >= 0) {
					if (response == 0) {
						String QrCode = viewObj.getQrCode();
						System.out.println(QrCode);
						sql = sqlObj.getSearchSql(QrCode);
						stmt = connObj.connect().createStatement();
						result = stmt.executeQuery(sql);
						if (result.next()) {
							double total = viewObj.getTotal();
							sqlObj.calculDiscount(total);
							double discountTotal = sqlObj.getDiscountTotal();
							double discount = sqlObj.getDiscount();
							viewObj.setDiscountTotal(discountTotal);
							viewObj.setDiscount(discount);
						}result.close();
						stmt.close();
						connObj.Closeconnection();
					}else {
						String QrCode2 = viewObj.getQrCode();
						sql = sqlObj.getInsertSql(QrCode2);
						stmt = connObj.connect().createStatement();
						stmt.executeUpdate(sql);
						System.out.println("insertion done");
						stmt.close();
						connObj.Closeconnection();

						double total = viewObj.getTotal();
						sqlObj.calculDiscount(total);
						double discountTotal = sqlObj.getDiscountTotal();
						double discount = sqlObj.getDiscount();

						viewObj.setDiscountTotal(discountTotal);
						viewObj.setDiscount(discount);
					}
				}

			}

			catch (SQLException ex) {

				System.out.println(ex);

				viewObj.displayErrorMessage("error ");

			}

		}
	}

}
