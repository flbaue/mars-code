package flbaue.playground;

import flbaue.playground.collection.linkedlist.AngleImpl;

import java.util.*;

/**
 * Florian Bauer
 * flo.bauer@gmx.net
 * Date: 06.07.13
 * Time: 17:35
 */
public class PlayTwo {

    public static void main(String[] args) {

        Map<Integer,String> x = new HashMap<>();
        x.put(1,"eins");
        x.put(2,"zwei");

        Map<Integer,String> x2 = new HashMap<>();
        x2.put(3,"drei");

        System.out.println(x);

        Set<Map.Entry<Integer,String>> xEntrys = x.entrySet();

        for(Map.Entry<Integer,String> e : x2.entrySet()){

            xEntrys.add(e);
        }

        System.out.println(x);


        String s = "123";

        //s

//        ContainerSchiff cs = new ContainerSchiff(new ArrayList<Container>(Arrays.asList(new Container[]{new Container("1"),new Container("2"),new Container("3")})));
//
//        Iterator i = cs.iterator();
//
//        int count = 0;
//
//        for(Container c : cs) {
//            count++;
//        }
//
//
//        System.out.println(count);


//         Map<Person,String> phonebook = new TreeMap<>(new Comparator<Person>() {
//             @Override
//             public int compare(Person o1, Person o2) {
//
//                 int result = o1.name.compareTo(o2.name);
//
//                 if(result == 0)
//                     result = o1.vorname.compareTo(o2.vorname);
//
//                 return result;
//             }
//         });
//
//        phonebook.put(new Person("Braun","Hans"),"123");
//        phonebook.put(new Person("Braun","Anna"),"234");
//        phonebook.put(new Person("Muster","Berthold"),"345");
//        phonebook.put(new Person("Werner","Hans"),"456");
//
//        System.out.println(phonebook);



//        Map<String,String> phonebook2 = new TreeMap<>();
//
//        phonebook2.put("Hans","555");
//        phonebook2.put("Anna","234");
//        phonebook2.put("Berthold","345");
//        phonebook2.put("Xander","999");
//
//        Map<String,String> phone = new TreeMap<>();
//
//        phone.putAll(phonebook);
//
//        for(Map.Entry<String,String> e : phonebook2.entrySet()){
//
//          if(phone.containsKey(e.getKey())) {
//              if(phone.get(e.getKey()).compareTo(e.getValue()) < 0) {
//                  phone.put(e.getKey(),e.getValue());
//              }
//          } else {
//              phone.put(e.getKey(),e.getValue());
//          }
//
//        }
//
//        System.out.println(phone);





//        Map<Integer,String> x1 = new HashMap<>();
//
//        x1.put(1,"value2");
//        x1.put(5,"value2");
//        x1.put(3,"value3");
//        x1.put(2,"value3");
//        x1.put(100,"value3");
//        x1.put(0,"value3");
//
//        System.out.println(x1);
//
//        Set<Map.Entry<Integer,String>> x1Entrys = x1.entrySet();
//        Map<String,Integer> x1Revers = new HashMap<>();
//
//        for(Map.Entry<Integer,String> e : x1Entrys) {
//
//            Integer key = e.getKey();
//            String val = e.getValue();
//
//            if(x1Revers.containsKey(val)){
//                if(x1Revers.get(val) < key)
//                    x1Revers.put(val,key);
//            } else {
//                x1Revers.put(val,key);
//            }
//
//        }
//
//        System.out.println(x1Revers);

//        Map<String,String> x2 = new HashMap<>();
//
//        x2.put("key1","value1");
//        x2.put("key4","value4");
//        x2.put("key3","value3");




//
//        for(Map.Entry<String,String> e : x1.entrySet()) {
//
//            System.out.println("key='" + e.getKey() + "'");
//            System.out.println("value='" + e.getValue() + "'");
//
//        }
//
//        System.out.println("contains 'key1'='" + x1.containsKey("key1") + "'");
//        System.out.println("value of 'key2'='" + x1.get("key2") + "'");
//
//
//
//
//
//        Map<String,String> xEql = new HashMap<>();
//
//        Set<Map.Entry<String,String>> x1Entrys = x1.entrySet();
//        Set<Map.Entry<String,String>> x2Entrys = x2.entrySet();
//        Set<Map.Entry<String,String>> xEqlEntrys = new HashSet<>();
//
//        xEqlEntrys.addAll(x1Entrys);
//        xEqlEntrys.retainAll(x2Entrys);
//
//       for(Map.Entry<String,String> e : xEqlEntrys) {
//
//           xEql.put(e.getKey(),e.getValue());
//       }
//
//        System.out.println(xEql);
//


//
//        Collection<Object> elem2111 = new ArrayList<Object>();
//        Collection<Object> elem211 = new ArrayList<Object>();
//        Collection<Object> elem21 = new ArrayList<Object>();
//        Collection<Object> elem22 = new ArrayList<Object>();
//        Collection<Object> elem2 = new ArrayList<Object>();
//        Collection<Object> elem111 = new ArrayList<Object>();
//        Collection<Object> elem11 = new ArrayList<Object>();
//        Collection<Object> elem1 = new ArrayList<Object>();
//
//        Collection<Object> x = new ArrayList<Object>();
//
//        x.add(elem1);
////        x.add(elem2);
//        elem1.add(elem11);
////        elem11.add(elem111);
////        elem2.add(elem21);
//        elem2.add(elem22);
//        elem21.add(elem211);
//        elem211.add(elem2111);


//        System.out.println(depth(x));

//        System.out.println(x);
//        System.out.println("---");
//        System.out.println(deepRevers(x));


//        List<Integer> ints = new ArrayList<Integer>();
//
//        ints.add(1);
//        ints.add(4);
//        ints.add(3);
//        ints.add(5);
//        ints.add(2);
//        ints.add(1);
//
//
//
//        Set<Integer> uniqInts = new HashSet<>(ints);
//        List<Integer> ints2 = new ArrayList<>(uniqInts);
//        ints2.add(6);
//
//        System.out.println(ints2);
//
//        Collections.sort(ints);
//        System.out.println(ints);
//
//        uniqInts = new HashSet<>();
//        uniqInts.addAll(ints);
//        uniqInts.addAll(ints2);
//
//        ints2 = new ArrayList<>(uniqInts);
//        Collections.sort(ints2);
//        System.out.println(ints2);
//
//        List<Integer> ints3 = new ArrayList<>();
//
//        for(ListIterator<Integer> it = ints2.listIterator(ints2.size()); it.hasPrevious(); ) {
//            ints3.add(it.previous());
//        }
//
////        for(int i = ints2.size() - 1; i >= 0; i--) {
////            ints3.add(ints2.get(i));
////        }
//
//        System.out.println(ints3);





        /*String[] blubb = new String[]{"1","zwei","3"};

        Object[]oArry = new Object[3];
        oArry[0] = "Test";
        oArry[1] = 1;
        oArry[2] = AngleImpl.valueOf("3");

        Collection<Object> oColl = Arrays.asList(oArry);

        for(Object o : oColl) {
            System.out.println(o.toString());
        }

        Collection<String> stringColl = Arrays.asList(blubb);

        String[] strings = stringColl.toArray(new String[0]);


        PlayTwo p2 = new PlayTwo();

        System.out.println(p2.fiboRec(0));
        System.out.println(p2.fiboRec(1));
        System.out.println(p2.fiboRec(2));
        System.out.println(p2.fiboRec(3));
        System.out.println(p2.fiboRec(4));
        System.out.println(p2.fiboRec(5));
        System.out.println(p2.fiboRec(6));

        System.out.println("Iter1:");

        System.out.println(p2.fiboIter(0));
        System.out.println(p2.fiboIter(1));
        System.out.println(p2.fiboIter(2));
        System.out.println(p2.fiboIter(3));
        System.out.println(p2.fiboIter(4));
        System.out.println(p2.fiboIter(5));
        System.out.println(p2.fiboIter(6));

        System.out.println("Iter2:");

        System.out.println(p2.fiboIter2(0));
        System.out.println(p2.fiboIter2(1));
        System.out.println(p2.fiboIter2(2));
        System.out.println(p2.fiboIter2(3));
        System.out.println(p2.fiboIter2(4));
        System.out.println(p2.fiboIter2(5));
        System.out.println(p2.fiboIter2(6));*/

    }

