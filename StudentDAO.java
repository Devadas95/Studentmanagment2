package dao;

import db.DBConnection;
import model.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class StudentDAO {
    public static boolean addStudent(Student student) {
        try {
            Connection Conn = DBConnection.getConnection();
            String sql = "insert into student (name, email, age) values (?, ?, ?)";
            PreparedStatement ps = Conn.prepareStatement(sql);
            ps.setString(1, student.getName());
            ps.setString(2, student.getEmail());
            ps.setInt(3, student.getAge());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static List<Student> getAllStudents() {
        List<Student> list = new ArrayList<>();
        try {
            Connection conn = DBConnection.getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM students");
            while (rs.next()) {
                list.add(new Student(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getInt("age")
                ));
            }
        }catch (SQLException e){
                e.printStackTrace();
            }
            return list;
        }

        public static boolean updateStudent(Student student){
            try {
                Connection conn = DBConnection.getConnection();
                String sql = "update student set name=?, email=?, age=? where id=?";
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setString(1, student.getName());
                ps.setString(2, student.getEmail());
                ps.setInt(3, student.getAge());
                ps.setInt(4, student.getId());
                return ps.executeUpdate() > 0;
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return false;
        }

        public static boolean deleteStudent(int id){
            try {
                Connection conn = DBConnection.getConnection();
                String sql = "DELETE FROM student WHERE id=?";
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setInt(1, id);
                return ps.executeUpdate() > 0;
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return false;
        }

    }
