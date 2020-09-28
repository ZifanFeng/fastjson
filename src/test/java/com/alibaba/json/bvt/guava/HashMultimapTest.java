package com.alibaba.json.bvt.guava;
import static net.javacrumbs.jsonunit.assertj.JsonAssertions.assertThatJson;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.HashMultimap;
import com.google.gson.Gson;
import junit.framework.TestCase;
import net.javacrumbs.jsonunit.core.Option;

/**
 * Created by wenshao on 15/01/2017.
 */
public class HashMultimapTest extends TestCase {
    public void test_for_multimap() throws Exception {
        HashMultimap map = HashMultimap.create();
        map.put("name", "a");
        map.put("name", "b");

        String json = JSON.toJSONString(map);
        assertThatJson("{\"name\":[\"b\",\"a\"]}")
        .when(Option.IGNORING_ARRAY_ORDER)
        .isEqualTo(json);
        
        assertThatJson("{\"name\":[\"a\",\"b\"]}")
        .when(Option.IGNORING_ARRAY_ORDER)
        .isEqualTo(json);
    }
}
