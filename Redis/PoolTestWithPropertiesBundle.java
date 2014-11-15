package Demo;

import java.util.ResourceBundle;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class PoolTestWithPropertiesBundle {
	private ResourceBundle rb = null;
	private JedisPool jpool = null;
	private JedisPoolConfig jconfig = null;

	public PoolTestWithPropertiesBundle() {
		rb = this.getResouceFromProperties();
		this.jconfig = new JedisPoolConfig();
		this.jconfig.setMaxActive(500);
		this.jconfig.setMinIdle(5);
		this.jconfig.setTestOnBorrow(true);
		this.jpool = new JedisPool(this.jconfig, this.rb.getString("url"),
				Integer.parseInt(this.rb.getString("port")), 1000,
				this.rb.getString("auth"));
	}

	public Jedis getJedisFromPool() {
		return this.jpool.getResource();
	}

	private ResourceBundle getResouceFromProperties() {
		// TODO Auto-generated method stub
		return ResourceBundle.getBundle("redis");
	}

	public static void main(String[] args) {
		PoolTestWithPropertiesBundle p = new PoolTestWithPropertiesBundle();
		Jedis j = p.getJedisFromPool();
		System.out.println(j.get("num"));

	}
}
