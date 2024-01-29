package br.com.claro.irp.pages.pageActions;

import br.com.claro.irp.pages.pageObjects.RelatoriosPO;
import br.com.claro.irp.utils.acoesWeb;
import br.com.claro.irp.utils.DriverFactory;
import br.com.claro.irp.utils.PDF;

import static br.com.claro.irp.utils.PDF.*;

public class RelatoriosPersonalizadosPA extends DriverFactory {
    acoesWeb acaoWeb = new acoesWeb();
    RelatoriosPO acaoRelatorios = new RelatoriosPO();

    private boolean fim = false;
    private static String conta;

    public void criarArquvioPDF(String string) {
        try {
            switch (string) {
                case "relatorio_personalizado_claro_musica_gra_edit":
                case "relatorio_personalizado_claro_musica_gravadora":
                case "relatorio_personalizado_claro_musica_editora":
                    criaDocumento(string);
                    insereCaBecalho();
                    escreveTitulo("Gerar relatório personalizado 'Claro Música'");
                    PDF.escreveSubTitulo("Precondição:\nEstar logado na página de Relatórios");
                    break;
                case "relatorio_personalizado_rbt_gra_edit":
                case "relatorio_personalizado_rbt_gravadora":
                case "relatorio_personalizado_rbt_editora":
                    criaDocumento(string);
                    insereCaBecalho();
                    escreveTitulo("Gerar relatório personalizado 'RBT'");
                    PDF.escreveSubTitulo("Precondição:\nEstar logado na página de Relatórios");
                    break;
                case "relatorio_personalizado_ott_unificado_gra_edit":
                case "relatorio_personalizado_ott_unificado_gravadora":
                case "relatorio_personalizado_ott_unificado_editora":
                    criaDocumento(string);
                    insereCaBecalho();
                    escreveTitulo("Gerar relatório personalizado 'OTT Unificado'");
                    PDF.escreveSubTitulo("Precondição:\nEstar logado na página de Relatórios");
                    break;
                case "relatorio_personalizado_ott_gra_edit":
                case "relatorio_personalizado_ott_gravadora":
                case "relatorio_personalizado_ott_editora":
                    criaDocumento(string);
                    insereCaBecalho();
                    escreveTitulo("Gerar relatório personalizado 'OTT'");
                    PDF.escreveSubTitulo("Precondição:\nEstar logado na página de Relatórios");
                    break;
            }
        } catch (Exception e) {
            escreveErroComponente("Falha ao criar o arquivo PDF!!!");
        }

    }

    public void clicarMenu(String string) {
        try {
            switch (string) {
                case "Relatórios":
                    acaoRelatorios.menuRelatorios.click();
                    break;
                case "Relatórios Personalizados":
                    escreveStep("Clicar no menu Relatórios e em Relatórios personalizados");
                    inserePrint();
                    acaoRelatorios.menuRelatoriosPersonalizados.click();
                    break;
            }
        } catch (Exception e) {
            escreveErroComponente(e.getMessage());
        }
    }

    public void selecionarConta(String string) {
        try {
            switch (string){
                case "Grav/Edit":
                    escreveStep("Selecionar a conta e clicar no botão 'Seguinte'");
                    acoesWeb.clicarContaAleatoria(acaoRelatorios.selectContasRelPesonalizado);
                    inserePrint();
                    break;
                case "Claro Musica":
                    acaoWeb.aguardaElementoPresente(acaoRelatorios.nomeConta);
                    conta = acaoRelatorios.nomeConta.getText();
            }

        } catch (Exception e) {
            escreveErroComponente(e.getMessage());
        }
    }

    public void clicarBotao(String string) {
        try {
            switch (string) {
                case "Seguinte Conta":
                    acaoRelatorios.btnSeguinteConta.click();
                    break;
                case "Seguinte Servico":
                    acaoRelatorios.btnSeguinteServico.click();
                    break;
                case "Seguinte Pais":
                    acaoRelatorios.btnSeguintePais.click();
                    break;
                case "Seguinte Periodo":
                    acaoRelatorios.btnSeguintePeriodo.click();
                    break;
                case "Gerar":
                    acaoRelatorios.menuRelatorios.click();
                    acaoRelatorios.menuRelatoriosPersonalizados.click();
                    break;
            }
        } catch (Exception e) {
            escreveErroComponente(e.getMessage());
        }
    }

