package com.romantupikov.hw6.mapper;

import com.romantupikov.hw6.model.Account;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;

public class AccountMapper implements AccountRepository {

    private static final String TABLE_ACCOUNT = "account";

    private static final String COLUMN_ID = "id";
    private static final String COLUMN_USERNAME = "username";
    private static final String COLUMN_PASSWORD = "password";

    private static final String CREATE_ACCOUNT_TABLE = "CREATE TABLE IF NOT EXISTS " + TABLE_ACCOUNT + " (" +
            COLUMN_ID + " INT AUTO_INCREMENT PRIMARY KEY , " +
            COLUMN_USERNAME + " VARCHAR(64) NOT NULL, " +
            COLUMN_PASSWORD + " VARCHAR(64) NOT NULL" +
            ") ENGINE = InnoDB;";

    private static final String INSERT_NEW_USER = "INSERT INTO " + TABLE_ACCOUNT +
            " ( " + COLUMN_USERNAME + ", " + COLUMN_PASSWORD + ") " +
            " VALUES (?, ?);";

    private static final String FIND_ALL = "SELECT * FROM " + TABLE_ACCOUNT + ";";

    private static final String FIND_BY_ID = "SELECT * FROM " + TABLE_ACCOUNT + " WHERE " + COLUMN_ID + "=?;";

    private static final String UPDATE = "UPDATE " + TABLE_ACCOUNT + " SET " + COLUMN_USERNAME + " = ?, " +
            COLUMN_PASSWORD + " = ? WHERE " + COLUMN_ID + " = ?;";

    private static final String DELETE = "DELETE FROM " + TABLE_ACCOUNT + " WHERE " + COLUMN_ID + " = ?;";

    private final Connection conn;

    public AccountMapper(Connection conn) {
        this.conn = conn;
        createTable();
    }

    private void createTable() {
        try (Statement stmt = conn.createStatement()) {
            stmt.executeUpdate(CREATE_ACCOUNT_TABLE);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Account create(Account account) {
        System.out.println("AccountMapper: create()");
        Account insertedAccount = null;
        try (PreparedStatement ps = conn.prepareStatement(INSERT_NEW_USER, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, account.getUsername());
            ps.setString(2, account.getPassword());
            ps.executeUpdate();
            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.first()) {
                    insertedAccount = new Account(account.getUsername(), account.getPassword());
                    insertedAccount.setId(rs.getLong(1));
                }
            }
            return insertedAccount;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return insertedAccount;
    }

    @Override
    public Collection<Account> findAll() {
        System.out.println("AccountMapper: findAll()");
        Collection<Account> accounts = null;
        try (Statement stmt = conn.createStatement()) {
            try (ResultSet rs = stmt.executeQuery(FIND_ALL)) {
                accounts = new ArrayList<>();
                while (rs.next()) {
                    Account account = new Account();
                    account.setId(rs.getLong(COLUMN_ID));
                    account.setUsername(rs.getString(COLUMN_USERNAME));
                    account.setPassword(rs.getString(COLUMN_PASSWORD));
                    accounts.add(account);
                }
                return accounts;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return accounts;
    }

    @Override
    public Account findById(Long id) {
        System.out.println("AccountMapper: findById()");
        Account foundAccount = null;
        try (PreparedStatement ps = conn.prepareStatement(FIND_BY_ID)) {
            ps.setLong(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.first()) {
                    foundAccount = new Account();
                    foundAccount.setId(rs.getLong(COLUMN_ID));
                    foundAccount.setUsername(rs.getString(COLUMN_USERNAME));
                    foundAccount.setPassword(rs.getString(COLUMN_PASSWORD));
                    return foundAccount;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return foundAccount;
    }

    @Override
    public Account update(Account account) {
        System.out.println("AccountMapper: update()");
        Account updatedAccount = null;
        try (PreparedStatement ps = conn.prepareStatement(UPDATE)) {
            ps.setString(1, account.getUsername());
            ps.setString(2, account.getPassword());
            ps.setLong(3, account.getId());
            ps.executeUpdate();
            updatedAccount = new Account(account);
            return updatedAccount;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return updatedAccount;
    }

    @Override
    public Account delete(Account account) {
        System.out.println("AccountMapper: delete()");
        Account deletedAccount = null;
        try (PreparedStatement ps = conn.prepareStatement(DELETE)) {
            ps.setLong(1, account.getId());
            ps.executeUpdate();
            deletedAccount = new Account(account);
            return deletedAccount;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return deletedAccount;
    }
}
