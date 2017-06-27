package cn.baisee.utils;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

/**
 * EnCache工具类
 * 
 * @author Administrator
 *
 */
public class EhcacheUtil {

	//缓存管理器
	private CacheManager manager;
	//缓存工具类
	private static EhcacheUtil ehCache;
	//构造函数
	private EhcacheUtil() {
		manager = CacheManager.create(EhcacheUtil.class.getClassLoader()
				.getResourceAsStream("ehcache.xml"));
	}
	//创建当前单例的对象
	public static EhcacheUtil getInstance() {
		if (ehCache == null) {
			ehCache = new EhcacheUtil();
		}
		return ehCache;
	}
	/**
	 * 存放一个缓存
	 * @param cacheName 缓存名称
	 * @param key 缓存key
	 * @param value 缓存值
	 */
	public void put(String cacheName, String key, Object value) {
		Cache cache = manager.getCache(cacheName);
		Element element = new Element(key, value);
		cache.put(element);
	}
	/**
	 * 拿取一个值
	 * @param cacheName
	 * @param key
	 * @return
	 */
	public Object get(String cacheName, String key) {
		Cache cache = manager.getCache(cacheName);
		Element element = cache.get(key);
		return element == null ? null : element.getObjectValue();
	}
	/**'
	 * 获取一个cache
	 * @param cacheName
	 * @return
	 */
	public Cache get(String cacheName) {
		return manager.getCache(cacheName);
	}
	/**
	 * 删除一个值
	 * @param cacheName
	 * @param key
	 */
	public void remove(String cacheName, String key) {
		Cache cache = manager.getCache(cacheName);
		cache.remove(key);
	}
	/**
	 * 清空当前缓存
	 * @param cacheName
	 */
	public void clear(String cacheName) {
		Cache cache = manager.getCache(cacheName);
		cache.removeAll();
	}
	
	
	public static void main(String[] args) {
		EhcacheUtil.getInstance().put("simpleCode", "cn.baisee.demo", "百思缓存测试");
		System.out.println(EhcacheUtil.getInstance().get("simpleCode",
				"cn.baisee.demo"));
	}

	/*
	 * public static void main(String[] args) {
	 * CacheManager cm =CacheManager.create(EnCacheUtils.class.getClassLoader().getResource("ehcache.xml")); //如何获取一个缓存 Cache cache =
	 * cm.getCache("simpleCode"); //存放一个元素，每一个元素都是一个Element //创建一个元素 Element
	 * el=new Element("test1", "test2"); cache.put(el); Element element
	 * =cache.get("test1"); System.out.println(element.getValue()); }
	 */

}
