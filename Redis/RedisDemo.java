package Redis;

import redis.clients.jedis.Jedis;

/**
 * @author Suheng
 *
 */
public class RedisDemo {
	public static void main(String[] args) {
		test1Normal();
	}

	// 普通同步方式
	public static void test1Normal() {
		Jedis jedis = new Jedis("localhost");
		long start = System.currentTimeMillis();
		for (int i = 0; i < 1000; i++) {
			String result = jedis.set("n" + i, "n" + i);
		}
		long end = System.currentTimeMillis();
		System.out.println((end - start) / 1000.0);
		jedis.disconnect();

	}

	// 事务处理方式(Transactions)
	
	
}
