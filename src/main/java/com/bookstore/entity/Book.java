package com.bookstore.entity;

public class Book {
	private int id;
 

	private String category;
    private String title;
    private String author;
    private String ISBN;
    private String publisher;
    private String editionNumber;
    private double price;

    public Book() {

        // TODO Auto-generated constructor stub
    }

    public Book(String category, String title, String author, String iSBN, String publisher, String editionNumber, double price) {
        this.category = category;
        this.title = title;
        this.author = author;
        this.ISBN = iSBN;
        this.publisher = publisher;
        this.editionNumber = editionNumber;
        this.price = price;
    }


    public Book(int id, String category, String title, String author, String iSBN, String publisher,
			String editionNumber, double price) {
		super();
		this.id = id;
		this.category = category;
		this.title = title;
		this.author = author;
		ISBN = iSBN;
		this.publisher = publisher;
		this.editionNumber = editionNumber;
		this.price = price;
	}
    public int getId() {
 		return id;
 	}

 	public void setId(int id) {
 		this.id = id;
 	}

	public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String iSBN) {
        ISBN = iSBN;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getEditionNumber() {
        return editionNumber;
    }

    public void setEditionNumber(String editionNumber) {
        this.editionNumber = editionNumber;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price =price;
    }

    @Override
    public String toString() {
        return "|category=" + category + ", title=" + title + ", author=" + author + ", ISBN=" + ISBN
                + ", publisher=" + publisher + ", editionNumber=" + editionNumber + ", price=" + price + "|";
    }


}
