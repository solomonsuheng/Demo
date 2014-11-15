package Demo;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class PoolTest {
	private JedisPool pool = null;
	private JedisPoolConfig config = null;
	private GetProperty property = null;

	public PoolTest() {
		this.property = new GetProperty("/redis.properties");
		this.config = new JedisPoolConfig();
		this.config.setMaxActive(500);
		this.config.setMaxIdle(5);
		this.config.setTestOnBorrow(true);
		this.pool = new JedisPool(this.config, this.property.getPro("url"),
				Integer.parseInt(this.property.getPro("port")), 1000,
				this.property.getPro("auth"));
	}

	public Jedis getJedis() {
		return this.pool.getResource();
	}

	public static void main(String[] args) {
		PoolTest pool = new PoolTest();
		Jedis j = pool.getJedis();
		String s = j.get("num");
		System.out.println(s);
	}
}
