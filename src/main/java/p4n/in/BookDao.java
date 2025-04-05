package p4n.in;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookDao {

    // Get database connection
    public static Connection getConnection() {
        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookstore", "root", "root");
        } catch (Exception e) {
            System.out.println("Error while getting the connection: " + e);
        }
        return con;
    }

    // Save book to the database
    public static int save(Book b) {
        int status = 0;
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = getConnection();
            String query = "INSERT INTO books(title, author, price, genre, publication_year) VALUES(?,?,?,?,?)";
            ps = con.prepareStatement(query);
            ps.setString(1, b.getTitle());
            ps.setString(2, b.getAuthor());
            ps.setDouble(3, b.getPrice());
            ps.setString(4, b.getGenre());  // Make sure 'genre' exists in the Book object
            ps.setInt(5, b.getPublicationYear());

            status = ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error while saving the book: " + e);
        } finally {
            try {
                if (ps != null) ps.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                System.out.println("Error while closing resources: " + e);
            }
        }
        return status;
    }

    // Update book in the database
    public static int update(Book b) {
        int status = 0;
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = getConnection();
            String query = "UPDATE books SET title=?, author=?, price=?, genre=?, publication_year=? WHERE id=?";
            ps = con.prepareStatement(query);
            ps.setString(1, b.getTitle());
            ps.setString(2, b.getAuthor());
            ps.setDouble(3, b.getPrice());
            ps.setString(4, b.getGenre());  // Make sure 'genre' exists in the Book object
            ps.setInt(5, b.getPublicationYear());
            ps.setInt(6, b.getId());

            status = ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error while updating the book: " + e);
        } finally {
            try {
                if (ps != null) ps.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                System.out.println("Error while closing resources: " + e);
            }
        }
        return status;
    }

    // Delete book from the database
    public static int delete(Book b) {
        int status = 0;
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = getConnection();
            String query = "DELETE FROM books WHERE id=?";
            ps = con.prepareStatement(query);
            ps.setInt(1, b.getId());
            status = ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error while deleting the book: " + e);
        } finally {
            try {
                if (ps != null) ps.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                System.out.println("Error while closing resources: " + e);
            }
        }
        return status;
    }

    // Get all books from the database
    public static List<Book> getAllBooks() {
        List<Book> list = new ArrayList<Book>();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = getConnection();
            ps = con.prepareStatement("SELECT * FROM books");
            rs = ps.executeQuery();
            while (rs.next()) {
                Book b = new Book();
                b.setId(rs.getInt("id"));
                b.setTitle(rs.getString("title"));
                b.setAuthor(rs.getString("author"));
                b.setPrice(rs.getDouble("price"));
                b.setGenre(rs.getString("genre"));  // Make sure 'genre' exists in the Book object
                b.setPublicationYear(rs.getInt("publication_year"));
                list.add(b);
            }
        } catch (SQLException e) {
            System.out.println("Error while fetching all books: " + e);
        } finally {
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                System.out.println("Error while closing resources: " + e);
            }
        }
        return list;
    }

    // Get a book by ID from the database
    public static Book getBookById(int id) {
        Book b = null;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = getConnection();
            String query = "SELECT * FROM books WHERE id=?";
            ps = con.prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                b = new Book();
                b.setId(rs.getInt("id"));
                b.setTitle(rs.getString("title"));
                b.setAuthor(rs.getString("author"));
                b.setPrice(rs.getDouble("price"));
                b.setGenre(rs.getString("genre"));  // Make sure 'genre' exists in the Book object
                b.setPublicationYear(rs.getInt("publication_year"));
            }
        } catch (SQLException e) {
            System.out.println("Error while fetching the book by ID: " + e);
        } finally {
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                System.out.println("Error while closing resources: " + e);
            }
        }
        return b;
    }
}
