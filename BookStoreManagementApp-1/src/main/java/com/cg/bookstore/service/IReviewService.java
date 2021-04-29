package com.cg.bookstore.service;

import java.util.List;

import com.cg.bookstore.entities.Book;
import com.cg.bookstore.entities.Review;
import com.cg.bookstore.exceptions.ReviewExcpetion;

public interface IReviewService {

	public List<Review> listAllReviews() throws ReviewExcpetion;
	public Review addReview(Review review) throws ReviewExcpetion;
	public void deleteReview(int reviewId) throws ReviewExcpetion;
	public Review updateReview(Review review) throws ReviewExcpetion;
	public Review viewReview(int reviewId) throws ReviewExcpetion;
	public List<Review> listAllReviewsByBook(String title) throws ReviewExcpetion;
	public List<Review> listAllReviewsByCustomer(String title) throws ReviewExcpetion;
	public List<Book> listMostFavoredBooks() throws ReviewExcpetion;
}
