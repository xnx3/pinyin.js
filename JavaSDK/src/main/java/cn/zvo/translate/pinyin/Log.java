package cn.zvo.translate.pinyin;

/**
 * 日志输出调试
 * @author 管雷鸣
 *
 */
public class Log {
	public static boolean debug = true;	//默认为true，开启
	public static boolean error = true;	//默认为true，开启
	public static boolean info = true;	//默认为true，开启

	/**
	 * 增加一条错误的log信息
	 */
	public static void debug(String text){
		if(debug){
			StackTraceElement st = Thread.currentThread().getStackTrace()[2];
			System.out.println(text+" \t "+st.getClassName()+"."+st.getMethodName()+"() "+st.getLineNumber()+" Line");
		}
	}
	
	public static void error(String text){
		if(error){
			StackTraceElement st = Thread.currentThread().getStackTrace()[2];
			System.err.println(text+" \t "+st.getClassName()+"."+st.getMethodName()+"() "+st.getLineNumber()+" Line");
		}
	}
	
	public static void main(String[] args) {
		debug = true;
		debug("测试一下");
	}
	
	public static void log(String text){
		StackTraceElement st = Thread.currentThread().getStackTrace()[2];
		System.out.println(text+" \t "+st.getClassName()+"."+st.getMethodName()+"() "+st.getLineNumber()+" Line");
	}
	public static void info(String text){
		if(info){
			StackTraceElement st = Thread.currentThread().getStackTrace()[2];
			System.out.println(text+" \t "+st.getClassName()+"."+st.getMethodName()+"() "+st.getLineNumber()+" Line");
		}
	}
	

	/**
	 * 调试日志输出
	 * @param object 非static的传入this
	 * @param method 那个类那个方法，如 debug 后面不加()，只是方法名字
	 * @param message 日志信息
	 * @see #debug(String, String, String)
	 * @deprecated
	 */
	public void debug(Object object, String method,String message){
		debug(object.getClass().getName(), method, message);
	}
	
	/**
	 * 调试日志输出
	 * @param className 当前class名字，加包名全名，如 com.xnx3.Log
	 * @param method 那个类那个方法，如 debug 后面不加()，只是方法名字
	 * @param message 日志信息
	 * @deprecated
	 */
	public void debug(String className,String method,String message){
		if(debug){
			System.out.println("DEBUG : "+className+"类"+method+"()方法  "+message);
		}
	}
}