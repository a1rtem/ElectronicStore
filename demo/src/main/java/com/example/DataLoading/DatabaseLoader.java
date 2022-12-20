package com.example.DataLoading;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.example.Coupons.*;
import com.example.Products.*;

public class DatabaseLoader implements DataLoader {

    private Connection connection;

    public DatabaseLoader(Connection connection) {
        this.connection = connection;
    }

    /**
     * Loads all products from the database.
     * 
     * @return list of products
     */
    @Override
    public List<Product> loadProductData() {
        List<Product> list = new ArrayList<Product>();

        try {
            // Adds games
            List<Product> games = loadGames(this.connection);
            for (Product game : games) {
                list.add(game);
            }

            // Adds boardgames
            List<Product> boardGames = loadBoardGames(this.connection);
            for (Product boardGame : boardGames) {
                list.add(boardGame);
            }

            // Adds video game disks
            List<Product> diskGames = loadVideoGameDisks(this.connection);
            for (Product diskGame : diskGames) {
                list.add(diskGame);
            }

            // Adds video game digital copies
            List<Product> digitalGames = loadVideoGameDigitalCopies(this.connection);
            for (Product digitalGame : digitalGames) {
                list.add(digitalGame);
            }

            // Adds consoles
            List<Product> consoles = loadConsoles(this.connection);
            for (Product console : consoles) {
                list.add(console);
            }

            // Adds computers
            List<Product> computers = loadComputers(this.connection);
            for (Product computer : computers) {
                list.add(computer);
            }

        } catch (Exception e) {
            System.out.println("Something went wrong while reading from the database.");
            System.out.println(e);
        }

        return list;
    }

    /**
     * Overriding the loadCouponData inside DataLoader to load coupons
     * 
     * @return list of coupons
     */
    @Override
    public List<Coupon> loadCouponData() {
        List<Coupon> coupons = new ArrayList<Coupon>();
        try {
            coupons.addAll(loadCoupons(this.connection));

        } catch (SQLException e) {
            System.out.println("Error occurred while loading coupons");
            e.printStackTrace();
        }
        return coupons;
    }

    /**
     * loads coupons
     * 
     * @param connection
     * @return list of product
     * @throws SQLException
     */
    public static List<Coupon> loadCoupons(Connection connection) throws SQLException {
        List<Coupon> coupons = new ArrayList<Coupon>();
        Statement getDiskGames = connection.createStatement();
        ResultSet result = getDiskGames.executeQuery("SELECT * FROM coupon");

        while (result.next()) {
            if (result.getString("type").equals("Credit")) {
                coupons.add(new Credit(result.getString("type"), result.getDouble("amount")));
            } else if (result.getString("type").equals("Discount")) {
                coupons.add(new Discount(result.getString("type"), result.getInt("amount"), result.getString("title")));
            } else if (result.getString("type").equals("Game Key")) {
                coupons.add(new GameKey(result.getString("type"), result.getString("product")));
            }
        }

        return coupons;
    }

    /**
     * Loads games
     * 
     * @param connection
     * @return list of product
     * @throws SQLException
     */
    public static List<Product> loadGames(Connection connection) throws SQLException {
        List<Product> games = new ArrayList<Product>();
        Statement getGames = connection.createStatement();
        ResultSet result = getGames.executeQuery("SELECT * FROM game");

        while (result.next()) {
            games.add(new Game(result.getString("type"), result.getDouble("price"), result.getString("title"),
                    result.getString("rating")));
        }

        return games;
    }

    /**
     * Loads board games
     * 
     * @param connection
     * @return list of product
     * @throws SQLException
     */
    public static List<Product> loadBoardGames(Connection connection) throws SQLException {
        List<Product> boardGames = new ArrayList<Product>();
        Statement getBoardGames = connection.createStatement();
        ResultSet result = getBoardGames.executeQuery("SELECT * FROM board_game");

        while (result.next()) {
            boardGames.add(new BoardGame(result.getString("type"), result.getDouble("price"), result.getString("title"),
                    result.getString("rating"), result.getInt("pieces")));
        }

        return boardGames;
    }

    /**
     * loads video game disks
     * 
     * @param connection
     * @return list of product
     * @throws SQLException
     */
    public static List<Product> loadVideoGameDisks(Connection connection) throws SQLException {
        List<Product> diskGames = new ArrayList<Product>();
        Statement getDiskGames = connection.createStatement();
        ResultSet result = getDiskGames.executeQuery("SELECT * FROM video_game_disk");

        while (result.next()) {
            diskGames.add(new DiskGame(result.getString("type"), result.getDouble("price"), result.getString("title"),
                    result.getString("rating"),
                    result.getString("platform"), result.getString("publisher")));
        }

        return diskGames;
    }

    /**
     * loads video game digital copies
     * 
     * @param connection
     * @return list of product
     * @throws SQLException
     */
    public static List<Product> loadVideoGameDigitalCopies(Connection connection) throws SQLException {
        List<Product> diskGames = new ArrayList<Product>();
        Statement getDiskGames = connection.createStatement();
        ResultSet result = getDiskGames.executeQuery("SELECT * FROM video_game_digital");

        while (result.next()) {
            diskGames
                    .add(new DigitalCopy(result.getString("type"), result.getDouble("price"), result.getString("title"),
                            result.getString("rating"), result.getString("platform"), result.getDouble("game_size")));
        }

        return diskGames;
    }

    /**
     * Loads all consoles
     * 
     * @param connection
     * @return list of product
     * @throws SQLException
     */
    public static List<Product> loadConsoles(Connection connection) throws SQLException {
        List<Product> consoles = new ArrayList<Product>();
        Statement getConsoles = connection.createStatement();
        ResultSet result = getConsoles.executeQuery("SELECT * FROM console");

        while (result.next()) {
            consoles.add(
                    new Console(result.getString("type"), result.getDouble("price"), result.getString("deviceName")));
        }

        return consoles;
    }

    /**
     * Loads Computers
     * 
     * @param connection
     * @return list of product
     * @throws SQLException
     */
    public static List<Product> loadComputers(Connection connection) throws SQLException {
        List<Product> computers = new ArrayList<Product>();
        Statement getComputers = connection.createStatement();
        ResultSet result = getComputers.executeQuery("SELECT * FROM computer");

        while (result.next()) {
            computers.add(new PC(result.getString("type"), result.getDouble("price"), result.getString("deviceName"),
                    result.getDouble("storage"),
                    result.getInt("ram")));
        }

        return computers;
    }

}
