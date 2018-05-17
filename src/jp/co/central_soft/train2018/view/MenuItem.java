package jp.co.central_soft.train2018.view;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jp.co.central_soft.train2018.dao.KaiinnMgr;

//-----------------------------
public abstract class MenuItem
{
    //------------------------------------
	public static final MenuItem END          = new EndMenuItem(1, "END", 			"終了");
	public static final MenuItem REGIST       = new RegistMenuItem(2, "REGIST", 	"登録");
	public static final MenuItem LISTOUT      = new ListOutMenuItem(3,"LISTOUT", 	"全データリスト表示");
	public static final MenuItem SEARCH       = new SearchMenuItem(4, "SEARCH", 	"検索");
    public static final Map<Integer, MenuItem> menuItemMap
                                        = new HashMap<Integer, MenuItem>();
	static
	{
        //メニュー番号ごとのメニューアイテムを登録する
        menuItemMap.put( END.getMenuNum(), 	END     );
        menuItemMap.put( REGIST.getMenuNum(), REGIST  );
        menuItemMap.put( LISTOUT.getMenuNum(), LISTOUT );
        menuItemMap.put( SEARCH.getMenuNum(), SEARCH  );
    }

	public static String getMenuString()
	{
		StringBuffer bf = new StringBuffer();
		List<MenuItem> list = new ArrayList<>();

		for( MenuItem mi: menuItemMap.values() )
		{
			list.add(mi);
		}

		//メニュ-番号でソート
		Collections.sort( list, new MenuItemComparator() );

		for( int i = 0; i < list.size(); i++ )
		{
			MenuItem mi = list.get(i);
			bf.append(" ").append(mi.getMenuNum() ).append(":").append(mi.menuName);
		}

		return bf.toString();
	}

	private String name;
	private String menuName;
	private int    menuNum;

	protected KaiinnMgr kaiinnMgr= new KaiinnMgr();


	public MenuItem( int menuNum, String name, String menuName )
	{
		super();
		this.menuNum	= menuNum;
		this.name 		= name;
		this.menuName 	= menuName;
	}

	public int getMenuNum() {
		return menuNum;
	}

	public String getMenuName()
	{
		return menuName;
	}

	public String getName()
	{
		return name;
	}

	abstract public void excecAction();

	@Override
	public String toString() {
		return "MenuItem [name=" + name + ", menuName=" + menuName + ", menuNum=" + menuNum + ", kaiinnMgr=" + kaiinnMgr
				+ "]";
	}


}

//-------------------------------------
//メニュー番号でソート
class MenuItemComparator implements Comparator<MenuItem>
{
	@Override
	public int compare(MenuItem m1, MenuItem m2)
	{
		if( m1.getMenuNum() < m2.getMenuNum() )
		{	return -1; }

		return 1;
	}
}
