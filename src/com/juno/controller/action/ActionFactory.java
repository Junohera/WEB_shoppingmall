package com.juno.controller.action;

import com.juno.admin.controller.AdminLogoutAction;
import com.juno.admin.controller.action.AdminAction;
import com.juno.admin.controller.action.AdminLoginAction;
import com.juno.admin.controller.action.AdminMemberListAction;
import com.juno.admin.controller.action.AdminOrderListAction;
import com.juno.admin.controller.action.AdminOrderSaveAction;
import com.juno.admin.controller.action.AdminProductDetailAction;
import com.juno.admin.controller.action.AdminProductListAction;
import com.juno.admin.controller.action.AdminProductUpdateAction;
import com.juno.admin.controller.action.AdminProductUpdateFormAction;
import com.juno.admin.controller.action.AdminProductWriteAction;
import com.juno.admin.controller.action.AdminProductWriteFormAction;
import com.juno.admin.controller.action.AdminQnaAttachAnswerAction;
import com.juno.admin.controller.action.AdminQnaDetailAction;
import com.juno.admin.controller.action.AdminQnaListAction;

public class ActionFactory {
    private ActionFactory() {}
    private static ActionFactory ist = new ActionFactory();
    public static ActionFactory getIst() {return ist;}
	public Action getAction(String command) {
		Action ac = null;
		
		System.out.println(command + " actionFactory ");
		
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
		else if (command.equals("findIdPw")) ac = new FindIdPwAction();
		else if (command.equals("findId")) ac = new FindIdAction();
		else if (command.equals("findIdStep2")) ac = new FindIdStep2Action();
		else if (command.equals("findIdStep3")) ac = new FindIdStep3Action();
		else if (command.equals("findIdStep3")) ac = new FindIdStep3Action();
		else if (command.equals("findPwForm")) ac = new FindPwFormAction();
		else if (command.equals("findPwStep3")) ac = new FindPwStep3Action();
		else if (command.equals("resetPw")) ac = new ResetPwAction();
		
		
		/** admin */
		else if (command.equals("admin")) ac = new AdminAction();
		else if (command.equals("adminLogin")) ac = new AdminLoginAction();
		else if (command.equals("adminProductList")) ac = new AdminProductListAction();
		else if (command.equals("adminProductDetail")) ac = new AdminProductDetailAction();
		else if (command.equals("adminProductWriteForm")) ac = new AdminProductWriteFormAction();
		else if (command.equals("adminProductWrite")) ac = new AdminProductWriteAction();
		else if (command.equals("adminProductUpdateForm")) ac = new AdminProductUpdateFormAction();
		else if (command.equals("adminProductUpdate")) ac = new AdminProductUpdateAction();
		else if (command.equals("adminMemberList")) ac = new AdminMemberListAction();
		else if (command.equals("adminOrderList")) ac = new AdminOrderListAction();
		else if (command.equals("adminQnaList")) ac = new AdminQnaListAction();
		else if (command.equals("adminOrderSave")) ac = new AdminOrderSaveAction();
		else if (command.equals("adminQnaDetail")) ac = new AdminQnaDetailAction();
		else if (command.equals("adminQnaAttachAnswer")) ac = new AdminQnaAttachAnswerAction();
		
		else if (command.equals("adminLogout")) ac = new AdminLogoutAction();

		

		return ac;
	}
}
