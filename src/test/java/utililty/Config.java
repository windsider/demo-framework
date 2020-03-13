package utililty;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Config {
  private static InputStream input;
  private static final Properties prop = new Properties();

  public static String get(String key) {
    try {
      input = new BufferedInputStream(new FileInputStream("src/test/resources/config.properties"));
      prop.load(input);
    } catch (IOException e) {
      System.err.println("Caught IOException: " + e.getMessage());
    }
    return prop.getProperty(key);
  }
}
