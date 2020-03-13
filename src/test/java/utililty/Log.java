package utililty;

import org.apache.log4j.Logger;

public class Log {
  private static Logger log = Logger.getLogger((Log.class.getName()));

  public static void getInfoLog(String message) {
    log.info(message);
  }

  public static void getErrorLog(String message) {
    log.error(message);
  }

  public static void getFatalLog(String message) {
    log.fatal(message);
  }

  public static void getDebugLog(String message) {
    log.debug(message);
  }
}
