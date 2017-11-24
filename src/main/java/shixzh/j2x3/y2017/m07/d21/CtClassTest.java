package shixzh.j2x3.y2017.m07.d21;

import java.io.FileOutputStream;

import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtField;
import javassist.CtMethod;

public class CtClassTest {

    public static void main(String[] args) {

        //默认的类搜索路径
        ClassPool pool = ClassPool.getDefault();
        //获取一个ctClass对象
        CtClass ctClass = pool.makeClass("com.luoxiaohui.Test");
        try {
            //添加age属性
            ctClass.addField(CtField.make("private int age;", ctClass));
            //添加setAge方法
            ctClass.addMethod(CtMethod.make("public void setAge(int age){this.age = age;}", ctClass));
            //添加getAge方法
            ctClass.addMethod(CtMethod.make("public int getAge(){return this.age;}", ctClass));
            //将ctClass生成字节数组，并写入文件
            byte[] byteArray = ctClass.toBytecode();
            FileOutputStream output = new FileOutputStream("/Users/luoxiaohui/Desktop/test/Test.class");
            output.write(byteArray);
            output.close();
            System.out.println("文件写入成功!!!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
