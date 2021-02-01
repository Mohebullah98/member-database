import java.io.*;
import java.util.*;
class Bulk{
  
  public static String Modifier;
  public static String first;
  public static String last;
  public static String id;
  public static String id2;

  public static boolean notNumber(String id){
    for(int i=0;i<id.length();i++){
      if(Character.isDigit(id.charAt(i))) continue;
      else return true;
    }
    return false;
  }

  public static void read()throws Exception{
    File A = new File("input.txt");
    File B = new File("Log.txt");
    ArrayList<Member> Arr = new ArrayList<> ();
    HashMap <String,Member> map = new HashMap<>();
    Scanner s = new Scanner(A);
    FileWriter w = new FileWriter(B);
    w.write("------------Action Log--------------");
    while(s.hasNext()){
        Modifier =s.next();
        if(Modifier.equalsIgnoreCase("Add")){
        first = s.next();
        last = s.next();
        id = s.next();
        if(id.length()!=6|| map.get(id)!=null|| notNumber(id)) w.write("\nInvalid ID for "+ first + " "+ last+ " ID NO: "+id);
        else{Member m = new Member(first,last,id);
        Arr.add(m);
        map.put(id,m);
        w.write("\nAdded "+" "+ first + " "+ last + " ID NO: "+ id);
        }}
        if(Modifier.equalsIgnoreCase("Remove")){
          first=s.next();
          last=s.next();
          id=s.next();
          Member m = new Member(first,last,id);
          Member r;
          if(Arr.size()==0) w.write("\nError, no members in dB to remove ");
          else{
            for(int i =0;i<Arr.size();i++){
              r = Arr.get(i);
              if (r.getid().equals(id)){
              Arr.remove(i);
              map.remove(id);
              w.write("\nRemoved "+first + " "+ last +" ID NO:"+id);
              break;
              }
              if(i==Arr.size()-1 && !r.getid().equals(id)) w.write("\nUser "+ first + " " +last + " ID NO:"+ id+ " Does not exist.");
            }
          }
        }
        if(Modifier.equalsIgnoreCase("Modify")){
          first =s.next();
          last = s.next();
          id=s.next();
          id2=s.next();
          Member b;
          for(int i=0;i<Arr.size();i++){
            b=Arr.get(i);
            if(b.getid().equals(id)) {
              b.setid(id2);
              map.put(id2,b);
              map.remove(id);
              w.write("\nModified "+ first + " "+ last+ " ID NO:"+ id + " to ID NO:"+ id2);
            }
          }

        }
        
        

    }
    s.close();
    w.flush();
    System.out.println("Number of users in database:" + map.size());
    for(int i=0;i<Arr.size();i++){
     Member a = Arr.get(i);
     a.toString(a);
    }
  }
}