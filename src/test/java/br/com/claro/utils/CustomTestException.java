package br.com.claro.utils;

public class CustomTestException extends RuntimeException {
    private String methodName;
    private int lineNumber;

    public CustomTestException(String message, Throwable cause) {
        super(message, cause);
        StackTraceElement[] stackTrace = cause.getStackTrace();
        boolean found = false;
        for (StackTraceElement element : stackTrace) {
            if (element.getClassName().startsWith("br.com.claro.pages.pageActions")) {
                this.methodName = element.getMethodName();
                this.lineNumber = element.getLineNumber();
                found = true;
                break;
            }
        }
        // Fallback if no element was found
        if (!found && stackTrace.length > 0) {
            this.methodName = stackTrace[0].getMethodName();
            this.lineNumber = stackTrace[0].getLineNumber();
        }
    }

    public String getMethodName() {
        return methodName;
    }

    public int getLineNumber() {
        return lineNumber;
    }

    @Override
    public String toString() {
        return super.toString() + " no método: " + methodName + " linha: " + lineNumber;
    }
}