    public void selecionarServico(String string) {
        try {
            switch (string) {
                case "Claro Musica":
                    acaoWeb.aguardaElementoPresente(acaoRelatorios.inputServicoRBT);
                    escreveStep("Selecionar o serviço 'Claro Música' e clicar no botão Seguinte");
                    inserePrint();
                    break;
                case "RBT":
                    acaoWeb.aguardaElementoPresente(acaoRelatorios.inputServicoRBT);
                    escreveStep("Selecionar o serviço 'RBT' e clicar no botão Seguinte");
                    acaoRelatorios.inputServicoRBT.click();
                    inserePrint();
                    break;
                case "OTT Unificado":
                    acaoWeb.aguardaElementoPresente(acaoRelatorios.inputServicoRBT);
                    escreveStep("Selecionar o serviço 'OTT Unificado' e clicar no botão Seguinte");
                    acaoRelatorios.inputServicoOTTUnificado.click();
                    inserePrint();
                    break;
                case "OTT":
                    acaoWeb.aguardaElementoPresente(acaoRelatorios.inputServicoRBT);
                    escreveStep("Selecionar o serviço 'OTT' e clicar em Todos");
                    acaoRelatorios.inputServicoOTT.click();
                    acaoWeb.aguardaElementoPresente(acaoRelatorios.btnOTTNenhumSelecionado);
                    acaoRelatorios.btnOTTNenhumSelecionado.click();
                    acaoRelatorios.servicoOTTTodos.click();
                    inserePrint();
                    escreveStep("Clicar no botão Seguinte");
                    acaoRelatorios.inputServicoOTT.click();
                    inserePrint();
                    fim = true;
                    break;
            }
        } catch (Exception e) {
            escreveErroComponente(e.getMessage());
        }
    }

    public void selecionarPais() {
        try {
            escreveStep("Selecionar o país 'Brasil' e clicar no botão Seguinte");
            acaoRelatorios.selectPaisesCustomizados.click();
            acaoRelatorios.selectBrasilCustomizado.click();
            inserePrint();
        } catch (Exception e) {
            escreveErroComponente(e.getMessage());
        }
    }

    public void selecionarPeriodo(String string) {
        try {
            switch (string) {
                case "Inicial":
                    escreveStep("Selecionar o período inicial");
                    acoesWeb.selecionarTresMesesAnteriores();
                    inserePrint();
                    break;
                case "Final":
                    escreveStep("Selecionar o período final e clicar em Seguinte");
                    acoesWeb.selecionarUmMesAnterior();
                    inserePrint();
                    break;
            }
        } catch (Exception e) {
            escreveErroComponente(e.getMessage());
        }
    }

    public void validarDadosSelecionados() {
        try {
            String servico = acaoRelatorios.textoServicoSelecionado.getText();
            String pais = acaoRelatorios.textoPaisSelecionado.getText();
            String periodo = acaoRelatorios.textoPeriodoSelecionado.getText();
            escreveStep("Validar os dados selecionados");
            inserePrint();
            if(conta != null){
                escreveDocumento("Conta: " + conta + "\nServiço: " + servico + "\nPais: " + pais + "\nPeríodo: " + periodo);
            }else{
                String contaGravEdit = acaoRelatorios.textoContaSelecionada.getText();
                escreveDocumento("Conta: " + contaGravEdit + "\nServiço: " + servico + "\nPais: " + pais + "\nPeríodo: " + periodo);
            }
        } catch (Exception e) {
            escreveErroComponente(e.getMessage());
        }
    }

    public void salvarPDF() {
        salvaDocumento();
        if (fim) {
            killDriver();
        }
    }
}


