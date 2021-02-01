class Member{
  private String firstName;
  private String lastName;
  private String id;

  public Member(String first,String last, String i){
    firstName=first;
    lastName=last;
    id=i;
  }
  public String getid(){
    return id;
  }
  public String getfirst(){
    return firstName;
  }
  public String getlast(){
    return lastName;
  }
  public void setid(String i){
    id =i;
  }
  public void toString(Member m){
    System.out.println(m.getfirst() + " "+ m.getlast() + " ID NO: "+ getid()+" ");
  }
}