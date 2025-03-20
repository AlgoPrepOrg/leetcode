package io.algopreorg.alog.simplifyPath;

import java.util.Stack;

public class Solution {

  private static final String SEPARATOR = "/";

  public static String simplifyPath(String path) {
    String[] parts = path.split(SEPARATOR);
    Stack<String> stack = new Stack<>();

    for (var part : parts) {
      if (part.isEmpty() || part.equals(".")) {
        continue;
      } else if (part.equals("..")) {
        if (!stack.isEmpty()) {
          stack.pop();
        }
      } else {
        stack.push(part);
      }
    }

    var simplifiedPath = new StringBuilder();
    for (var dir : stack) {
      simplifiedPath.append(SEPARATOR).append(dir);
    }

    return !simplifiedPath.isEmpty() ? simplifiedPath.toString() : SEPARATOR;
  }

  public static void main(String[] args) {
    // Test cases
    String path1 = "/home/";
    String path2 = "/../";
    String path3 = "/home//foo/";
    String path4 = "/a/./b/../../c/";
    String path5 = "/a/../../b/../c//.//";
    String path6 = "/a//b////c/d//././/..";

    System.out.println(simplifyPath(path1)); // Output: "/home"
    System.out.println(simplifyPath(path2)); // Output: "/"
    System.out.println(simplifyPath(path3)); // Output: "/home/foo"
    System.out.println(simplifyPath(path4)); // Output: "/c"
    System.out.println(simplifyPath(path5)); // Output: "/c"
    System.out.println(simplifyPath(path6)); // Output: "/a/b/c"
  }
}
