package br.com.claro.utils;

public class ScenarioDetails {
    private String cenario;
    private int linha;

    public ScenarioDetails(String cenario, int linha) {
        this.cenario = cenario;
        this.linha = linha;
    }

    public String getcenario() {
        return cenario;
    }

    public int getlinha() {
        return linha;
    }

    @Override
    public String toString() {
        return "Feature: (" +
                "cenario = '" + cenario + '\'' +
                ", linha = " + linha +
                ')';
    }
}
