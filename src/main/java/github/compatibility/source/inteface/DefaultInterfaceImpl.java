
package github.compatibility.source.inteface;

/**
 *
 * @author elseifer
 * @version $Id: DefaultInterfaceImple.java, v 0.1 2020年07月04日 下午5:32 elseifer Exp $
 */
public class DefaultInterfaceImpl implements DefaultInteface{

    @Override
    public void method() {
        System.out.println(this.getClass().getName());


    }
}