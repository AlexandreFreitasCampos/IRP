package br.com.claro.irp.pages.pageActions;

import br.com.claro.irp.action.Action;


public class PageFactory {

	public static Action pegarTela(String string) throws ClassNotFoundException {

		switch (string) {
			case "Login":	return new LoginPA();
			case "ValidarComponentesTelas": return new ValidarComponentesTelasPA();
			case "Menu": return new MenuPA();
			case "Contas":	return new ContasPA();
			case "Relatorios":    return new RelatoriosPA();
			case "Faturamento":    return new FaturamentoPA();		
			default:
			throw new ClassNotFoundException();
		}
	}

}
