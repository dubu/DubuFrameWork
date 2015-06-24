package com.dubu;

import com.google.common.base.Optional;
import org.junit.Test;

/**
 * Created by rigel on 6/23/15.
 * https://code.google.com/p/guava-libraries/    // 요기 테스트 부분을 봅시다.
 * guava 샘플을 다 합쳐 봅시다.
 */
public class GuavaTest {

    @Test
    public void g(){

        // optional OptionalTest 참고 . 왜 쓰는지 모르겠음
        Optional<Integer> possible = Optional.of(5);
        possible.isPresent();
        possible.get();
    }
}
