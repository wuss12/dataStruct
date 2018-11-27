package link;

public class ClassLinkListTest {
    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i=1;i<10;i++){
            linkedList.insertFirst(i);
        }
        linkedList.display();
//        testDeleteFirst(linkedList);
//        testFind(linkedList);
        testDelete(linkedList);
    }

    private static void testDelete(LinkedList<Integer> linkedList) {

        MyNode delete = linkedList.delete(6);
        System.out.println("删除："+delete+"-----------------------");
        linkedList.display();
        delete = linkedList.delete(9);
        System.out.println("删除："+delete+"-----------------------");
        linkedList.display();
        delete = linkedList.delete(1);
        System.out.println("删除："+delete+"-----------------------");
        linkedList.display();
    }

    private static void testFind(LinkedList<Integer> linkedList) {
        testFind(linkedList,6);
        testFind(linkedList,10);
    }

    private static void testFind(LinkedList<Integer> linkedList,Integer value) {
        MyNode find = linkedList.find(value);
        if(find != null){
            System.out.println(find.value);
        }
    }

    private static void testDeleteFirst(LinkedList<Integer> linkedList) {
        while (!linkedList.isEmpty()){
            MyNode<Integer> integerMyNode = linkedList.deleFirst();
            System.out.print("delete: "+ integerMyNode.value);
            System.out.println("--------------------");
            linkedList.display();
        }
    }
}