    public static int depth(Collection<Object> coll) {

        int maxDepth = 0;

        for (Object o : coll) {
            int currdepth = 0;
            if(o instanceof Collection) {
                currdepth = 1 + depth((Collection<Object>)o);
                if(currdepth > maxDepth)
                    maxDepth = currdepth;

            }

        }

        return maxDepth;
    }

//    public static Collection<Object> deepRevers(Collection<Object> coll) {
//
//        Collection<Object> result = new ArrayList<Object>();
//
//        for(Object o : coll) {
//
//            if(o instanceof Collection) {
//
//                Collection<Object> oC = (Collection<Object>) o;
//
//                if(oC.size() > 0)  {
//
//                    Collection<Object> deep = deepRevers(oC);
//                    oC.removeAll(deep);
//                    deep.
//                }
//                else
//                    result.add(oC) ;
//
//            }
//
//        }
//
//        return result;
//    }

    public int fiboIter2(final int n){

        if(n == 0) return 0;
        if(n == 1) return 1;

        int prevPrev = 0;
        int prev = 1;
        int result = 0;

        for (int i = 2; i <= n; i++) {

            result =  prevPrev + prev;
            prevPrev = prev;
            prev = result;

        }

        return result;
    }



    public int fiboRec(int n) {

        if(n == 0)
            return 0;

        if (n == 1)
            return 1;

        return fiboRec(n - 1) + fiboRec(n - 2);

    }

    public int fiboIter(int n) {

        int prev1 = 0;
        int prev2 = 1;

        for(int i = 0; i < n; i++){
            int oldPrev1 = prev1;
            prev1 = prev2;
            prev2 = oldPrev1 + prev2;



        }

        return prev1;
    }



}
