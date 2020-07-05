package github.compatibility.binary;

import java.util.Optional;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author elseifer
 * @version $Id: BinaryCompatibilityDemo.java, v 0.1 2020年06月28日 下午5:55 elseifer Exp $
 */
public class BinaryCompatibilityDemo {

    public void demoKeySetView() {

        ConcurrentHashMap<String, String> concurrentHashMap = new ConcurrentHashMap<String, String>();

        long count = concurrentHashMap.mappingCount();

        Set<String> strings = concurrentHashMap.keySet();

        System.out.println(strings.size());

    }

    public void demoOption() {

        Optional<String> optional = Optional.empty();

    }

    public static void main(String[] args) {
        new BinaryCompatibilityDemo().demoKeySetView();
    }

    //-source 必须等于或低于 -target 的值必须一致，如 -source 1.8 -target 1.7 会报错 "javacTask: 源发行版 1.8 需要目标发行版 1.8"
    //无论是显性、隐性地使用高版本的类、api，-source -target 不会报错；

}