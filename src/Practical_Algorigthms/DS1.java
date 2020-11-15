package Practical_Algorigthms;



public class DS1 {
    void init(){
        nodes = new DS1.Node[10000];
        index = 0;
    }
    private static class Node{
        private String id;
        private String name;
        private int age;

        private Node(String id, String name, int age) {
            this.id = id;
            this.name = name;
            this.age = age;
        }
        private Node(Node a){
            this.id = a.id;
            this.name = a.name;
            this.age = a.age;
        }
        @Override
        public String toString() {
            return id + "," + name + ","+ age;
        }
    }
    private  Node[] nodes;
    private int index = 0;
    public int length(){
        return index;
    }
    void find(int id){
        if(id < index){
            System.out.println("find the " + id + "node success!");
            System.out.println(nodes[id]);
        }else {
            System.out.println("Cannot find...,maybe out of index");
        }
    }
    void insert(String msg){
        System.out.println("program is inserting ....\n" + "msg :"+msg);
        String[] strings = msg.split(",");
        int id = Integer.parseInt(strings[0]);
        if(id > index){
            id = index;
        }
        for(int i = index - 1;i >= id;i--){
            nodes[i + 1] = new Node(nodes[i]);
        }
        nodes[id] = new Node(strings[1],strings[2],Integer.parseInt(strings[3]));
        index++;
    }
    void delete(int id){
        if(id >= index){
            System.out.println("out of index....");
            return;
        }
        System.out.println("program is deleting ....\n" + "msg :"+nodes[id]);
        for(int i = id ;i < index - 1;i++){
            nodes[i] = new Node(nodes[i + 1]);
        }
        index--;
    }
    void printAll(){
        for(int i = 0;i < length();i++){
            System.out.println(nodes[i]);
        }
    }
}

