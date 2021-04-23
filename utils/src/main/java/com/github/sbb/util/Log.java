package com.github.sbb.util;

import com.google.common.base.Strings;

public class Log {

  public static void info(String msg) {
    StackTraceElement element = Thread.currentThread().getStackTrace()[2];
    String className = element.getClassName();
    String methodName = element.getMethodName();
    int lineNumber = element.getLineNumber();
    System.out.println(Strings.lenientFormat("%s.%s#%s: %s", className, methodName, lineNumber, msg));
  }

  public static void error(String msg) {

  }
}
