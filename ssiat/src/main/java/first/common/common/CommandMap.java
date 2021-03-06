//package first.common.common;
//
//import java.util.HashMap;
//import java.util.Map;
//import java.util.Map.Entry;
//import java.util.Set;
//
//// HandlerMethodArgumentResolver 의 일환
//// map의 기본 기능을 호출하기 위한 메서드들 작성
//public class CommandMap {
//// 주의 : Map을 상속받으면 안됨
//// Map을 상속받게 되면 ArgumentResolver를 거치지 않게 되니 주의.
//
//	Map<String,Object> map = new HashMap<String,Object>();
//
//	public Object get(String key){
//		return map.get(key);
//	}
//
//	public void put(String key, Object value){
//		map.put(key, value);
//	}
//
//	public Object remove(String key){
//		return map.remove(key);
//	}
//
//	public boolean containsKey(String key){
//		return map.containsKey(key);
//	}
//
//	public boolean containsValue(Object value){
//		return map.containsValue(value);
//	}
//
//	public void clear(){
//		map.clear();
//	}
//
//	public Set<Entry<String, Object>> entrySet(){
//		return map.entrySet();
//	}
//
//	public Set<String> keySet(){
//		return map.keySet();
//	}
//
//	public boolean isEmpty(){
//		return map.isEmpty();
//	}
//
//	public void putAll(Map<? extends String, ?extends Object> m){
//		map.putAll(m);
//	}
//
//	public Map<String,Object> getMap(){
//		return map;
//	}
//
//}
