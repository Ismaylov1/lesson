package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {
    Util util = new Util();

    public UserDaoJDBCImpl() {

    }


    public void createUsersTable() {
        String sql = "CREATE TABLE customers\n" +
                "(\n" +
                "    Id INT not null  auto_increment PRIMARY KEY,\n" +
                "    Age INT,\n" +
                "    FirstName VARCHAR(20),\n" +
                "    LastName VARCHAR(20)\n" +
                ");";
        try {
            Statement stmt = util.getConnection().createStatement();
            stmt.execute(sql);
        } catch (SQLException e) {

        }
    }

    public void dropUsersTable() {
        String dUt = "DROP TABLE  customers";
        try {
            Statement del = util.getConnection().createStatement();
            del.execute(dUt);
        } catch (SQLException e) {

        }

    }

    public void saveUser(String name, String lastName, byte age) {
        String save = String.format("insert into customers(age, firstname, lastName) values( %d, '%s','%s');", age, name, lastName);
        try {
            Statement statement = util.getConnection().createStatement();

            statement.execute(save);
            System.out.format(" User с именем – %s добавлен в базу данных \n", name);
        } catch (SQLException e) {

        }
    }

    public void removeUserById(long id) {
        String remove = String.format("delete from customers where id = %d;", id);
        try (Statement statement = util.getConnection().createStatement()) {
            statement.execute(remove);
        } catch (SQLException e) {

        }
    }

    public List<User> getAllUsers() {
        List<User> userList = new ArrayList<>();
        String users = "select * from customers";
        User user = new User();
        try (Statement save = util.getConnection().createStatement()) {
            ResultSet resultSet = save.executeQuery(users);
            while (resultSet.next()) {
                user.setId((long) resultSet.getInt(1));
                user.setName(resultSet.getString(3));
                user.setLastName(resultSet.getString(4));
                user.setAge((byte) resultSet.getInt(2));

                userList.add(user);
                System.out.println(userList.toString());
            }
        } catch (SQLException e) {

        }
        return userList;
    }

    public void cleanUsersTable() {
        String dUt = "TRUNCATE TABLE  customers";
        try {
            Statement del = util.getConnection().createStatement();
            del.execute(dUt);
        } catch (SQLException e) {

        }

    }
}

