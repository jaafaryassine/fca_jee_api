package stats;

import java.net.MalformedURLException;
import java.sql.SQLException;

public interface ILeague {
    public StringBuffer getStats(String league_name) throws Exception;
}
