package csjobs.model.dao.jpa;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import csjobs.model.Job;
import csjobs.model.dao.JobDao;

@Repository
public class JobDaoImpl implements JobDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Job getJob( Long id )
    {
        return entityManager.find( Job.class, id );
    }

    @Override
    public List<Job> getJobs()
    {
        return entityManager
            .createQuery( "from Job order by id asc", Job.class )
            .getResultList();
    }
    
    @Override
    public List<Job> getJobsByDate()
    {
        return entityManager
            .createQuery( "from Job order by publish_date DESC", Job.class )
            .getResultList();
    }

    @Override
    public List<Job> getOpenJobs()
    {
        String query = "from Job where publish_date < :now "
            + "and (close_date is null or close_date > :now) "
            + "order by publish_date asc";

        return entityManager.createQuery( query, Job.class )
            .setParameter( "now", new Date() )
            .getResultList();
    }

    @Override
    @Transactional
    @PreAuthorize ("hasRole('ROLE_ADMIN')")
    public Job saveJob( Job job )
    {
        return entityManager.merge( job );
    }

}
