package com.sky.demo.collect.list;

import com.google.common.collect.Lists;
import com.sky.demo.collect.model.User;
import org.junit.Test;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Created by rg on 2015/6/23.
 */
public class ListTest {

    @Test
    public void test_Iterator1(){
        List<Integer> list = Lists.newArrayList(1, 2, 3);
        System.out.println(list);

        Iterator<Integer> it = list.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }

    @Test
    public void test_Iterator2(){
        List<Integer> list = Lists.newArrayList(1, 2, 3);
        System.out.println(list);

        Iterator<Integer> it = list.iterator();
        System.out.println(it);
        System.out.println(it.next());
        System.out.println(it);
        System.out.println(it.next());

    }

    @Test
    public void test_remove_iterator(){
        List<Integer> list = Lists.newArrayList(1, 2, 3);
        System.out.println(list);

        Iterator<Integer> it = list.iterator();
        while (it.hasNext()) {
            //it.remove();
            System.out.println(it.next());  //next()必须在remove()前调用，否则会越界
            it.remove();
        }
        System.out.println(list);
    }

    @Test
    public void test_remove_for(){
        List<Integer> list = Lists.newArrayList(1, 2, 3);
        System.out.println(list);

        //error 不会删除完list
        for (int i = 0; i < list.size(); ++i) {
            //System.out.println(list.get(i));
            list.remove(i);
        }
        System.out.println(list);
    }

    @Test
    public void test_remove_for_length(){
        List<Integer> list = Lists.newArrayList(1, 2, 3);
        System.out.println(list);

        //error java.lang.IndexOutOfBoundsException: Index: 2, Size: 1
        for (int i = 0, length = list.size() ; i < length; ++i) {
            //System.out.println(list.get(i));
            list.remove(i);
        }
        System.out.println(list);
    }

    @Test
    public void test_remove_foreach(){
        List<Integer> list = Lists.newArrayList(1, 2, 3);
        System.out.println(list);

        //error  java.util.ConcurrentModificationException
        //在一个foreach循环中，编译器会使.next()在删除元素之后被调用，因此抛出ConcurrentModificationException异常
        for (Integer integer : list ) {
            //System.out.println(list.get(i));
            list.remove(integer);
        }
        System.out.println(list);
    }



    //List 插入有序，且允许重复
    //有序指插入时的顺序
    @Test
    public void test_List_is_order(){
        List<Integer> integerList = Lists.newArrayList();
        Random random = new Random();

        for (int i = 0;i < 10;++i){
            Integer integer = random.nextInt();
            System.out.println(integer);
            integerList.add(integer);
        }
        System.out.println(integerList);
    }


    //数组转List
    @Test
    public void test_Array_to_List(){

        Integer[] a = {1,2,3,4,5};
        System.out.println(a);

        //1，遍历数组
        List<Integer> list1 = Lists.newArrayList();
        for (int i =0 ;i < a.length;++i){
            list1.add(a[i]);
        }
        list1.add(6);
        System.out.println(list1);

        //2,Array.asList(),注：不可增删
        List<Integer> list2 = Arrays.asList(a);
        //list2.add(6);
        System.out.println(list2);

        //3,Collections.addAll()
        List<Integer> list3 = Lists.newArrayList();
        Collections.addAll(list3, a);
        list3.add(6);
        System.out.println(list3);

        //4,ArrayList()
        List<Integer> list4 = new ArrayList<Integer>(Arrays.asList(a));
        list4.add(6);
        System.out.println(list4);

        //5,Lists.newArrayList()
        List<Integer> list5 = Lists.newArrayList(Arrays.asList(a));
        list5.add(6);
        System.out.println(list5);

    }


    @Test
    public void test_sort_by_name() {

        List<User> list = Lists.newArrayList();
        User user1 = new User(1,"11");
        User user2 = new User(2, null);      //当有两个是空串时，可以处理，但是如果是null 则抛异常
        User user3 = new User(3, null);
        list.add(user1);

        list.add(user3);
        list.add(user2);

        System.out.println("before :" + list);
        Collections.sort(list,new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
        System.out.println("after :" + list);
    }


    @Test
    public void test_stream_filter_by_predicate() {

        List<User> users = Lists.newArrayList(new User(1, "zhang"), new User(4, "hao"), new User(3, "li"));
        List<User> existedUsers = Lists.newArrayList(new User(1, "zhang"), new User(2, "wang"), new User(3, "li"));

        Predicate<User> filterCommon = c -> existedUsers.stream().anyMatch(u -> u.getId().equals(c.getId()));
        List<User> needUpdateUsers = users.stream().filter(filterCommon).collect(Collectors.toList());
        System.out.println(needUpdateUsers);


        Predicate<User> filterDifference = c -> existedUsers.stream().noneMatch(u -> u.getId().equals(c.getId()));
        List<User> needAddUsers = users.stream().filter(filterDifference).collect(Collectors.toList());
        System.out.println(needAddUsers);
    }

    @Test
    public void test_stream_filter() {

        List<User> users = Lists.newArrayList(new User(1, "zhang"), new User(4, "hao"), new User(3, "li"));
        List<User> existedUsers = Lists.newArrayList(new User(1, "zhang"), new User(2, "wang"), new User(3, "li"));

        Set<Integer> commonIds = existedUsers.stream().map(User::getId).collect(Collectors.toSet());
        List<User> needUpdateUsers = users.stream().filter(user -> commonIds.contains(user.getId())).collect(Collectors.toList());
        System.out.println(needUpdateUsers);

        List<User> needAddUsers = users.stream().filter(user -> !commonIds.contains(user.getId())).collect(Collectors.toList());
        System.out.println(needAddUsers);
    }

}
