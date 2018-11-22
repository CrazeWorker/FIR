package Day_6_HomeWork;

public interface LibraryDao {
	// 显示所有图书
	void check();
	// 添加图书
	void add();
	// 删除图书
	void delete();
	// 借出图书
	void borrow();
	// 归还图书
	void giveBack();
	// 展示界面
	void show();
	// 功能選擇
	void useTool();
}
