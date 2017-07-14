package Repository;

public interface IRepository {
	public void insert(Object obj);
	public void addAfterChecked(Object obj);
	public void remove(Object obj);
	public void update(Object obj);
	public Object get();
	public Object find(Object obj);
}
