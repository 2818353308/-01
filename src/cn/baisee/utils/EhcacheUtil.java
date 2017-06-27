package cn.baisee.utils;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

/**
 * EnCache������
 * 
 * @author Administrator
 *
 */
public class EhcacheUtil {

	//���������
	private CacheManager manager;
	//���湤����
	private static EhcacheUtil ehCache;
	//���캯��
	private EhcacheUtil() {
		manager = CacheManager.create(EhcacheUtil.class.getClassLoader()
				.getResourceAsStream("ehcache.xml"));
	}
	//������ǰ�����Ķ���
	public static EhcacheUtil getInstance() {
		if (ehCache == null) {
			ehCache = new EhcacheUtil();
		}
		return ehCache;
	}
	/**
	 * ���һ������
	 * @param cacheName ��������
	 * @param key ����key
	 * @param value ����ֵ
	 */
	public void put(String cacheName, String key, Object value) {
		Cache cache = manager.getCache(cacheName);
		Element element = new Element(key, value);
		cache.put(element);
	}
	/**
	 * ��ȡһ��ֵ
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
	 * ��ȡһ��cache
	 * @param cacheName
	 * @return
	 */
	public Cache get(String cacheName) {
		return manager.getCache(cacheName);
	}
	/**
	 * ɾ��һ��ֵ
	 * @param cacheName
	 * @param key
	 */
	public void remove(String cacheName, String key) {
		Cache cache = manager.getCache(cacheName);
		cache.remove(key);
	}
	/**
	 * ��յ�ǰ����
	 * @param cacheName
	 */
	public void clear(String cacheName) {
		Cache cache = manager.getCache(cacheName);
		cache.removeAll();
	}
	
	
	public static void main(String[] args) {
		EhcacheUtil.getInstance().put("simpleCode", "cn.baisee.demo", "��˼�������");
		System.out.println(EhcacheUtil.getInstance().get("simpleCode",
				"cn.baisee.demo"));
	}

	/*
	 * public static void main(String[] args) {
	 * CacheManager cm =CacheManager.create(EnCacheUtils.class.getClassLoader().getResource("ehcache.xml")); //��λ�ȡһ������ Cache cache =
	 * cm.getCache("simpleCode"); //���һ��Ԫ�أ�ÿһ��Ԫ�ض���һ��Element //����һ��Ԫ�� Element
	 * el=new Element("test1", "test2"); cache.put(el); Element element
	 * =cache.get("test1"); System.out.println(element.getValue()); }
	 */

}
