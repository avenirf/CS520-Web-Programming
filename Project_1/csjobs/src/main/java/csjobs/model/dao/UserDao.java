package csjobs.model.dao;

import java.util.List;

import csjobs.model.User;

public interface UserDao {

    User getUser( Long id );
    
    User getUserByEmail( String username );

    List<User> getUsers();
    
    User saveUser( User user );

	List<User> getReviewers();

}