package com.bookstore.models;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<Book> books;

    public Cart() {
        books = new ArrayList<>();
    }

    // Method to add a book to the cart
    public void addBook(Book book, int quantity) {
        boolean bookExists = false;
        
        // Check if the book is already in the cart
        for (Book b : books) {
            if (b.getId() == book.getId()) {  // Correct usage of getId()
                // If book exists, update the quantity
                b.setQuantity(b.getQuantity() + quantity);  // Correct usage of setQuantity()
                bookExists = true;
                break;
            }
        }

        // If the book is not already in the cart, add a new book with the quantity
        if (!bookExists) {
            book.setQuantity(quantity);  // Set the quantity for the new book
            books.add(book);  // Use add() for adding a single book
        }
    }

    // Method to get the list of books in the cart
    public List<Book> getBooks() {
        return books;
    }

    // Method to get the total number of items in the cart
    public int getTotalItems() {
        int total = 0;
        for (Book b : books) {
            total += b.getQuantity();
        }
        return total;
    }

    // Method to clear the cart
    public void clearCart() {
        books.clear();
    }
}
