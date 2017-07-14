package Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;

import CustomerFactory.CustomerFactory;
import MiddleLayer.ICustomer;

public class MySQLRepository extends RepositoryBase {
	private Connection con;
	private Statement stat;
	private ResultSet result;
	private String queryStr;
	private String url = "jdbc:mysql://localhost:3306/customer_database?useSSL=false";

	public MySQLRepository() {
		try {
			con = DriverManager.getConnection(url, "root", "thang12a");
			stat = con.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void insert(Object obj) {
		ICustomer cust = (ICustomer) obj;
		try {
			queryStr = "INSERT INTO `customer_database`.`customer_info` (`CustomerID`, `CustomerType`, `CustomerName`, `PhoneNumber`, `BillAmount`, `BillTime`, `Address`) VALUES ('"
					+ cust.getID() + "', '" + cust.getCustomerType() + "', '" + cust.getCustomerName() + "', '"
					+ cust.getPhoneNumber() + "', '" + cust.getBillAmount() + "', '" + cust.getBillTime() + "', '"
					+ cust.getAddress() + "');";
			System.out.println(queryStr);
			stat.executeUpdate(queryStr);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void remove(Object obj) {
		int ID = ((ICustomer) obj).getID();
		try {
			queryStr = "DELETE FROM `customer_database`.`customer_info` WHERE `CustomerID`=" + "'" + ID + "';";
			stat.executeUpdate(queryStr);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Object get() {
		return createIterator();
	}

	@Override
	public Object find(Object obj) {
		int ID = ((ICustomer) obj).getID();
		ICustomer cust = null;
		CustomerFactory factory = CustomerFactory.getInstance();
		try {
			queryStr = "SELECT * FROM customer_database.customer_info WHERE CustomerID = " + "'" + ID + "';";
			System.out.println(queryStr);
			result = stat.executeQuery(queryStr);
			if (result.next()) {
				cust = factory.createCustomer(result.getString("CustomerType"));
				bindCust(result, cust);
			}
			return cust;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	private void bindCust(ResultSet result, ICustomer cust) {
		try {
			cust.setID(result.getString("CustomerID"));
			cust.setCustomerType(result.getString("CustomerType"));
			cust.setCustomerName(result.getString("CustomerName"));
			cust.setBillAmount(String.valueOf(result.getInt("BillAmount")));
			cust.setBillTime(result.getString("BillTime"));
			cust.setPhoneNumber(result.getString("PhoneNumber"));
			cust.setAddress(result.getString("Address"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update(Object obj) {
		ICustomer cust = (ICustomer) obj;
		try {
			queryStr = "UPDATE `customer_database`.`customer_info` SET `CustomerID`='" + cust.getID()
					+ "', `CustomerType`='" + cust.getCustomerType() + "', `CustomerName`='" + cust.getCustomerName()
					+ "', `PhoneNumber`='" + cust.getPhoneNumber() + "', `BillAmount`='" + cust.getBillAmount()
					+ "', `BillTime`='" + cust.getBillTime() + "', `Address`='" + cust.getAddress()
					+ "' WHERE `CustomerID` = '" + cust.getID() + "' ;";
			System.out.println(queryStr);
			stat.executeUpdate(queryStr);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Iterator<ICustomer> createIterator() {
		ArrayList<ICustomer> custList = new ArrayList<>();
		ICustomer tempCust;
		CustomerFactory factory = CustomerFactory.getInstance();
		// CustomerBase
		try {
			queryStr = "SELECT * FROM customer_info";
			result = stat.executeQuery(queryStr);
			while (result.next()) {
				tempCust = factory.createCustomer(result.getString("CustomerType"));
				bindCust(result, tempCust);
				custList.add(tempCust);
			}
			return custList.iterator();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	// public void printQuery(){
	// System.out.println("Query: "+ queryStr);
	// }
}
