package com.ky.tests.jython;

import java.util.Properties;

import org.python.util.PythonInterpreter;

public class Main
{
    public static void main(String[] args)
    {
        Properties props = new Properties();
        props.put("python.home","usr/bin/");
        props.put("python.console.encoding", "UTF-8"); // Used to prevent: console: Failed to install '': java.nio.charset.UnsupportedCharsetException: cp0.
        props.put("python.security.respectJavaAccessibility", "false"); //don't respect java accessibility, so that we can access protected members on subclasses
        props.put("python.import.site","false");
        PythonInterpreter.initialize(System.getProperties(), props, new String[0]);
        
        Calculator calculator = new CalculatorFactory("calculators", "Adder").create();
        System.out.println(calculator.calc(1, 2)); //1 + 2 + 0.5 = 3.5
        calculator = new CalculatorFactory("calculators", "Multipler").create();
        System.out.println(calculator.calc(1, 2)); // 1 × 2 × 0.5 = 1.0
    }
}
