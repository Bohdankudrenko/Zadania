package Zadanie1;

import javax.xml.transform.Result;
import java.sql.*;
import java.sql.SQLException;

public class UsersCRUD {

    //Uwierzytelnianie użytkownika
    public boolean authenticateUser(String username, String pin, String role) throws SQLException {
        String sql = "SELECT * FROM users WHERE username = ? AND pin = ? AND role = ?";
        try (Connection conn = DBConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, username);
            stmt.setString(2, pin);
            stmt.setString(3, role);
            ResultSet rs = stmt.executeQuery();
            return rs.next();
        }
    }

    //Dodanie
    public void addUser(String username, String pin) throws SQLException{
        String sql = "INSERT INTO users (username, pin, balance, role) VALUES (?, ?, 0, 'user')";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, username);
            stmt.setString(2, pin);
            stmt.executeUpdate();
            System.out.println("Użytkownik dodany!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //Saldo konta
    public void deposit(String username, double amount) throws SQLException{
        String sql = "UPDATE users SET balance = balance + ? WHERE username = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setDouble(1, amount);
            stmt.setString(2, username);
            stmt.executeUpdate();
            System.out.println("Wpłata zakończona sukcesem!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //Wypłata pieniędzy
    public void withDraw(String username, double amount) throws SQLException{
        String checkSQL = "SELECT balance FROM users WHERE username = ?";
        String updateSQL = "UPDATE users SET balance = balance - ? WHERE username = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement checkStmt = conn.prepareStatement(checkSQL)) {
            checkStmt.setString(1, username);
            ResultSet rs = checkStmt.executeQuery();
            if(rs.next() && rs.getDouble("balance") >= amount){
                try(PreparedStatement updateStmt = conn.prepareStatement(updateSQL)){
                    updateStmt.setDouble(1, amount);
                    updateStmt.setString(2, username);
                    updateStmt.executeUpdate();
                    System.out.println("Wypłata zakończnona sukcesem!");
                }
            }
            else System.out.println("Brak wystarczających środków!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //Sprawdzanie salda
    public void showBalance(String username) throws SQLException{
        String sql = "SElECT balance FROM users WHERE username = ?";
        try (Connection conn = DBConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();
            if(rs.next()){
                System.out.println("Twoje saldo: "+ rs.getDouble("balance")+ " PLN");
            }
        }
    }

    //Zmiana PIN-u
    public void changePIN(String username, String newPin) throws SQLException{
        String sql = "UPDATE users SET pin = ? WHERE username = ?";
        try (Connection conn = DBConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setString(1, newPin);
            stmt.setString(2, username);
            stmt.executeUpdate();
            System.out.println("PIN zmieniono!");
        }
    }



}

