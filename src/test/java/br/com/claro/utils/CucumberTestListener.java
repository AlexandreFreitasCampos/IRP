package br.com.claro.utils;

import io.cucumber.plugin.EventListener;
import io.cucumber.plugin.event.EventPublisher;
import io.cucumber.plugin.event.TestStepFinished;
import io.cucumber.plugin.event.Status;

public class CucumberTestListener implements EventListener {

    @Override
    public void setEventPublisher(EventPublisher publisher) {
        publisher.registerHandlerFor(TestStepFinished.class, this::handleTestStepFinished);
    }

    private void handleTestStepFinished(TestStepFinished event) {
        if (event.getResult().getStatus() == Status.FAILED) {
            Throwable error = event.getResult().getError();
            if (error instanceof CustomTestException) {
                CustomTestException customError = (CustomTestException) error;
                System.out.println(customError.toString());
            } else if (error != null) {
                StackTraceElement[] stackTrace = error.getStackTrace();
                for (StackTraceElement element : stackTrace) {
                    if (element.getClassName().startsWith("br.com.claro.pages.pageActions")) {
                        String methodName = element.getMethodName();
                        int lineNumber = element.getLineNumber();
                        System.out.println("Falha no método: " + methodName + " linha: " + lineNumber);
                        break;
                    }
                }
            }
        }
    }
}