package kr.co.ioacademy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class Example2 {
    /*
    private static final Integer[] VALUES =
            { 1, 2, 3, 4, 5 };

    // 해결 방법 1. 방어 복사본
    public static Integer[] values() {
        return VALUES.clone();
    }
    */

    // 해결 방법 2. 수정불가 컬렉션 사용 - UnsupportedOperationException
    private static final Integer[] PRIVATE_VALUES = {1, 2, 3, 4, 5};
    public static final Collection<Integer> VALUES =
            Collections.unmodifiableCollection(Arrays.asList(PRIVATE_VALUES));

    public static void main(String[] args) {
        Collection<Integer> arr = Example2.VALUES;
        arr.add(10);

        for (Integer e : VALUES) {
            System.out.println(e);
        }
    }


}
