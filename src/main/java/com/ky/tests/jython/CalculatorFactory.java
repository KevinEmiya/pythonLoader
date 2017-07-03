package com.ky.tests.jython;

import javax.annotation.Resource;

import org.python.core.PyObject;
import org.python.util.PythonInterpreter;

public class CalculatorFactory
{
    private PyObject calcClass;

    @Resource
    protected static final PythonInterpreter INTERP = new PythonInterpreter();

    /**
     * Create a new PythonInterpreter object, then use it to execute some python
     * code. In this case, we want to import the python module that we will
     * coerce.
     *
     * Once the module is imported than we obtain a reference to it and assign
     * the reference to a Java variable
     */

    public CalculatorFactory(String scriptName, String className)
    {
        String cmd = "from " + scriptName + " import " + className;
        INTERP.exec(cmd);
        calcClass = INTERP.get(className);
    }

    /**
     * The create method is responsible for performing the actual coercion of
     * the referenced python module into Java bytecode
     */

    public Calculator create()
    {
        PyObject buildingObject = calcClass.__call__();
        return (Calculator) buildingObject.__tojava__(Calculator.class);
    }

}
