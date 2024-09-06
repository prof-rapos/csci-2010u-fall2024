public class Chair {
  private int legs;
  private String colour;
  private boolean personSitting;

  public Chair(int legs, String colour, boolean personSitting){
    this.legs = legs;
    this.colour = colour;
    this.personSitting = personSitting;
  }

  public Chair(){
    this.legs = 4;
    this.colour = "blue";
    this.personSitting = false;
  }

  public int getLegs() {
    return legs;
  }

  public String getColour() {
    return colour;
  }

  public boolean isPersonSitting() {
    return personSitting;
  }

  public void setColour(String colour) {
    this.colour = colour;
  }

  public void setPersonSitting(boolean personSitting) {
    this.personSitting = personSitting;
  }

  public void setLegs(int legs) {
    this.legs = legs;
  }

  public void flipChair(){
    this.personSitting = false;
  }


  @Override
  public String toString() {
    String result =  "This " + colour + " chair has " + legs + " legs. ";
    if (this.personSitting) {
      result += "There is someone in this chair.";
    } else {
      result += "The chair is empty.";
    }
    return result;
  }

  public static void main(String[] args) {

    Chair a = new Chair();
    System.out.println(a);
    a.setPersonSitting(true);
    System.out.println(a);
    a.flipChair();
    System.out.println(a);
    Chair b = new Chair(5, "magenta", true);
    System.out.println(b);
  }
}