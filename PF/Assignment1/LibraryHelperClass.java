package ass1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LibraryHelperClass {
	private Connection connection;
	private ResultSet resultSet;
	private Statement statement;
	private Scanner sc = new Scanner(System.in);

	public LibraryHelperClass() {
		connection = null;
		resultSet = null;
		statement = null;
		ConnectionUtil conUtil = new ConnectionUtil();
		connection = conUtil.getConnection();
	}

	// get connection
	public Connection getConnection() {
		return connection;
	}

	// set connection
	public void setConnection(Connection connection) {
		this.connection = connection;
	}

	public List<Title> getBooksDataRelatedToAuthor() {
		System.out.println("Enter Name of Author");
		String query = "SELECT t.title_id,t.title_nm,t.subject_id,t.publisher_id FROM "
				+ "authors a inner join title_author ta ON a.author_id = ta.author_id "
				+ "inner join titles t where (t.title_id=ta.title_id AND a.author_nm='"
				+ sc.nextLine() + "')";
		List<Title> titleList = new ArrayList<Title>();

		try {
			statement = connection.createStatement();
			resultSet = statement.executeQuery(query);
			while (resultSet.next()) {
				Title title = new Title(resultSet.getInt(1),
						resultSet.getString(2), resultSet.getInt(3),
						resultSet.getInt(4));
				titleList.add(title);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return titleList;
	}

	public boolean addNewMemberAndIssueBook() {
		Member member = null;
		Book book = null;
		boolean flag = false;
		System.out.println("Enter Member id of member");
		String query = "SELECT * FROM Members where member_id=" + sc.nextInt();
		try {
			statement = connection.createStatement();
			resultSet = statement.executeQuery(query);
			while (resultSet.next()) {
				member = new Member(resultSet.getInt(1),
						resultSet.getString(2), resultSet.getString(3),
						resultSet.getString(4), resultSet.getString(5)
								.charAt(0), resultSet.getString(6).charAt(0));
			}
			sc.nextLine();
			System.out.println("Enter Name of Book for issue");
			String bookName = sc.nextLine();

			String query1 = "SELECT t.title_id,b.accession_no,b.purchase_dt,b.price,b.status from Titles t inner join books b where (t.title_id=b.title_id AND t.title_nm='"
					+ bookName + "')";

			resultSet = statement.executeQuery(query1);
			if (resultSet.next()) {
				book = new Book(resultSet.getInt(2), resultSet.getInt(1),
						resultSet.getString(3), resultSet.getDouble(4),
						resultSet.getInt(5));
			} else {
				return false;
			}

			if (book.getStatus() == 0) {
				query = "INSERT INTO Book_issue (accession_no,member_id)"
						+ "VALUES(" + book.getAccessionNo() + ","
						+ member.getMemberId() + ")";
				int i = statement.executeUpdate(query);
				if (i == 1) {
					System.out.println("book inserted into book issue");
					query = "Update books Set status=1 where accession_no="
							+ book.getAccessionNo();
					i = statement.executeUpdate(query);
					if (i == 1) {

						flag = true;
						return flag;
					}
				} else {
					System.out.println("Book is not issued");
					return flag;
				}
			} else {

				return flag;
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return flag;
	}

	public int getNumberOfBooksNotUseful() {
		PreparedStatement preparedStatement = null;
		int noOfBooks = 0;
		String query = "select distinct b.accession_no from book_issue bi right join books b on b.accession_no=bi.accession_no "
				+ "AND bi.Issue_date=(Select max(Issue_date) from book_issue bi1  "
				+ "where bi1.accession_no=bi.accession_no group by (bi1.accession_no)) "
				+ "Where((DATEDIFF( NOW(), bi.Issue_date)>=365) or bi.issue_date is null)";
		String query1 = "Delete from books where accession_no=?";
		String query2 = "Delete from book_issue where accession_no=?";
		String query3 = "Delete from book_return where accession_no=?";
		try {
			statement = connection.createStatement();
			resultSet = statement.executeQuery(query);
			while (resultSet.next()) {
				preparedStatement = connection.prepareStatement(query2);
				preparedStatement.setInt(1, resultSet.getInt(1));
				preparedStatement.executeUpdate();
				preparedStatement = connection.prepareStatement(query3);
				preparedStatement.setInt(1, resultSet.getInt(1));
				preparedStatement.executeUpdate();
				preparedStatement = connection.prepareStatement(query1);
				preparedStatement.setInt(1, resultSet.getInt(1));

				noOfBooks = noOfBooks + preparedStatement.executeUpdate();
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return noOfBooks;

	}
}
