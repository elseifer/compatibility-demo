
package github.compatibility.binary;

import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author elseifer
 * @version $Id: ApacheUtilsDemo.java, v 0.1 2020年07月05日 下午4:47 elseifer Exp $
 */
public class ApacheUtilsDemo {

    public static void main(String[] args) {

        boolean flag = StringUtils.equals("aaa", "bbb");

        System.out.println(flag);

    }

}