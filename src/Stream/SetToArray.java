package Stream;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class SetToArray {

    public static void main(String[] args) {
        Set<Long> setLong = new TreeSet<>();

        //1. stream. set to Long
        Long[] arrays = setLong.stream().toList().toArray(Long[]::new);

        //2. stream set to long
        long[] array2 = setLong.stream().mapToLong(x -> x).toArray();

        // easy from set to arrayList
        ArrayList<Long> al = new ArrayList<>(setLong);
    }


}
