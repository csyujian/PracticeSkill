package Practical_Algorigthms;

public class DS2 {
    private static class Data{
        private String id;
        private String name;
        private int age;

        private Data(String id, String name, int age) {
            this.id = id;
            this.name = name;
            this.age = age;
        }
        @Override
        public String toString() {
            return id + "," + name + ","+ age;
        }
    }
    public static class Node{
        private Data data;
        private Node next;

        public Node(String id, String name, int age) {
            this.data = new Data(id,name,age);
        }

        public Node() {

        }

        @Override
        public String toString() {
            return data.toString();
        }
    }
    private Node node = null;
    private int len;

    void init(){
        len = 0;
        node = new Node();
    }
    public int length(){
        return len;
    }
    public void insert(String msg){
        System.out.println("program is inserting ....\n" + "msg :"+msg);
        String[] strings = msg.split(",");
        int id = Integer.parseInt(strings[0]);
        Node t = node;
        if(id > length()){
            id = length();
        }
        for(int i = 0;i < id;i++){
            t = t.next;
        }
        Node temp = new Node(strings[1],strings[2],Integer.parseInt(strings[3]));
        temp.next = t.next;
        t.next = temp;
        len++;
    }
    public void find(int id){
        if(id < len){
            System.out.println("find the " + id + "node success!");
            Node t = node;
            for(int i = 0;i <= id;i++){
                t = t.next;
            }
            System.out.println("msg : " + t.toString());
        }else {
            System.out.println("Cannot find...,maybe out of index");
        }
    }
    public void delete(int id){
        if(id >= len){
            System.out.println("out of index....");
            return;
        }
        Node t = node;
        for(int i = 0;i < id;i++){
            t = t.next;
        }


        Node p = t.next;
        t.next = p.next;
        System.out.println("program is deleting ....\n" + "msg :"+ p.toString());
        p = null;
        len--;
    }
    public void printAll(){
        Node t = node.next;
        for(int i = 0;i < len;i++){
            System.out.println(t.toString());
            t = t.next;
        }
    }

}
