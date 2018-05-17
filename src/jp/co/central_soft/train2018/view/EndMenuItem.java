package jp.co.central_soft.train2018.view;
import jp.co.central_soft.train2018.util.ConsoleUtil;

//-----------------------------
public class EndMenuItem extends MenuItem
{

	public EndMenuItem(int menuNum, String name, String menuName)
	{
		super(menuNum, name, menuName);
	}

	public void excecAction()
	{
		ConsoleUtil.print("終了します。");
	}
}
