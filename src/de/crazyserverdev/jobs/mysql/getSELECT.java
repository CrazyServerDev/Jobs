package de.crazyserverdev.jobs.mysql;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class getSELECT {
  public static List<String> arrayspieler = new ArrayList<>();
  
  public static List<String> arraybewerbung = new ArrayList<>();
  
  public static String alleMitarbeiterUuidAuslesen(String firmaname) {
    ResultSet rs = getResult("SELECT * FROM " + getMYSQL.tableplayer + " WHERE firma='" + firmaname + "'");
    try {
      while (rs.next()) {
        String uuid = rs.getString("uuid");
        arrayspieler.add(uuid);
      } 
    } catch (SQLException e) {
      e.printStackTrace();
    } 
    return null;
  }
  
  public static String AllBewerbungFromFirma(String firmaname) {
    ResultSet rs = getResult("SELECT * FROM " + getMYSQL.tablebewerbung + " WHERE firma_name='" + firmaname + "'");
    try {
      while (rs.next()) {
        String uuid = rs.getString("uuid");
        arraybewerbung.add(uuid);
      } 
    } catch (SQLException e) {
      e.printStackTrace();
    } 
    return null;
  }
  
  public static String getFirmaOwner(String firmaname) {
    ResultSet rs = getResult("SELECT * FROM " + getMYSQL.tablefirma + " WHERE firma='" + firmaname + "'");
    try {
      if (rs.next())
        return rs.getString("besitzeruuid"); 
    } catch (SQLException e) {
      e.printStackTrace();
    } 
    return null;
  }
  
  public static String getFirmaArt(String firmaname) {
    ResultSet rs = getResult("SELECT * FROM " + getMYSQL.tablefirma + " WHERE firma='" + firmaname + "'");
    try {
      if (rs.next())
        return rs.getString("firma_art"); 
    } catch (SQLException e) {
      e.printStackTrace();
    } 
    return null;
  }
  
  public static String getPlayerRank(String uuid) {
    ResultSet rs = getResult("SELECT * FROM " + getMYSQL.tableplayer + " WHERE uuid='" + uuid + "'");
    try {
      if (rs.next())
        return rs.getString("rank"); 
    } catch (SQLException e) {
      e.printStackTrace();
    } 
    return null;
  }
  
  public static int getFirmaLohn(String firmaname) {
    ResultSet rs = getResult("SELECT * FROM " + getMYSQL.tablefirma + " WHERE firma='" + firmaname + "'");
    try {
      if (rs.next())
        return rs.getInt("lohn"); 
    } catch (SQLException e) {
      e.printStackTrace();
    } 
    return (Integer) null;
  }
  
  public static double getFirmaEinnahmen(String firmaname) {
    ResultSet rs = getResult("SELECT * FROM " + getMYSQL.tablefirma + " WHERE firma='" + firmaname + "'");
    try {
      if (rs.next())
        return rs.getDouble("einnahmen"); 
    } catch (SQLException e) {
      e.printStackTrace();
    } 
    return (Double) null;
  }
  
  public static double getPlayerEinnahmen(String uuid) {
    ResultSet rs = getResult("SELECT * FROM " + getMYSQL.tableplayer + " WHERE uuid='" + uuid + "'");
    try {
      if (rs.next())
        return rs.getDouble("einnahmen"); 
    } catch (SQLException e) {
      e.printStackTrace();
    } 
    return (Double) null;
  }
  
  public static boolean HavePlayerAccount(String uuid) {
    ResultSet rs = getResult("SELECT * FROM " + getMYSQL.tableplayer + " WHERE uuid='" + uuid + "'");
    try {
      if (rs.next())
        return true; 
    } catch (SQLException e) {
      e.printStackTrace();
    } 
    return false;
  }
  
  public static boolean ExistFirmaName(String firmaname) {
    ResultSet rs = getResult("SELECT * FROM " + getMYSQL.tablefirma + " WHERE firma='" + firmaname + "'");
    try {
      if (rs.next())
        return true; 
    } catch (SQLException e) {
      e.printStackTrace();
    } 
    return false;
  }
  
  public static boolean ExistBewerbungByFirmaFromUuid(String firmaname, String uuid) {
    ResultSet rs = getResult("SELECT * FROM " + getMYSQL.tablebewerbung + " WHERE firma_name='" + firmaname + "' AND uuid='" + uuid + "'");
    try {
      if (rs.next())
        return true; 
    } catch (SQLException e) {
      e.printStackTrace();
    } 
    return false;
  }
  
  public static boolean ExistBewerbungByFirma(String firmaname) {
    ResultSet rs = getResult("SELECT * FROM " + getMYSQL.tablebewerbung + " WHERE firma_name='" + firmaname + "'");
    try {
      if (rs.next())
        return true; 
    } catch (SQLException e) {
      e.printStackTrace();
    } 
    return false;
  }
  
  public static boolean IsOwnerByFirma(String firmaname, String uuid) {
    ResultSet rs = getResult("SELECT * FROM " + getMYSQL.tablefirma + " WHERE firma='" + firmaname + "' AND uuid='" + uuid + "'");
    try {
      if (rs.next())
        return true; 
    } catch (SQLException e) {
      e.printStackTrace();
    } 
    return false;
  }
  
  public static String getPlayerFirmaName(String uuid) {
    ResultSet rs = getResult("SELECT * FROM " + getMYSQL.tableplayer + " WHERE uuid='" + uuid + "'");
    try {
      if (rs.next())
        return rs.getString("firma"); 
    } catch (SQLException e) {
      e.printStackTrace();
    } 
    return null;
  }
  
  public static ResultSet getResult(String qry) {
    if (getMYSQL.isConnected())
      try {
        return getMYSQL.con.createStatement().executeQuery(qry);
      } catch (SQLException e) {
        e.printStackTrace();
      }  
    return null;
  }
}


/* Location:              C:\Users\CrazyServerDev\Downloads\Firma(2).jar!\firma\webjap\de\servergoogle\mysql\SELECT.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */