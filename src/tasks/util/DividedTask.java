package tasks.util;

import java.util.List;

/**
 * 
 * @author shamsulbahrin
 * @since 24 Sep 2023
 */
public interface DividedTask<T> {
	
	@SuppressWarnings("hiding")
	public <T> void run(List<T> sublist);

}
