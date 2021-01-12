package com.juno.controller.action;

import com.juno.admin.controller.action.AdminAction;

public class ActionFactory {
    private ActionFactory() {}
    private static ActionFactory ist = new ActionFactory();
    public static ActionFactory getIst() {return ist;}
	public Action getAction(String command) {
		Action ac = null;
		
		/** user */
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
		else if (command.equals("cartInsert")) ac = new CartInsertAction();
		else if (command.equals("cartList")) ac = new CartListAction();
		else if (command.equals("cartList")) ac = new CartListAction();
		else if (command.equals("myPage")) ac = new MyPageAction();
		else if (command.equals("orderAll")) ac = new OrderAllAction();
		else if (command.equals("cartDelete")) ac = new CartDeleteAction();
		else if (command.equals("orderInsert")) ac = new OrderInsertAction();
		else if (command.equals("orderList")) ac = new OrderListAction();
		else if (command.equals("orderDetail")) ac = new OrderDetailAction();
		else if (command.equals("directOrderInsert")) ac = new DirectOrderInsertAction();
		else if (command.equals("qnaList")) ac = new QnaListAction();
		else if (command.equals("qnaWriteForm")) ac = new QnaWriteFormAction();
		else if (command.equals("qnaView")) ac = new QnaViewAction();
		else if (command.equals("qnaWrite")) ac = new QnaWriteAction();
		else if (command.equals("qnaUpdateForm")) ac = new QnaUpdateFormAction();
		else if (command.equals("qnaUpdate")) ac = new QnaUpdateAction();
		
		/** admin */
		else if (command.equals("amdin")) ac = new AdminAction();
		
		return ac;
	}
}
