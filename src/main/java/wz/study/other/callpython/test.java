/**
 * Copyright (C), 2011-2018, 微贷网.
 */
package wz.study.other.callpython;

import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion;
import org.python.core.*;
import org.python.util.PythonInterpreter;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * @author wangzhe 2018/1/31.
 */
public class test {

    static String url1 = "http://resources.weidai.com.cn/wdgp01/M00/05/E6/rBQBP1kFVgOAVwUUAABAeTo0ySc573.jpg";
    static String url2 = "http://resources.weidai.com.cn/wdgp01/M00/05/E6/rBQBP1kFVcuAQTfnAAD2Y679ZSQ318.jpg";
    public static void main(String[] args) throws Exception{

        Jython();

    }

    public static void cmdLine () throws Exception
    {

        Process proc = Runtime.getRuntime().exec("python  /Users/wangzhe/Documents/WorkSpace/data-reform/face_distance.py 123 123");
        InputStream is = proc.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        String line;
        while((line = reader.readLine())!= null){
            System.out.println(line);
        }
        proc.waitFor();
        is.close();
        reader.close();
        proc.destroy();
    }
    public static void Jython () throws Exception
    {

        PythonInterpreter interpreter = new PythonInterpreter();
        PySystemState sys = Py.getSystemState();

        sys.path.add("/Library/Frameworks/Python.framework/Versions/2.7/lib/python2.7/site-packages/PIL");
        sys.path.add("/Library/Frameworks/Python.framework/Versions/2.7/lib/python2.7/site-packages/scipy");

        System.out.println(sys.path.toString());

        interpreter.exec("import sys");
        interpreter.exec("import scipy.misc");
        interpreter.exec("from PIL import Image, ImageDraw, ImageFont");

        interpreter.execfile("/Users/wangzhe/Documents/WorkSpace/data-reform/face_distance.py");
        PyFunction func = interpreter.get("get_face_distance_url", PyFunction.class);

        PyObject pyobj = func.__call__(new PyString(url1), new PyString(url2));
        System.out.println("anwser = " + pyobj.toString());
    }


    public static void JythonStream () throws Exception
    {
        PythonInterpreter interpreter = new PythonInterpreter();
        InputStream filepy = new FileInputStream("/Users/wangzhe/Documents/WorkSpace/data-reform/face_distance.py");
        interpreter.execfile(filepy);  ///执行python py文件
        filepy.close();
    }

}
