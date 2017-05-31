package com.sky.demo.unit.package_post;

import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.MapUtils;

import java.util.*;

/**
 * Created by user on 17/5/31.
 *
 * 订单分多个商品，商品有多个仓库，求邮费最小（包裹数最少）
 * input：商品列表
 * output：仓库及包裹信息
 */
public class PackagePost {




    public static Map<String, List<Integer>> getPackages(List<Integer> products) {
        Map<String, List<Integer>> result = Maps.newHashMap();

        Map<Integer, List<String>> productInCabins = getProductInCabins(products);

        Map<String, List<Integer>> cabinsWithProducts = getCabinsWithProducts(productInCabins);


        splitOrder(cabinsWithProducts, result);

        return result;
    }

    /**
     * 贪心算法
     * @param cabinsWithProducts
     * @param cabins
     */
    public static void splitOrder(Map<String, List<Integer>> cabinsWithProducts, Map<String, List<Integer>> cabins) {

        if (MapUtils.isEmpty(cabinsWithProducts)) {
            return;
        }

        //sort
        List<Map.Entry<String, List<Integer>>> list = sortMapByValueSize(cabinsWithProducts);
        if (CollectionUtils.isEmpty(list)) {
            return;
        } else {

            //put max products
            List<Integer> maxSizeProducts = Lists.newArrayList(list.get(0).getValue());
            cabins.put(list.get(0).getKey(), maxSizeProducts);

            //remove
            removeAddedProducts(cabinsWithProducts, maxSizeProducts);

            //recursion
            splitOrder(cabinsWithProducts, cabins);
        }

    }

    private static void removeAddedProducts(Map<String, List<Integer>> cabinsWithProducts, List<Integer> products) {

        for (Map.Entry<String, List<Integer>> entry : cabinsWithProducts.entrySet()) {

            Iterator<Integer> iter = entry.getValue().iterator();
            while (iter.hasNext()) {
                Integer pro = iter.next();
                if (products.contains(pro)) {
                    iter.remove();
                }
            }

        }

        Iterator<String> iterator = cabinsWithProducts.keySet().iterator();
        while (iterator.hasNext()) {
            String cabin = iterator.next();
            if (CollectionUtils.isEmpty(cabinsWithProducts.get(cabin))) {
                iterator.remove();
            }
        }

    }


    private static List<Map.Entry<String, List<Integer>>> sortMapByValueSize(Map<String, List<Integer>> input) {

        //define value comparator
        Comparator<Map.Entry<String, List<Integer>>> comparator = new Comparator<Map.Entry<String, List<Integer>>>() {
            @Override
            public int compare(Map.Entry<String, List<Integer>> o1, Map.Entry<String, List<Integer>> o2) {
                return o2.getValue().size() - o1.getValue().size();
            }
        };

        List<Map.Entry<String, List<Integer>>> list = Lists.newArrayList(input.entrySet());

        Collections.sort(list, comparator);

        return list;
    }


    private static Map<String, List<Integer>> getCabinsWithProducts(Map<Integer, List<String>> productInCabins) {
        Map<String, List<Integer>> cabinsWithProducts = Maps.newHashMap();

        for (Map.Entry<Integer, List<String>> entry : productInCabins.entrySet()) {
            for (String cabin : entry.getValue()) {
                List<Integer> products = cabinsWithProducts.get(cabin);
                if (CollectionUtils.isEmpty(products)) {
                    products = Lists.newArrayList();
                    cabinsWithProducts.put(cabin, products);
                }
                products.add(entry.getKey());
            }
        }
        return cabinsWithProducts;
    }


    public static Map<Integer, List<String>> getProductInCabins(List<Integer> products) {

        Map<Integer, List<String>> cabinsWithPro = Maps.newHashMap();



        return Maps.newHashMap();
    }


}
