package csjobs.model.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import csjobs.model.Application;
import csjobs.model.FileS;
import csjobs.model.dao.FileDao;

@Repository
public class FileDaoImpl implements FileDao{
	
	   @PersistenceContext
	    private EntityManager entityManager;

	    @Override
	    public FileS getFile( Long id )
	    {
	        return entityManager.find( FileS.class, id );
	    }

	    @Override
	    public List<FileS> getFiles()
	    {
	        return entityManager.createQuery( "from File order by id", FileS.class )
	            .getResultList();
	    }
	    
		@Override
		@Transactional
		public FileS saveFile(FileS file) {
			return entityManager.merge( file );
		}
}
