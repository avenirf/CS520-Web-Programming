package csjobs.model.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import csjobs.model.User;
import csjobs.model.dao.UserDao;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @PostAuthorize ("hasRole('ROLE_ADMIN') or hasRole('ROLE_REVIEWER') or principal.username == returnObject.username")
    public User getUser( Long id )
    {
        return entityManager.find( User.class, id );
    }

    @Override
    public List<User> getUsers()
    {
        return entityManager.createQuery( "from User order by id", User.class )
            .getResultList();
    }

	@Override
	@PostAuthorize ("hasRole('ROLE_ADMIN') or hasRole('ROLE_REVIEWER') or principal.username == returnObject.username")
	public User getUserByEmail( String username ) 
	{
        String query = "from User where lower(username) = :username";

        List<User> users = entityManager.createQuery( query, User.class )
            .setParameter( "username", username.toLowerCase() )
            .getResultList();
        return users.size() == 0 ? null : users.get( 0 );
	}

	@Override
	@Transactional
	@PreAuthorize ("principal.username == #user.username")
	public User saveUser( User user ) {
		return entityManager.merge( user );
	}
	
	@Override
	public List<User> getReviewers() {
        
        String query = "from User user left join fetch user.authority "
        		+ "where authority = :role";

            return entityManager.createQuery( query, User.class )
                .setParameter( "role", "ROLE_REVIEWER" )
                .getResultList();
	}

}