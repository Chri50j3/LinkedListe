import java.util.Scanner;

public class linkedListe{
  public static void main(String[] args){

    // opgave 2
    //Node n1 = new Node(1)
    //Node n2 = new Node(2)
    //n1.next = n2;
    //osv...

    Scanner s = new Scanner(System.in);
    LinkedList liste = new LinkedList(Integer.parseInt(args[0]));

    for(int i = 1; i < args.length ; i++){
      liste.add(Integer.parseInt(args[i]));
    }
    liste.udskriv();

    if(s.nextLine().equals("Stor")){
      liste.findStor(args.length);
    }

    liste.insert(s.nextInt(),s.nextInt());

  }

  public static class Node{

    int value;
    Node next;

    Node(int input){
      value = input;
    }

    void print(){
      System.out.println(value);
      if(next != null){
        next.print();
      }
    }
  }

  public static class LinkedList{
    Node n1;

    LinkedList(int first){
      n1 = new Node(first);
    }

    void add(int a){
      Node nyeste = n1;
      while(nyeste.next != null)
        nyeste = nyeste.next;
      nyeste.next = new Node(a);
    }

    void insert(int plads, int a){
      Node nu = n1;
      for(int i = 0 ; i < plads; i++){
       nu = nu.next;
      }
      nu.value = a;
      System.out.println("Updated");
      udskriv();
    }

    void udskriv(){
      n1.print();
    }

    void findStor(int L){
      Node nu = n1;
      int stor = 0;
      for(int i = 0 ; i < L; i++){
        if(nu.value > stor){
          stor = nu.value;
        }
        nu = nu.next;
      }
      System.out.println("Stoerste tal er " + stor);
    }
  }
}
