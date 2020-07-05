
package github.compatibility.source.inteface;

/**
 *
 * @author elseifer
 * @version $Id: PublicIntefaceImple.java, v 0.1 2020年07月04日 下午5:34 elseifer Exp $
 */
public class PublicIntefaceImpl implements PulicInteface {

    @Override
    public void method() {
        System.out.println(this.getClass().getName());
    }
}