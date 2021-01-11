package com.juno.action;

public class ActionFactory {
    private ActionFactory() {}
    private static ActionFactory ist = new ActionFactory();
    public static ActionFactory getIst() {return ist;}
	public Action getAction(String command) {
		Action ac = null;
		System.out.println("actionFactory ::: " + command);
		if (command.equals("index")) ac = new IndexAction();
		else if (command.equals("contract")) ac = new ContractAction();
		else if (command.equals("loginForm")) ac = new LoginFormAction();
		else if (command.equals("login")) ac = new LoginAction();
		else if (command.equals("joinForm")) ac = new JoinFormAction();
		else if (command.equals("join")) ac = new JoinAction();
		else if (command.equals("idCheckForm")) ac = new IdCheckFormAction();
		else if (command.equals("findZipNum")) ac = new FindZipNumAction();
		else if (command.equals("memberUpdateForm")) ac = new MemberUpdateFormAction();
		else if (command.equals("memberUpdate")) ac = new MemberUpdateAction();
		else if (command.equals("logout")) ac = new LogoutAction();
		else if (command.equals("category")) ac = new CategoryAction();
		else if (command.equals("productDetail")) ac = new ProductDetailAction();
		
		return ac;
	}
}
