package csjobs.model.dao;

import java.util.List;
import csjobs.model.FileS;

public interface FileDao {
	
	FileS getFile( Long id );
	
	List<FileS> getFiles();

	FileS saveFile(FileS file);
}
