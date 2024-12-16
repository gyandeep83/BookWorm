package com.bookstore.models;

public class Book {
    private int id;
    private String name;
    private String isbn;
    private String author;
    private double price;
    private int quantity; // New field for quantity

    // Default constructor
    public Book() {
    }

    // Parameterized constructor
    public Book(int id, String name, String isbn, String author, double price, int quantity) {
        this.id = id;
        this.name = name;
        this.isbn = isbn;
        this.author = author;
        this.price = price;
        this.quantity = quantity;  // Set quantity
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;  // Getter for quantity
    }

    public void setQuantity(int quantity) {  // Setter for quantity
        this.quantity = quantity;
    }
}
