package csjobs.model.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import csjobs.model.dao.ApplicationDao;
import csjobs.model.Application;
import csjobs.model.Job;
import csjobs.model.User;

@Repository
public class ApplicationDaoInfo implements ApplicationDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @PostAuthorize ("hasRole('ROLE_ADMIN') or hasRole('ROLE_REVIEWER') or principal.username == returnObject.applicant.username")
    public Application getApplication( Long id )
    {
        return entityManager.find( Application.class, id );
    }

    @Override
    public List<Application> getApplications()
    {
        return entityManager.createQuery( "from Application order by id", Application.class )
            .getResultList();
    }

	@Override
	@Transactional
	@PreAuthorize ("hasRole('ROLE_ADMIN') or principal.username == #app.applicant.username")
	public Application saveApplication(Application app) {
		return entityManager.merge( app );
	}
	
    @Override
    @PostAuthorize ("hasRole('ROLE_ADMIN') or hasRole('ROLE_REVIEWER') or principal.username == returnObject.applicant.username")
    public Application getApplication( Job job, User applicant )
    {
        String query = "from Application where job = :job and applicant = :applicant";

        List<Application> results = entityManager
            .createQuery( query, Application.class )
            .setParameter( "job", job )
            .setParameter( "applicant", applicant )
            .getResultList();
        return results.size() == 0 ? null : results.get( 0 );
    }
    
    @Override
    @PostAuthorize ("hasRole('ROLE_ADMIN') or hasRole('ROLE_REVIEWER') or principal.username == returnObject.applicant.username")
    public List<Application> getApplicationByJob( Job job )
    {
        String query = "from Application where job = :job";

        return entityManager
            .createQuery( query, Application.class )
            .setParameter( "job", job )
            .getResultList();
    }
}
