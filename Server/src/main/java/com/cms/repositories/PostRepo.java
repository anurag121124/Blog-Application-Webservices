package com.cms.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cms.entities.Category;
import com.cms.entities.Post;
import com.cms.entities.User;

public interface PostRepo extends JpaRepository<Post, Integer> {
	
	// custome jpa method to get user wise posts
	List<Post> findByUser(User user);
	
	// custome jpa method to get categorywise posts
	List<Post> findByCategory(Category category);
//	List<Post> findByCategory(Pageable pageable);
	
	// custom jpa method to search string in title of post
	List<Post> findByTitleContaining(String title);
	
	// alternative for searching
	@Query("select p from Post p where p.title like :key")
	List<Post> searchByTitle(@Param("key") String title);

}
