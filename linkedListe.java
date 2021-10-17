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
    boolean break_ = true;
    String text = "";

    for(int i = 1; i < args.length ; i++){
      liste.add(Integer.parseInt(args[i]));
    }
    liste.udskriv();
    while(break_){
      text = s.nextLine();
      switch(text){
        case "Sorter":
          liste.sorter(args.length);
          break;

        case "Stor":
          liste.find(args.length, true);
          break;

        case "Lille":
          liste.find(args.length, false);
          break;

        case "break":
          break_ = false;
          break;

        case "Insert":
          liste.insert(s.nextInt(),s.nextInt());
          break;
      }
    }
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

    void find(int L, boolean findStor){
      Node nu = n1;
      int tal = nu.value;
      if(findStor){
        tal = 0;}
      for(int i = 0 ; i < L; i++){
        if(findStor && nu.value > tal){
          tal = nu.value;
        }
        if(!findStor && nu.value < tal){
          tal = nu.value;
        }
        nu = nu.next;
      }
      System.out.println("Tal er " + tal);
    }

    void sorter(int length){
      Node lavPlads = n1;
      Node lavPladsNr = n1;
      int tempValue;

      for (int t = 0 ; t <length ; t++) {
        lavPlads = lavPladsNr;
        for(int i = t ; i <length ; i++){
          if(lavPladsNr.value > lavPlads.value){
            tempValue = lavPladsNr.value;
            lavPladsNr.value = lavPlads.value;
            lavPlads.value = tempValue;
          }
          lavPlads = lavPlads.next;
        }
        lavPladsNr = lavPladsNr.next;
      }
      udskriv();
    }

  }
}
