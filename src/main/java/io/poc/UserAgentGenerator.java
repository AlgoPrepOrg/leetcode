package io.poc;

import java.security.SecureRandom;

public class UserAgentGenerator {
  private static final String[] BROWSERS = {"Chrome", "Firefox", "Safari", "Edge", "Opera"};
  private static final String[] WEBKIT_VERSIONS = {"537.36", "537.35", "537.34", "537.33", "537.32"};
  private static final String[] PLATFORMS = {
      "Windows NT 10.0", "Windows NT 6.1", "Macintosh; Intel Mac OS X 10_15_7",
      "X11; Linux x86_64", "iPhone; CPU iPhone OS 14_0 like Mac OS X", "iPad; CPU OS 14_0 like Mac OS X"
  };

  private static final SecureRandom RANDOM = new SecureRandom();

  public static String generateUserAgent() {
    String browser = BROWSERS[RANDOM.nextInt(BROWSERS.length)];
    String platform = PLATFORMS[RANDOM.nextInt(PLATFORMS.length)];
    String webkitVersion = WEBKIT_VERSIONS[RANDOM.nextInt(WEBKIT_VERSIONS.length)];

    return switch (browser) {
      case "Chrome" -> {
        String chromeVersion = RANDOM.nextInt(31) + 80 + ".0." + (RANDOM.nextInt(1001) + 4000) + "." +
            (RANDOM.nextInt(401) + 100);
        yield String.format("Mozilla/5.0 (%s) AppleWebKit/%s (KHTML, like Gecko) Chrome/%s Safari/%s",
            platform, webkitVersion, chromeVersion, webkitVersion);
      }
      case "Firefox" -> {
        String firefoxVersion = RANDOM.nextInt(31) + 70 + ".0";
        yield String.format("Mozilla/5.0 (%s; rv:%s) Gecko/20100101 Firefox/%s",
            platform, firefoxVersion, firefoxVersion);
      }
      case "Safari" -> {
        String safariVersion = (RANDOM.nextInt(101) + 600) + "." + (RANDOM.nextInt(50) + 1) + "." +
            (RANDOM.nextInt(10) + 1);
        yield String.format("Mozilla/5.0 (%s) AppleWebKit/%s (KHTML, like Gecko) Version/%s Safari/%s",
            platform, webkitVersion, safariVersion, webkitVersion);
      }
      case "Edge" -> {
        String edgeVersion = (RANDOM.nextInt(31) + 80) + ".0." + (RANDOM.nextInt(301) + 600) + "."
            + (RANDOM.nextInt(91) + 10);
        yield String.format("Mozilla/5.0 (%s) AppleWebKit/%s (KHTML, like Gecko) Chrome/%s Safari/%s Edg/%s",
            platform, webkitVersion, edgeVersion, webkitVersion, edgeVersion);
      }
      case "Opera" -> {
        String operaVersion = (RANDOM.nextInt(31) + 70) + ".0." + (RANDOM.nextInt(2001) + 3000) + "." +
            (RANDOM.nextInt(401) + 100);
        yield String.format("Mozilla/5.0 (%s) AppleWebKit/%s (KHTML, like Gecko) Chrome/%s Safari/%s OPR/%s",
            platform, webkitVersion, operaVersion, webkitVersion, operaVersion);
      }
      default -> "Mozilla/5.0";
    };
  }

  public static void main(String[] args) {
    for (int i = 0; i < 1000; i++) {
      System.out.println(generateUserAgent());
    }
  }
}

