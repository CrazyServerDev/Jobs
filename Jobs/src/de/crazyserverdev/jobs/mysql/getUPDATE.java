package de.crazyserverdev.jobs.mysql;

import java.sql.SQLException;

public class getUPDATE {
  public static void update(String qry) {
    if (getMYSQL.isConnected())
      try {
        getMYSQL.con.createStatement().executeUpdate(qry);
      } catch (SQLException e) {
        e.printStackTrace();
      }  
  }
}


/* Location:              C:\Users\CrazyServerDev\Downloads\Firma(2).jar!\firma\webjap\de\servergoogle\mysql\UPDATE.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */