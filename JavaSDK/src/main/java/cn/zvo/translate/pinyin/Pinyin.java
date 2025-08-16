package cn.zvo.translate.pinyin;

import java.io.IOException;
import java.io.InputStream;
import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/**
 * 对 translate.js 的使用
 * @author 管雷鸣
 *
 */
public class Pinyin{
	static ScriptEngine engine;
	static Invocable invocable;
	static Object pinyinObject = null;
	
	static {
		// 创建脚本引擎管理器
        ScriptEngineManager manager = new ScriptEngineManager();
        // 获取 Nashorn 引擎
        engine = manager.getEngineByName("nashorn");
        
        //加载当前包下的js
        InputStream inputStream = Pinyin.class.getResourceAsStream("/pinyin.js");
		String js = null;
		try {
			js = StringUtil.inputStreamToString(inputStream, "UTF-8");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
        js = js.replaceAll("let ", "var ");
        js = js.replaceAll("const", "var");
        js = js.replaceAll(" of ", " in ");
        
        
        //console.log
        js = StringUtil.replaceAll(js, "console.log(", "//console.log(");
        
        
        try {
			engine.eval(js);
		} catch (ScriptException e) {
			e.printStackTrace();
		}
       
        // 将脚本引擎转换为 Invocable 接口，以便调用函数
        invocable = (Invocable) engine;
        
        
        
	}
	
	public static Object getPinyinObject() {
		if(pinyinObject == null) {
			// 获取 pinyin 对象
			try {
				pinyinObject = engine.eval("pinyin");
			} catch (ScriptException e) {
				e.printStackTrace();
			}
		}
		return pinyinObject;
	}
	
	/**
	 * 
	 * @param text 要转为拼音的中文
	 * @return 转成的拼音
	 * @throws ScriptException
	 */
	public static Object convert(String text) throws ScriptException {
        Object result = null;
		try {
			result = invocable.invokeMethod(getPinyinObject(), "convert", text);
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		}
        return result;
	}
	
	
	public static void main(String[] args) throws ScriptException {
		System.out.println(Pinyin.convert("你好"));
		System.out.println(convert("粤"));
	}	
}
