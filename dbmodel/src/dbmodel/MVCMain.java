package dbmodel;

public class MVCMain {

	public static void main(String[] args) {
		dbconnection connObj = new dbconnection();/// conection object
		sqlModel sqlObj = new sqlModel();//// sql model object
		theViewModel viewObj = new theViewModel();
		theControlModel controlerobj=new theControlModel(connObj, sqlObj, viewObj);
		
	}
	
}
