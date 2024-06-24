package br.com.claro.utils;

import br.com.claro.pages.pageActions.RelatoriosPersonalizadosPA;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

import java.util.ArrayList;
import java.util.List;


public class Hooks {
    private static List<ScenarioDetails> scenarioDetailsList = new ArrayList<>();

    @Before
    public void beforeScenario(Scenario scenario) {
        String scenarioName = scenario.getName();
        int scenarioLine = scenario.getLine();
        ScenarioDetails details = new ScenarioDetails(scenarioName, scenarioLine);
        scenarioDetailsList.add(details);
    }

    public static List<ScenarioDetails> getScenarioDetailsList() {
        return scenarioDetailsList;
    }
}
