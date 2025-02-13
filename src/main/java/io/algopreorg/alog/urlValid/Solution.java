package io.algopreorg.alog.urlValid;

import java.net.URI;
import java.net.URISyntaxException;

public class Solution {

  public static boolean isValidUrl(String url) {
    try {
      var uri = new URI(url);
      var host = uri.getHost();
      return host != null && host.contains(".") &&  uri.getScheme() != null;
    } catch (URISyntaxException e) {
      return false;
    }
  }

  public static void main(String[] args) {
    System.out.println(isValidUrl("https://justAword"));
    System.out.println(isValidUrl("https://justAword.com"));
    System.out.println(isValidUrl("https://justAword.com"));
  }
}
