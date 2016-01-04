package csjobs.web.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import csjobs.model.User;
import csjobs.model.dao.UserDao;

@Component
public class UserValidator implements Validator {

    @Autowired
    UserDao userDao;
	
    @Override
    public boolean supports( Class<?> clazz )
    {
        // clazz is User.class or a subclass of User
        return User.class.isAssignableFrom( clazz );
    }

    @Override
    public void validate( Object target, Errors errors )
    {
        User user = (User) target;
        Long id = user.getId();

        if( !StringUtils.hasText( user.getUsername() ) )
            errors.rejectValue( "email", "error.field.empty" );

        if( !StringUtils.hasText( user.getPassword() ) )
            errors.rejectValue( "password", "error.field.empty" );
        
        if( !StringUtils.hasText( user.getFirstName() ) )
            errors.rejectValue( "firstName", "error.field.empty" );

        if( !StringUtils.hasText( user.getLastName() ) )
            errors.rejectValue( "lastName", "error.field.empty" );
        
        if( !StringUtils.hasText( user.getPhone() ) )
            errors.rejectValue( "phone", "error.field.empty" );

        if( !StringUtils.hasText( user.getAddress() ) )
            errors.rejectValue( "address", "error.field.empty" );
        
        String email = user.getUsername();
        if( StringUtils.hasText( email ) )
        {
            User u = userDao.getUserByEmail( email );
            if( u != null && !u.getId().equals( id ) )
                errors.rejectValue( "email", "error.user.email.taken" );
        }
    }
    
    public void login( Object target, Errors errors )
    {
    	User user = (User) target;
        //Long id = user.getId();
        
        if( !StringUtils.hasText( user.getUsername() ) )
            errors.rejectValue( "email", "error.field.empty" );

        if( !StringUtils.hasText( user.getPassword() ) )
            errors.rejectValue( "password", "error.field.empty" );
        
        String password = user.getPassword();
        String email = user.getUsername();
        
        if( StringUtils.hasText( email ) )
        {
            User u = userDao.getUserByEmail( email );
            if( u == null )
                errors.rejectValue( "email", "error.user.wrong.email" );
        }
        
        if( StringUtils.hasText( password ) )
        {
            User u = userDao.getUserByEmail( email );
            if( u != null && !u.getPassword().equals(password) )
                errors.rejectValue( "password", "error.user.wrong.password" );
        }
    }
    

}
