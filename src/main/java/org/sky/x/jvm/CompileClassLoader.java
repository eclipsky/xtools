package org.sky.x.jvm;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.sky.x.TestReference;

public class CompileClassLoader extends ClassLoader {
	// 读入源文件转换为字节数组
	private byte[] getSource(String filename) {
		File file = new File(filename);
		int length = (int) file.length();
		byte[] contents = new byte[length];
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(file);
			int r = fis.read(contents);
			if (r != length) {
				throw new IOException("IOException:无法读取" + filename);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (fis != null) {
					fis.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return contents;
	}

	// 编译文件
	public boolean compile(String javaFile) {
		System.out.println("正在编译" + javaFile);
		int ret = 0;
		try {
			// 调用系统命令编译文件
			Process process = Runtime.getRuntime().exec("javac " + javaFile);
			process.waitFor();
			ret = process.exitValue();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return ret == 0;
	}

	// 重写findclass
	@Override
	protected Class<?> findClass(String name) throws ClassNotFoundException {
		Class<?> clazz = null;
		// 将文件的.替换为/，例如com.lyl.reflect.Reflect被替换为com/lyl/reflect/Reflect
		String fileStub = name.replace(".", "/");
		// java源文件名
		String javaFileName = fileStub + ".java";
		// 编译后的class文件名
		String classFileName = fileStub + ".class";
		File javaFile = new File(javaFileName);
		File classFile = new File(classFileName);
		// 当指定JAVA源文件存在，且class文件不存在，
		// 或者java源文件的修改时间比class文件修改时间晚则重新编译
		if (javaFile.exists()
				&& (!classFile.exists() || javaFile.lastModified() > classFile
						.lastModified())) {
			// 如果编译失败，或者class文件不存在
			if (!compile(javaFileName) || !classFile.exists()) {
				throw new ClassNotFoundException("ClassNotFoundException:"
						+ javaFileName);
			}
		}
		// 如果CLASS文件按存在，系统负责将该文件转换成Class对象
		if (classFile.exists()) {
			byte[] raw = getSource(classFileName);
			// 将ClassLoader的defineClass方法将二进制数据转换成Class对象
			int divindex = name.indexOf(File.separator);
			String javafilename = null;
			// 如果是某个盘里面的文件，要去掉文件的盘符
			if (divindex != -1) {
				javafilename = name.substring(divindex + 1, name.length());
			}
			// 将字节数组转换为class实例
			clazz = defineClass(javafilename, raw, 0, raw.length);
		}
		// 如果clazz为null，表明加载失败，则抛出异常
		if (clazz == null) {
			throw new ClassNotFoundException(name);
		}
		return clazz;
	}

	// 定义主方法
	public static void main(String[] args) throws ClassNotFoundException,
			SecurityException, NoSuchMethodException, IllegalArgumentException,
			IllegalAccessException, InvocationTargetException {
		// 如果运行该程序没有参数，则没有目标类
		if (args.length < 1) {
			System.out.println("缺少运行的目标类，请按如下格式运行源文件");
			System.out.println("java CompileClassLoader ClassName");
			System.exit(0);
		}
		// 第一个参数为需要运行的类
		String proClass = args[0];
		// 剩下的参数将作为目标类得参数
		String[] proArgs = new String[args.length - 1];
		System.arraycopy(args, 1, proArgs, 0, proArgs.length);
		CompileClassLoader ccl = new CompileClassLoader();
		// 加载需要运行的类
		Class<?> clazz = ccl.loadClass(proClass);
		System.out.println("自定义类加载器为" + clazz.getClassLoader());
		System.out.println("默认类加载器为" + TestReference.class.getClassLoader());
		System.out.println((new String[0]).getClass().getName() + "\t"
				+ String[].class.getName());// [Ljava.lang.String;
											// "["表示一维数组，依次"[["表示二维数组
		System.out.println((new String()).getClass().getName() + "\t"
				+ String.class.getName());
		Method main = clazz.getMethod("main", (new String[0]).getClass());
		Object[] argsArray = { proArgs };
		main.invoke(null, argsArray);
	}
}
