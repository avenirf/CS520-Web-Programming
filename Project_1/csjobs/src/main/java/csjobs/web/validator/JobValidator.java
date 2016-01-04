package csjobs.web.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import csjobs.model.Job;
import csjobs.model.dao.JobDao;

@Component
public class JobValidator implements Validator {

    @Autowired
    private JobDao jobDao;

    @Override
    public boolean supports( Class<?> clazz )
    {
        return Job.class.isAssignableFrom( clazz );
    }

    @Override
    public void validate( Object target, Errors errors )
    {
        ValidationUtils.rejectIfEmptyOrWhitespace( errors, "title",
            "error.field.empty" );
        
        Job job = (Job) target;
              
        if( StringUtils.isEmpty( job.getClose_date() ) )
            job.setClose_date( null );
        
        if( StringUtils.isEmpty( job.getPublish_date() ) )
            job.setPublish_date( null );
       // Date publishDate = job.getPublishDate();
        //if( publishDate )
        //    errors.rejectValue( "publishDate", "error.date.submition" );
        
       // Date closeDate = job.getCloseDate();
       // if( closeDate )
        //    errors.rejectValue( "password2", "error.password.nomatch" );
    }

}
