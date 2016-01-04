package csjobs.web.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import csjobs.model.Application;
import csjobs.model.dao.ApplicationDao;

@Component
public class ApplicationValidator implements Validator {

    @Autowired
    ApplicationDao applicationDao;
	
    @Override
    public boolean supports( Class<?> claz )
    {
        // clazz is User.class or a subclass of User
        return Application.class.isAssignableFrom( claz );
    }

    @Override
    public void validate( Object target, Errors errors )
    {
        Application app = (Application) target;
        //Long id = app.getId();

        if( !StringUtils.hasText( app.getCompany() ) )
            errors.rejectValue( "company", "error.field.empty" );

        if( !StringUtils.hasText( app.getTitle() ) )
            errors.rejectValue( "title", "error.field.empty" );
        
        if( StringUtils.isEmpty( app.getStart_year()) )
            errors.rejectValue( "start_year", "error.field.empty" );
        
        if( !StringUtils.isEmpty( app.getStart_year()) )
        	
        	if( app.getStart_year() <= 0 )
        		errors.rejectValue( "start_year", "error.wrong.integer" );
    }    

}
