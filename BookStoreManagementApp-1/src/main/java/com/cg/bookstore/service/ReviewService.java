package com.cg.bookstore.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.bookstore.entities.Book;
import com.cg.bookstore.entities.Customer;
import com.cg.bookstore.entities.Review;
import com.cg.bookstore.exceptions.ReviewExcpetion;
import com.cg.bookstore.repository.IBookRepository;
import com.cg.bookstore.repository.ICustomerRepository;
import com.cg.bookstore.repository.IReviewRepository;

@Service
@Transactional
public class ReviewService implements IReviewService{

	@Autowired
	IReviewRepository repository;
	
	@Autowired
	IBookRepository bookRepository;
	
	@Autowired
	ICustomerRepository customerRepository;
	
	@Override
	public List<Review> listAllReviews() throws ReviewExcpetion {
		List<Review> reviewList = repository.findAll();
		if(reviewList.isEmpty())
			throw new ReviewExcpetion("No data found");
		else
			return reviewList;
	}

	@Override
	public Review addReview(Review review) throws ReviewExcpetion {
		if(repository.existsByReviewId(review.getReviewId()))
			throw new ReviewExcpetion("Review already exists");
		else {
			Review reviewData = repository.save(review);
			return reviewData;
		}
	}

	@Override
	public void deleteReview(int reviewId) throws ReviewExcpetion {
		if(repository.existsByReviewId(reviewId))
			repository.deleteById(reviewId);
		else 
			throw new ReviewExcpetion("Review not found");
	}

	@Override
	public Review updateReview(Review review) throws ReviewExcpetion {
		if(repository.existsByReviewId(review.getReviewId())) {
			Review reviewData = repository.save(review);
			return reviewData;
		}
		else
			throw new ReviewExcpetion("Review not found");
	}

	@Override
	public Review viewReview(int reviewId) throws ReviewExcpetion {
		if(repository.existsByReviewId(reviewId)) {
			Review reviewData = repository.findByReviewId(reviewId);
			return reviewData;
		}
		else
			throw new ReviewExcpetion("Review not found");
	}

	@Override
	public List<Review> listAllReviewsByBook(String title) throws ReviewExcpetion {
		if(bookRepository.existsByTitle(title)) {
			Book book = bookRepository.findByTitle(title);
			List<Review> reviewList = repository.findByBook(book);
			return reviewList;
		}
		else
			throw new ReviewExcpetion("Review not found");
	}

	@Override
	public List<Review> listAllReviewsByCustomer(String fullName) throws ReviewExcpetion {
		if(customerRepository.existsByFullName(fullName)) {
			Customer customerData = customerRepository.findByFullName(fullName);
			List<Review> reviewList = repository.findByCustomer(customerData);
			return reviewList;
		}
		else
			throw new ReviewExcpetion("Review not found");
	}

	@Override
	public List<Book> listMostFavoredBooks() throws ReviewExcpetion {
		// TODO Auto-generated method stub
		return null;
	}

}
