package stats;

import models.DB;

import java.net.MalformedURLException;
import java.sql.SQLException;

public class LeagueProxy implements ILeague{
    public League league;
    public String user_id;

    public LeagueProxy(String user_id) {
        this.user_id = user_id;
    }

    @Override
    public StringBuffer getStats(String league_name) throws Exception {
        DB db = new DB();
        if (db.getUserStatus(this.user_id).equals("premium")) {
            this.league = new League();
            return this.league.getStats(league_name);
        }
        throw new Exception("The account is not premium");
    }
}
