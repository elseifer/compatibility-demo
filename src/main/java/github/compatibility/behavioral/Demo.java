
package github.compatibility.behavioral;

import github.compatibility.behavioral.interf.InterfI;
import github.compatibility.behavioral.interf.InterfaceImpl;

import java.lang.reflect.Method;

/**
 *
 * @author elseifer
 * @version $Id: Demo.java, v 0.1 2020年07月05日 下午12:08 elseifer Exp $
 */
public class Demo {


    public static void main(String[] args) {

        InterfI i = new InterfaceImpl();

        Method[] methods = i.getClass().getMethods();

        for (Method m : methods) {

            System.out.println(m);
        }
    }

}